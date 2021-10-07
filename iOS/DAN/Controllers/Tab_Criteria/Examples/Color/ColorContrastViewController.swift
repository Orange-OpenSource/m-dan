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

class ColorContrastViewController: DefaultTableViewController {

    let textCellIdentifier      = "textCell"
    let subtitleCellIdentifier  = "subtitleCell"
    let accessibleSection       = 1

    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        sectionHeaders = [
            "common_description",
            "common_accessibleExample",
            "common_notAccessibleExample"
        ]
        
        cellsContent = [
            ["example_color_contrast_description"],
            ["example_color_contrast_cellTitleAccessible", "example_color_contrast_cellTitleAccessible"],
            ["example_color_contrast_cellTitleNonAccessible", "example_color_contrast_cellTitleNonAccessible"]
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
            
            let cell: UITableViewCell = tableView.dequeueReusableCell(withIdentifier: subtitleCellIdentifier, for: indexPath)
            
            cell.accessoryType              = .none
            cell.isUserInteractionEnabled     = false
            cell.textLabel?.numberOfLines   = 0
            cell.textLabel?.textColor = (indexPath as NSIndexPath).section == accessibleSection ? .colorWithHex(0x000000) : .colorWithHex(0x999999)
            cell.textLabel?.text            = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            cell.detailTextLabel?.text      = (indexPath as NSIndexPath).section == accessibleSection ? "example_color_contrast_cellSubtitleAccessible".localized : "example_color_contrast_cellSubtitleNonAccessible".localized
            cell.detailTextLabel?.textColor = (indexPath as NSIndexPath).section == accessibleSection ? .colorWithHex(0x333333) : .colorWithHex(0xDDDDDD)
            
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {

        return 44
    }
}
