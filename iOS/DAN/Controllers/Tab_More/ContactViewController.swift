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

class ContactViewController: UIViewController {

    @IBOutlet weak var webSiteButton:   UIButton!
    @IBOutlet weak var supportButton:   UIButton!
    @IBOutlet weak var contactLabel:    UILabel!
    @IBOutlet weak var mailButton:      UIButton!
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "contact_title".localized
        
        webSiteButton.setTitleColor(UIColor.orange_orangeInnovation(), for: .normal)
        supportButton.setTitleColor(UIColor.orange_orangeInnovation(), for: .normal)
        mailButton.setTitleColor(UIColor.orange_orangeInnovation(), for: .normal)
        
        webSiteButton.setTitle("contact_webSite".localized, for: .normal)
        supportButton.setTitle("contact_support".localized, for: .normal)
        contactLabel.text   = "contact_contactTeam".localized
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    @IBAction func webSiteButtonPressed(_ sender: AnyObject) {
        
        UIApplication.shared.openURL(URL(string: "https://a11y-guidelines.orange.com/fr/")!)
    }
    
    @IBAction func supportButtonPressed(_ sender: AnyObject) {
        
        UIApplication.shared.openURL(URL(string: "https://github.com/Orange-OpenSource/a11y-guidelines")!)
    }
    
    @IBAction func contactButtonPressed(_ sender: AnyObject) {
        
        UIApplication.shared.openURL(URL(string: "mailto:accessibility.support@orange.com")!)
    }

}
