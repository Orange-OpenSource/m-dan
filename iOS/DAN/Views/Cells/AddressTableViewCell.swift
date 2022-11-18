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

class AddressTableViewCell: UITableViewCell {

    @IBOutlet weak var deliveringAddressLabel:  UILabel!
    @IBOutlet weak var addressLabel:            UILabel!
    @IBOutlet weak var switchLabel:             UILabel!
    @IBOutlet weak var addressSwitch:           UISwitch!
    @IBOutlet weak var billingAddressLabel:     UILabel!
    @IBOutlet weak var addressTextfield:        UITextField!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
        addressSwitch.onTintColor   = .orange_orangeInnovation()
        addressSwitch.tintColor     = .orange_orangeInnovation()
        addressTextfield.tintColor  = .orange_orangeInnovation()
        
        isAccessibilityElement = false
        shouldGroupAccessibilityChildren = true
        accessibilityElements = [deliveringAddressLabel, addressLabel, addressSwitch]
    }
}
