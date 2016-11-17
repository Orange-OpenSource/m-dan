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

class DeveloperViewController: DefaultTableViewController {
    
    //MARK: - Properties
    let textCellIdentifier      = "textCell"
    let optionCellIdentifier    = "optionCell"

    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    // MARK: - Private methods
    override func setUpDatas() {
        
        title = "tab_developer_title".localized
        
        sectionHeaders = [
            "developer_section_description",
            "developer_section_options",
        ]
        
        cellsContent = [
            ["developer_description_cell"],
            [
                "textualAlternative",
                "elementsSemantic",
                "hideItems",
                "triggerVocalization",
                "accessibilityOptionsState",
                "notifyChangeOnPage",
                "changeVocalization",
                "changeVoiceOverFocus",
                "groupItems",
                "systemEvents",
                "textSize",
                "readingOrder"
            ]
        ]
    }
    
    // MARK: TableViewDelegate
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        
        if((indexPath as NSIndexPath).section == 0) {
            
            let textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            
            let cell: UITableViewCell

            cell                    = tableView.dequeueReusableCell(withIdentifier: optionCellIdentifier, for: indexPath)
            cell.textLabel?.text    = ("developer_option_"+cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row]).localized
            cell.textLabel?.font = UIFont.boldSystemFont(ofSize: 16.0)
            
            return cell
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if((indexPath as NSIndexPath).section == 0) {
            
            return 100
        }
        else {
            
            return 44
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        let cell:UITableViewCell                        = sender as! UITableViewCell
        let destinationVC : DeveloperOptionViewController  = segue.destination as! DeveloperOptionViewController
        let optionNumber                                = ((tableView.indexPath(for: cell) as NSIndexPath?)?.row)!+1
        let optionsCount                                = tableView.dataSource?.tableView(tableView, numberOfRowsInSection: ((tableView.indexPath(for: cell) as NSIndexPath?)?.section)!)
        let optionKey                                   = cellsContent[((tableView.indexPath(for: cell) as NSIndexPath?)?.section)!][((tableView.indexPath(for: cell) as NSIndexPath?)?.row)!]

        destinationVC.title = "common_option".localized + " \(optionNumber)/\(optionsCount!)"
        destinationVC.optionKey = optionKey
        destinationVC.cellsContent = [
            [""],
            [""]
        ]
    }
}
