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

class ImageIllustrationViewController: DefaultTableViewController {
    
    let textCellIdentifier      = "textCell"
    let imageIllustrationCellIdentifier = "imageIllustrationCell"
    let accessibleSection       = 1
    let notAccessibleSection    = 2
    
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
            "common_description",
            "common_accessibleExample",
            "common_notAccessibleExample"
        ]
        
        cellsContent = [
            ["example_image_illustration_description"],
            [""],
            [""]
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
            
            let cell: ImageIllustrationTableViewCell = tableView.dequeueReusableCell(withIdentifier: imageIllustrationCellIdentifier, for: indexPath) as! ImageIllustrationTableViewCell
            
            if (indexPath as NSIndexPath).section == notAccessibleSection {
                cell.notAccessibilityConfiguration()
            }
            
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
}

// ---------------------------------------------------------------------------
// Cell
// ---------------------------------------------------------------------------
class ImageIllustrationTableViewCell: UITableViewCell {
    
    @IBOutlet var generalView: UIView!
    @IBOutlet var customImageView: UIImageView!
    @IBOutlet var editImageButton: UIButton!
    @IBOutlet var parameterButton: UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        generalView.layer.cornerRadius = 10.0
        generalView.clipsToBounds = true
        
        customImageView.isAccessibilityElement = false
        parameterButton.accessibilityLabel = "example_image_illustration_parameter_accessibilityLabel".localized
        parameterButton.tintColor = UIColor.orange_orangeInnovation()
        editImageButton.accessibilityLabel = "example_image_illustration_edit_accessibilityLabel".localized
        editImageButton.tintColor = UIColor.orange_orangeInnovation()
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
    
    func notAccessibilityConfiguration() {
        
        parameterButton.accessibilityLabel = ""
        editImageButton.accessibilityLabel = ""
        
        customImageView.isAccessibilityElement = true
        customImageView.accessibilityLabel = "example_image_illustration_accessibilityLabel".localized
    }
    
}


