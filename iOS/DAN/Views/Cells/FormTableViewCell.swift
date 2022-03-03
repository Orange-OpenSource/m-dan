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

class FormTableViewCell: UITableViewCell, UITextFieldDelegate {

    @IBOutlet var formView: UIView!
    @IBOutlet var textfieldView: UITextField!
    @IBOutlet var memoryLabel: UILabel!
    @IBOutlet var memorySwitch: UISwitch!
    @IBOutlet var buttonView: UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        // Initialization code
        formView.layer.cornerRadius = 10
        
        formView.isAccessibilityElement = false
        formView.shouldGroupAccessibilityChildren = true
        formView.accessibilityElements = []
        formView.accessibilityElements?.append(textfieldView as Any)
        formView.accessibilityElements?.append(memorySwitch as Any)
        formView.accessibilityElements?.append(buttonView as Any)
        
        // Color
        buttonView.setTitleColor(UIColor.orange_orangeForWhiteText(), for: .normal)
        memorySwitch.onTintColor = UIColor.orange_orangeForWhiteText()
        textfieldView.tintColor = UIColor.orange_orangeForWhiteText()
        
        memorySwitch.accessibilityLabel = memoryLabel.text
        //Correction d'un bug générant une double vocalisation du bouton "valider"
        //formView.accessibilityElements?.append(buttonView)
        
        isAccessibilityElement = false
        shouldGroupAccessibilityChildren = true
        accessibilityElements = formView.accessibilityElements
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
}
