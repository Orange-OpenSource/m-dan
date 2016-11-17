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

class VoiceOverViewController: DefaultTableViewController {

    //MARK: - Properties
    let textCellIdentifier      = "descCell"
    let creditCellIdentifier    = "gestureCell"

    
    let descriptionSection      = 0
    let activationSection       = 1
    let gestureSection          = 2
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    // MARK: - Private methods
    override func setUpDatas() {

        title = "tab_voiceover_title".localized

        sectionHeaders = [
            "common_description",
            "common_activation",
            "common_use"
        ]
        
        cellsContent = [
            ["voiceover_text_desctription"],
            ["voiceover_text_activation"],
            ["voiceover_text_use"],
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == gestureSection {
            var textAndButtonCell: TextAndButtonTableViewCell
            
            textAndButtonCell            = tableView.dequeueReusableCell(withIdentifier: creditCellIdentifier, for: indexPath) as! TextAndButtonTableViewCell
            textAndButtonCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            textAndButtonCell.button.setTitle("voiceover_gestures".localized, for: UIControlState())
            
            return textAndButtonCell
            
        } else {
            var textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized

            
            if (indexPath as NSIndexPath).section == activationSection {
                
                let cellString      = NSMutableAttributedString(string:cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized)
                let settingsPath    = NSMutableAttributedString(string:"voiceover_text_settingsPath".localized, attributes: [NSFontAttributeName : UIFont.boldSystemFont(ofSize: 16.0)])
                
                cellString.append(settingsPath)
                
                textCell.label.attributedText = cellString
            }
            
            return textCell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if((indexPath as NSIndexPath).section == 0) {
            
            return 100
        }
        else {
            
            return 44
        }
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableViewAutomaticDimension
    }
    
    /*override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        if (indexPath as NSIndexPath).section == linksSection {
            
            UIApplication.shared.openURL(URL(string:appleDocUrl)!)
        }
        else if (indexPath as NSIndexPath).section == useSection {
            
            UIApplication.shared.openURL(URL(string:cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row] == "voiceover_imagesLicense" ? imagesLicenseURL : imagesCreditURL)!)
        }
    }*/
}
