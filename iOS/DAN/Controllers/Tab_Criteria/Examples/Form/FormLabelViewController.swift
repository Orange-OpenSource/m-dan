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

class FormLabelViewController: DefaultTableViewController, UITextFieldDelegate {

    let textCellIdentifier      = "textCell"
    let formCellIdentifier      = "formCell"
    let notAccessibleSection    = 2
    let accessibleSection       = 1
    

    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(hideKeyboard))
        tapGesture.cancelsTouchesInView = true
        tableView.addGestureRecognizer(tapGesture)
        
        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayVoiceOverMessage(_:)))
    }
    
    @objc func hideKeyboard() {
        tableView.endEditing(true)
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
            ["example_form_label_description"],
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
            
            let cell: FormTableViewCell = tableView.dequeueReusableCell(withIdentifier: formCellIdentifier, for: indexPath) as! FormTableViewCell
            
            cell.textfieldView.accessibilityLabel = "example_form_label_textfield_accessibilityLabel".localized
            cell.textfieldView.placeholder = "example_form_label_textfield_placeholder".localized
            
            if (indexPath as NSIndexPath).section == notAccessibleSection {
                
                cell.textfieldView.accessibilityLabel = ""
                cell.memorySwitch.accessibilityLabel = ""
                cell.buttonView.accessibilityLabel = ""
            }
            else {
                cell.memoryLabel.text = "example_form_label_memory".localized
                cell.buttonView.titleLabel?.text = "example_form_label_valid".localized
            }
            
            cell.textfieldView.delegate = self
            cell.formView.layer.borderWidth = 2
            cell.formView.layer.borderColor = UIColor.label.cgColor
            
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == notAccessibleSection || (indexPath as NSIndexPath).section == accessibleSection {
            return 142
        }
        else {
            return UITableView.automaticDimension
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
    //MARK: - UITextFieldDelegate
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {

        textField.resignFirstResponder()
        return true
    }
}
