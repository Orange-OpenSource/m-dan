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

class TextualAlternativeTextImageViewController: DefaultTableViewController {
    
    let textCellIdentifier      = "textCell"
    let textImageCellIdentifier = "textImageCell"
    let accessibleSection       = 1

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let btnName = UIButton()
        btnName.setImage(UIImage(named: "icon_infos"), for: UIControlState())
        btnName.accessibilityLabel = "common_informationButton".localized
        btnName.tintColor = UIColor.white
        btnName.frame = CGRect(x: 0, y: 0, width: 20, height: 20)
        btnName.addTarget(self, action: #selector(displayVoiceOverMessage(_:)), for: .touchUpInside)
        
        let rightBarButton = UIBarButtonItem(customView: btnName)
        self.navigationItem.rightBarButtonItem = rightBarButton
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        cellsContent = [
            ["example_textualAlternative_textImage_description"],
            [""],
            [""]
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
            
            let cell = tableView.dequeueReusableCell(withIdentifier: textImageCellIdentifier, for: indexPath) as! TextImageTableViewCell
            
            if (indexPath as NSIndexPath).section == accessibleSection { // accessible
                //cell.isAccessibilityElement  = false
                cell.mailImageView.accessibilityLabel      = cell.badgeLabel.text! + " " + "example_textualAlternative_textImage_accessibilityLabel".localized
            }
            
            return cell
        }
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == 0 {
            return UITableViewAutomaticDimension
        }
        
        return 88
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return 88
    }
}
