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
import DeclarationAccessibility

class MoreViewController: DefaultTableViewController {

    
    let textCellIdentifier = "defaultCell"
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        title = "tab_plus_title".localized
        
        cellsContent = [
            [
                "plus_menu_home",
                "plus_menu_orangeAccessibility",
                "plus_menu_cgu",
                "plus_menu_legal_notice",
                "plus_menu_other_application",
                "plus_menu_contact",
                "plus_menu_about"
            ]
        ]
        
        sectionHeaders = [""]
    }
    
    // MARK: TableViewDelegate
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        tableView.rowHeight = UITableView.automaticDimension
        tableView.estimatedRowHeight = 44.0
        
        let cell = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath)
        
        cell.textLabel?.text    = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
        cell.textLabel?.numberOfLines = 0
        cell.sizeToFit()
        cell.textLabel?.sizeToFit()
        cell.textLabel?.lineBreakMode = .byWordWrapping
        cell.accessoryType      = .disclosureIndicator
                
        return cell
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        
        return 0
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        let cell = tableView.cellForRow(at: indexPath)
        
        switch (indexPath as NSIndexPath).row {
            
        case 0:
            performSegue(withIdentifier: "introduction-segue", sender: cell)
        case 1:
            performSegue(withIdentifier: "orange-accessibility-segue", sender: cell)
        case 2:
            performSegue(withIdentifier: "cgu-segue", sender: cell)
        case 3:
            performSegue(withIdentifier: "legal-segue", sender: cell)
        case 4:
            self.openURL("other_application_url".localized)
        case 5:
            performSegue(withIdentifier: "contact-segue", sender: cell)
        case 6:
            performSegue(withIdentifier: "about-segue", sender: cell)
         
        default:
            performSegue(withIdentifier: "default-segue", sender: cell)
        }
    }
}

