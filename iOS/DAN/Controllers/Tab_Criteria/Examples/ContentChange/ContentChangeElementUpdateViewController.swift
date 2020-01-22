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

class ContentChangeElementUpdateViewController: DefaultTableViewController, UITextFieldDelegate {

    let textCellIdentifier      = "textCell"
    let addressCellIdentifier   = "addressCell"
    let accessibleSection       = 1
    
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(ContentChangeElementUpdateViewController.hideKeyboard))
        tapGesture.cancelsTouchesInView = true
        tableView.addGestureRecognizer(tapGesture)
        
        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayVoiceOverMessage(_:)))
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    @objc func hideKeyboard() {
        tableView.endEditing(true)
    }
    
    override func setUpDatas() {
        
        sectionHeaders = [
            "common_description",
            "common_accessibleExample",
            "common_notAccessibleExample"
        ]
        
        cellsContent = [
            ["example_contentChange_elementUpdate_description"],
            [""],
            [""]
        ]
    }
    
    @objc func switchStateDidChange(_ addressSwitch: UISwitch) {
  
        tableView.beginUpdates()
        tableView.endUpdates()

        let cell = tableView.cellForRow(at: IndexPath(row: 0, section: addressSwitch.tag)) as? AddressTableViewCell
       
        cell?.addressTextfield.isHidden       = addressSwitch.isOn
        cell?.billingAddressLabel.isHidden    = addressSwitch.isOn
        
        if (addressSwitch.isOn) { hideKeyboard()}
        
        if addressSwitch.tag == accessibleSection && !addressSwitch.isOn {
            
            UIAccessibility.post(notification: UIAccessibility.Notification.layoutChanged, argument: cell?.addressTextfield)
            
            //print("test" + String(cell?.accessibilityElementCount()));
        }
        
        cell?.isAccessibilityElement = false
        cell?.shouldGroupAccessibilityChildren = true
        cell?.accessibilityElements? = []
        cell?.accessibilityElements?.append((cell?.deliveringAddressLabel)!)
        cell?.accessibilityElements?.append((cell?.addressLabel)!)
        cell?.accessibilityElements?.append((cell?.addressSwitch)!)
        cell?.accessibilityElements?.append((cell?.addressTextfield)!)
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
            
            let addressCell: AddressTableViewCell = tableView.dequeueReusableCell( withIdentifier: addressCellIdentifier, for: indexPath) as! AddressTableViewCell
            
            addressCell.deliveringAddressLabel.text     = "example_contentChange_elementUpdate_deliveryAddress".localized
            addressCell.switchLabel.text                = "example_contentChange_elementUpdate_switchTitle".localized
            addressCell.addressSwitch.accessibilityLabel  = "example_contentChange_elementUpdate_switchTitle".localized
            addressCell.billingAddressLabel.text        = "example_contentChange_elementUpdate_billingAddress".localized
            addressCell.addressTextfield.placeholder    = "example_contentChange_elementUpdate_billingAddress".localized
            addressCell.addressSwitch.tag               = (indexPath as NSIndexPath).section
            
            addressCell.addressSwitch.addTarget(self, action: #selector(ContentChangeElementUpdateViewController.switchStateDidChange(_:)), for: .valueChanged)
            
            let placeholder = NSAttributedString(string: "example_contentChange_elementUpdate_placeholder".localized, attributes: [NSAttributedString.Key.foregroundColor:UIColor.colorWithHex(0x666666)])
            addressCell.addressTextfield.attributedPlaceholder = placeholder

            return addressCell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            return UITableView.automaticDimension
        }
        else {
            
            if let cell = tableView.cellForRow(at: indexPath) as? AddressTableViewCell {
                
                if cell.addressSwitch.isOn {
                    
                    return 160;
                    
                } else {
                    
                    return 225;
                }
            }
            else {
                
                return 160;
            }
            
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return 100
    }
    
    // MARK: - UITextFieldDelegate
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true;
    }
    
}
