import ClayTabs from '@clayui/tabs';
import React, {useState} from 'react';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';

import UserEntries from '../../entry/UserEntries';


const Tabs = () => {
   const [activeTabKeyValue, setActiveTabKeyValue] = useState(0);

   return (
       <div>
           <ClayTabs modern>
             <ClayTabs.Item
               active={activeTabKeyValue == 0}
               innerProps={{
                 "aria-controls": "tabpanel-1"
               }}
               onClick={() => setActiveTabKeyValue(0)}
             >
               {"Tab 1"}
             </ClayTabs.Item>
             <ClayTabs.Item
               active={activeTabKeyValue == 1}
               innerProps={{
                 "aria-controls": "tabpanel-2"
               }}
               onClick={() => setActiveTabKeyValue(1)}
             >
               {"Tab 2"}
             </ClayTabs.Item>
             <ClayTabs.Item
               active={activeTabKeyValue == 2}
               innerProps={{
                 "aria-controls": "tabpanel-3"
               }}
               onClick={() => setActiveTabKeyValue(2)}
             >
               {"Tab 3"}
             </ClayTabs.Item>
           </ClayTabs>
           <ClayTabs.Content activeIndex={activeTabKeyValue} fade>
             <ClayTabs.TabPane aria-labelledby="tab-1">

                 <Router>
                     <Switch>
                         <Route component={UserEntries} exact path="/" />
                     </Switch>
                 </Router>

             </ClayTabs.TabPane>
             <ClayTabs.TabPane aria-labelledby="tab-2">
               {`2. Proin efficitur imperdiet dolor, a iaculis orci lacinia eu. Proin pulvinar facilisis purus vitae ornare. Donec ut sodales sapien. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec id volutpat ligula. Sed sodales pellentesque aliquam. Donec interdum a mi ac auctor. Etiam auctor lacus nec posuere feugiat. Maecenas pulvinar ante nisl, auctor fringilla quam molestie eu. Sed non ultrices est. Ut congue leo in placerat pharetra.`}
             </ClayTabs.TabPane>
             <ClayTabs.TabPane aria-labelledby="tab-3">
               {`3. Proin efficitur imperdiet dolor, a iaculis orci lacinia eu. Proin pulvinar facilisis purus vitae ornare. Donec ut sodales sapien. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec id volutpat ligula. Sed sodales pellentesque aliquam. Donec interdum a mi ac auctor. Etiam auctor lacus nec posuere feugiat. Maecenas pulvinar ante nisl, auctor fringilla quam molestie eu. Sed non ultrices est. Ut congue leo in placerat pharetra.`}
             </ClayTabs.TabPane>
           </ClayTabs.Content>
        </div>
   );
 };

 export default Tabs;