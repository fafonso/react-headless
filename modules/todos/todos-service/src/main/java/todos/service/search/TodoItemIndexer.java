package todos.service.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import todos.model.TodoItem;
import todos.service.TodoItemLocalService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;


@Component(
        immediate = true,
        service = Indexer.class
)
public class TodoItemIndexer extends BaseIndexer<TodoItem> {

    public static  interface FIELDS{
        public static final String TODO_ITEM_ID = "todoItemId";
    }

    public TodoItemIndexer() {

        setDefaultSelectedFieldNames(
                Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.UID, Field.USER_ID,
                FIELDS.TODO_ITEM_ID, Field.CREATE_DATE, Field.NAME, Field.DESCRIPTION);
        setFilterSearch(true);
        setStagingAware(false);
        setPermissionAware(false);
    }

    @Override
    protected void doDelete(TodoItem todoItem) throws Exception {
        deleteDocument(todoItem.getCompanyId(), todoItem.getTodoItemId());
    }

    @Override
    protected Document doGetDocument(TodoItem todoItem) throws Exception {

        Document document = getBaseModelDocument(CLASS_NAME, todoItem);;
        document.addKeyword(Field.NAME, todoItem.getName());
        document.addKeyword(Field.TITLE, todoItem.getName());
        document.addKeyword(Field.DESCRIPTION, todoItem.getDescription());
        document.addKeyword(Field.COMPANY_ID, todoItem.getCompanyId());
        document.addKeyword(FIELDS.TODO_ITEM_ID, todoItem.getTodoItemId());

        return document;
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale, String snippet, javax.portlet.PortletRequest portletRequest, javax.portlet.PortletResponse portletResponse) throws Exception {
        String prefix = Field.SNIPPET + "_";
        String title = document.get(prefix + Field.NAME, Field.NAME);
        String content = HtmlUtil.stripHtml(document.get(prefix + Field.DESCRIPTION, Field.DESCRIPTION));

        Summary summary = new Summary(title, content);
        summary.setMaxContentLength(200);

        return summary;
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        TodoItem softwareEntry = _todoItemLocalService.getTodoItem(classPK);
        doReindex(softwareEntry);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        long companyId = GetterUtil.getLong(ids[0]);

        reindexTodoItems(companyId);
    }

    @Override
    protected void doReindex(TodoItem todoItem) throws Exception {
        Document document = getDocument(todoItem);
        _indexWriterHelper.updateDocument(getSearchEngineId(), todoItem.getCompanyId(), document,
                isCommitImmediately());
    }

    protected void reindexTodoItems(long companyId) throws PortalException {

        final IndexableActionableDynamicQuery indexableActionableDynamicQuery = _todoItemLocalService
                .getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setCompanyId(companyId);

        indexableActionableDynamicQuery
                .setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<TodoItem>() {

                    @Override
                    public void performAction(TodoItem todoItem) {

                        try {
                            Document document = getDocument(todoItem);
                            indexableActionableDynamicQuery.addDocuments(document);
                        } catch (PortalException pe) {
                            if (_log.isWarnEnabled()) {
                                _log.warn("Unable to index todoItem " + todoItem.getTodoItemId(), pe);
                            }
                        }
                    }
                });

        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
        indexableActionableDynamicQuery.performActions();
    }

    private List<Long> parseIds(String value){

        List<Long> rs = new ArrayList<>();

        if(value != null && value.length() > 0){

            String[] values = null;
            try {
                values = value.split("\\,");
            }catch (Exception e) {
                _log.error("ERROR: parseIds splitting value", e);
            }
            if(values != null) {
                for (String val : values) {
                    try {
                        rs.add(Long.parseLong(val));
                    }catch (Exception e) {
                        _log.error("ERROR: parseIds - unable parse value to Long - " + val , e);
                    }
                }
            }
        }

        return rs;
    }

    @Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter, SearchContext searchContext) throws Exception {

       BooleanQuery filterBooleanQuery = new BooleanQueryImpl();

       filterBooleanQuery.addExactTerm(Field.NAME, searchContext.getKeywords());

        addExactFilterTerm(searchContext.getCompanyId(), Field.COMPANY_ID, filterBooleanQuery, searchContext );
        addExactFilterTerm(searchContext.getGroupIds()[0], Field.GROUP_ID, filterBooleanQuery, searchContext );


        searchQuery.add(filterBooleanQuery, BooleanClauseOccur.MUST);
    }

    private boolean addExactFilterTerm(Object filtersParam, String fieldName, BooleanQuery searchQuery, SearchContext searchContext) throws Exception {
        boolean added = false;

        BooleanQuery fieldsBooleanQuery = new BooleanQueryImpl();

        if(filtersParam != null) {
            if(filtersParam instanceof Boolean){
                BooleanQuery fieldBooleanQuery = new BooleanQueryImpl();
                fieldBooleanQuery.addRequiredTerm(fieldName, (Boolean)filtersParam);

                fieldsBooleanQuery.add(fieldBooleanQuery, BooleanClauseOccur.SHOULD);

                added = true;
            }
            if(filtersParam instanceof String){
                BooleanQuery fieldBooleanQuery = new BooleanQueryImpl();
                fieldBooleanQuery.addRequiredTerm(fieldName, (String)filtersParam);

                fieldsBooleanQuery.add(fieldBooleanQuery, BooleanClauseOccur.SHOULD);

                added = true;
            }

            if(filtersParam instanceof Long){
                BooleanQuery fieldBooleanQuery = new BooleanQueryImpl();
                fieldBooleanQuery.addRequiredTerm(fieldName, (Long)filtersParam);

                fieldsBooleanQuery.add(fieldBooleanQuery, BooleanClauseOccur.SHOULD);

                added = true;
            }
        }

        if(added) {
            searchQuery.add(buildFullTextSearchQuery(fieldsBooleanQuery, searchContext), BooleanClauseOccur.MUST);
        }

        return added;
    }

    private BooleanQuery buildFullTextSearchQuery(BooleanQuery fieldBooleanQuery, SearchContext searchContext) throws Exception {

        BooleanQuery searchFieldQuery = new BooleanQueryImpl();
        addFulltextSearchTerms(searchFieldQuery , searchContext);

        BooleanQuery fieldSearchBooleanQuery = new BooleanQueryImpl();
        fieldSearchBooleanQuery.add(fieldBooleanQuery, BooleanClauseOccur.MUST);
        fieldSearchBooleanQuery.add(searchFieldQuery, BooleanClauseOccur.MUST);

        return fieldSearchBooleanQuery;
    }

    private void addFulltextSearchTerms(BooleanQuery searchQuery, SearchContext searchContext) throws Exception {
        addSearchTerm(searchQuery, searchContext, Field.NAME, false);
        addSearchTerm(searchQuery, searchContext, Field.DESCRIPTION, false);
        addSearchTerm(searchQuery, searchContext, Field.TITLE, false);

    }


    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    private static final String CLASS_NAME = TodoItem.class.getName();

    @Reference
    private TodoItemLocalService _todoItemLocalService;

    @Reference
    protected IndexWriterHelper _indexWriterHelper;

    private static final Log _log = LogFactoryUtil.getLog(TodoItem.class);

}
