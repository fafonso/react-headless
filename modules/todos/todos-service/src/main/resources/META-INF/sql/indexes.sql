create index IX_E697E208 on JB_TodoItem (companyId, groupId);
create index IX_713C2FFA on JB_TodoItem (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A2246CFC on JB_TodoItem (uuid_[$COLUMN_LENGTH:75$], groupId);