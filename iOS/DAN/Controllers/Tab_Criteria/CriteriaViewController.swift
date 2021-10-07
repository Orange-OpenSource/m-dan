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

class CriteriaViewController: DefaultTableViewController {

    //MARK: - Properties
    let textCellIdentifier      = "textCell"
    let subtextCellIdentifier   = "subtextCell"
    let categoryCellIdentifier  = "categoryCell"
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        title = "tab_criteria_title".localized
        
        cellsContent = [
            ["criteria_description_cell"],
            [
                "image",
                "color",
                "textualAlternative",
                "titleAndHeader",
                "elementState",
                "standardComponents",
                "clickZone",
                "ghostElement",
                //"textSize",
                "contentControl",
                "contentChange",
                "horizontalScroll",
                "form",
                "readingOrder",
                "language",
                "voiceOver"
            ]
        ]
        
        sectionHeaders = [
            "criteria_section_description",
            "criteria_section_category",
        ]
    }
    
    // MARK: - TableView DataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if((indexPath as NSIndexPath).section == 0) {
            
            let textCell: DoubleTextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! DoubleTextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            textCell.label.textColor = UIColor.black
            textCell.label2.text = "criteria_description_options_cell".localized
            textCell.label2.textColor = UIColor.orange_orangeForBlackText()
            
            return textCell
        } else {
            
            var cell: UITableViewCell

            cell                    = tableView.dequeueReusableCell(withIdentifier: categoryCellIdentifier, for: indexPath)
            cell.textLabel?.text    = ("criteria_category_"+cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row]).localized
            
            return cell
        }
    }
    
    // MARK: - TableView Delegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        if((indexPath as NSIndexPath).section == 0) {
            
            return 100
        }
        else {
            
            return 44
        }
    }
    
    // MARK: - StoryBoard
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        let cell:UITableViewCell                = sender as! UITableViewCell
        let categoryVC : CategoryViewController = segue.destination as! CategoryViewController
        categoryVC.title                        = cell.textLabel?.text
        categoryVC.categoryKey                  = cellsContent[((tableView.indexPath(for: cell) as NSIndexPath?)?.section)!][((tableView.indexPath(for: cell) as NSIndexPath?)?.row)!]
        
    }

}
