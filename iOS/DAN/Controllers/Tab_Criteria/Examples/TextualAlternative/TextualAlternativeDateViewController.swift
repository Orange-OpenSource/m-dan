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

class TextualAlternativeDateViewController: DefaultTableViewController {

    let textCellIdentifier      = "textCell"
    let defaultCellIdentifier   = "defaultCell"
    let accessibleSection       = 1
    
    var formattedDateAccessible:String = ""

    override func viewDidLoad() {
        super.viewDidLoad()

        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayVoiceOverMessage(_:)))
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        let date = Date()
        
        let formattedDate = DateFormatter.localizedString(
            from: date,
            dateStyle: .short,
            timeStyle: .short)
        
        formattedDateAccessible = DateFormatter.localizedString(
            from: date,
            dateStyle: .long,
            timeStyle: .none)
        
        let formatter           = DateFormatter()
        formatter.dateFormat    = "HH '\("common_hour".localized)' mm"
        formattedDateAccessible += " " + formatter.string(from: date)
        
        cellsContent = [
            ["example_textualAlternative_date_description"],
            [formattedDate, "example_textualAlternative_date_rdv".localized, "example_textualAlternative_date_app_accessibilityLabel".localized, "example_textualAlternative_date_label".localized],
            [formattedDate, "example_textualAlternative_date_rdv".localized]
        ]
        
        sectionHeaders = [
            "common_description",
            "common_accessibleExample",
            "common_notAccessibleExample"            
        ]

    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            let textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            
            let cell = tableView.dequeueReusableCell(withIdentifier: defaultCellIdentifier, for: indexPath) as UITableViewCell
            
            cell.accessoryType              = .none
            cell.isUserInteractionEnabled     = true
            cell.textLabel?.numberOfLines   = 1
            
            // Date
            if((indexPath as NSIndexPath).row == 0) {
                cell.textLabel?.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row]
                if((indexPath as NSIndexPath).section == accessibleSection) { // accessible
                    cell.textLabel?.accessibilityLabel = formattedDateAccessible;
                }
            }
            // Abréviation
            else if((indexPath as NSIndexPath).row == 1) {
                
                cell.textLabel?.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
                
                if (indexPath as NSIndexPath).section == accessibleSection { // accessible
                    cell.textLabel?.accessibilityLabel = "example_textualAlternative_date_rdv_accessibilityLabel".localized
                }else{
                    cell.textLabel?.accessibilityLabel = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
                }
            }
            else if((indexPath as NSIndexPath).row == 2) {
                cell.textLabel?.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            }
            else if((indexPath as NSIndexPath).row == 3) {
                cell.textLabel?.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            }
            else if((indexPath as NSIndexPath).row == 4) {
                cell.textLabel?.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            }
            
            
            
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {

        return 44
    }
}
