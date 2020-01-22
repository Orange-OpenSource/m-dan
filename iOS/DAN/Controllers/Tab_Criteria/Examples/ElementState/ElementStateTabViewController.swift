/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import UIKit

class ElementStateTabViewController: DefaultTableViewController {
    
    let textCellIdentifier          = "textCell"
    let tabCellIdentifier           = "tabCell"
    let tabCustomCellIdentifier     = "tabCustomCell"
    
    let accessibleSection           = 1
    let notAccessibleCustomSection  = 2
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayVoiceOverMessage(_:)))
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        sectionHeaders = [
            "example_elementState_tab_shortDescription",
            "common_accessibleExample",
            "common_notAccessibleCustomExample"
        ]
        
        cellsContent = [
            ["example_elementState_tab_description"],
            [""],
            [""]
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            let cell: TextTableViewCell = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            cell.label.text             = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            return cell
        }
        else if (indexPath as NSIndexPath).section == accessibleSection {
            
            let cell: TabTableViewCell = tableView.dequeueReusableCell(withIdentifier: tabCellIdentifier, for: indexPath) as! TabTableViewCell
            return cell
        }
        else {
            
            let cell: TabCustomTableViewCell = tableView.dequeueReusableCell(withIdentifier: tabCustomCellIdentifier, for: indexPath) as! TabCustomTableViewCell
            cell.nonAccessibleButton()
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            return UITableView.automaticDimension
        }
        else {
            
            return 70;
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            return 100
        }
        else {
            
            return 70;
        }
    }
    
}
