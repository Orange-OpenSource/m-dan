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

class ElementStateSelectionListViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet var shortDescriptionHeaderLabel:      DefaultLabelHeader!
    @IBOutlet var descriptionLabel:                 UILabel!
    @IBOutlet var scrollView:                       UIScrollView!
    @IBOutlet var accessibleTableView:              UITableView!
    @IBOutlet var accessibleHeaderLabel:            DefaultLabelHeader!
    @IBOutlet var nonAccessibleTableView:           UITableView!
    @IBOutlet var nonAccessibleHeaderLabel:         DefaultLabelHeader!
    
    let personCellIdentifier            = "personCellIdentifier"
    var accessibleSelectedRow:Int       = -1
    var nonAccessibleSelectedRow:Int    = -1
    
    var cellsContent = [
        ["Jo", "example_elementState_selectionList_cell_man".localized],
        ["Martine", "example_elementState_selectionList_cell_woman".localized],
        ["Vincent", "example_elementState_selectionList_cell_man".localized]
    ]
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        accessibleHeaderLabel.text      = "common_accessibleExample".localized
        accessibleHeaderLabel.accessibilityTraits = UIAccessibilityTraits.header
        nonAccessibleHeaderLabel.text   = "common_notAccessibleExample".localized
        nonAccessibleHeaderLabel.accessibilityTraits = UIAccessibilityTraits.header
        
        shortDescriptionHeaderLabel.text    = "example_elementState_selectionList_shortDescription".localized
        shortDescriptionHeaderLabel.textColor = UIColor.label
        shortDescriptionHeaderLabel.accessibilityTraits = UIAccessibilityTraits.header
        descriptionLabel.text               = "example_elementState_selectionList_description".localized
        
        // Remove cell separators for empty cells
        nonAccessibleTableView.tableFooterView  = UIView()
        accessibleTableView.tableFooterView     = UIView()
        
        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayVoiceOverMessage(_:)))
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: - TableView DataSource
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1;
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return cellsContent.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        if(tableView == accessibleTableView) {
            
            if accessibleSelectedRow == (indexPath as NSIndexPath).row {
                accessibleSelectedRow = -1
            }
            else {
                accessibleSelectedRow = (indexPath as NSIndexPath).row
            }
            
            accessibleTableView.reloadData()
        }
        else {
            
            let personCell: PersonTableViewCell
            personCell = tableView.cellForRow(at: indexPath) as! PersonTableViewCell
            
            if nonAccessibleSelectedRow == (indexPath as NSIndexPath).row {
                nonAccessibleSelectedRow = -1
                personCell.checkmarkImageView.isHidden = false
            }
            else {
                nonAccessibleSelectedRow = (indexPath as NSIndexPath).row
                personCell.checkmarkImageView.isHidden = true
            }
            
            nonAccessibleTableView.reloadData()
        }
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let personCell: PersonTableViewCell
            
        personCell                      = tableView.dequeueReusableCell(withIdentifier: personCellIdentifier, for: indexPath) as! PersonTableViewCell
        let firstname:String            = cellsContent[(indexPath as NSIndexPath).row][0]
        personCell.firstnameLabel.text  = firstname
        personCell.genderLabel.text     = cellsContent[(indexPath as NSIndexPath).row][1]
        personCell.initialLabel.text    = String(firstname[firstname.startIndex])
        personCell.accessoryType        = .none
        personCell.accessibilityHint    = "example_elementState_selectionList_cell_clickToSelect".localized
        
        if(tableView == accessibleTableView) {
            if((indexPath as NSIndexPath).row == accessibleSelectedRow) {
                personCell.accessoryType = .checkmark
                personCell.tintColor = UIColor.orange_orangeInnovation()
            }
            else {
                personCell.accessoryType = .none
            }
        }
        else {
            if((indexPath as NSIndexPath).row == nonAccessibleSelectedRow) {
                //personCell.accessoryType = .Checkmark
                personCell.checkmarkImageView.isHidden = false
            }
            else {
                //personCell.accessoryType = .None
                personCell.checkmarkImageView.isHidden = true
            }
        }
        
        return personCell
    }

    // MARK: - TableViewDelegate
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
               
        return 66
    }
    
    @objc func displayVoiceOverMessage(_ sender: UIBarButtonItem) {
        let alert = UIAlertController(title: "common_alertVoiceOverTitle".localized, message: "common_alertVoiceOver".localized, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "common_ok".localized, style: .default, handler: nil))
        
        self.present(alert, animated: true, completion: nil)
        
        alert.view.tintColor = .orange_orangeForWhiteBG()
    }

}
