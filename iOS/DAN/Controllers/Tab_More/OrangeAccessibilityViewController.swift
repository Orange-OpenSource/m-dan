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

class OrangeAccessibilityViewController: UIViewController {

    @IBOutlet weak var titleLabel:      UILabel!
    @IBOutlet weak var headerLabel:     UILabel!
    @IBOutlet weak var textView:        UITextView!
    @IBOutlet weak var myLiveboxLabel:  UILabel!
    @IBOutlet weak var myNetworkLabel:  UILabel!
    @IBOutlet weak var myOrangeLabel:   UILabel!
    @IBOutlet weak var liveboxButton:   UIButton!
    @IBOutlet weak var networkButton:   UIButton!
    @IBOutlet weak var orangeButton:    UIButton!
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        title = "orange_nav_title".localized
        
        titleLabel.text     = "orange_title".localized
        headerLabel.text    = "orange_header".localized
        textView.text       = "orange_text".localized
        myLiveboxLabel.text = "orange_myLivebox".localized
        myNetworkLabel.text = "orange_myNetwork".localized
        myOrangeLabel.text  = "orange_myOrange".localized
        
        liveboxButton.accessibilityLabel    = "orange_myLivebox".localized
        networkButton.accessibilityLabel    = "orange_myNetwork".localized
        orangeButton.accessibilityLabel     = "orange_myOrange".localized

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    @IBAction func myLiveboxButtonPressed(_ sender: AnyObject) {
        
        UIApplication.shared.openURL(URL(string: "itms://itunes.apple.com/fr/app/ma-livebox/id445573616?mt=8&ign-mpt=uo%3D4")!)
    }
    
    @IBAction func myNetworkButtonPressed(_ sender: AnyObject) {
        
        UIApplication.shared.openURL(URL(string: "itms://itunes.apple.com/fr/app/mon-reseau/id286597170?mt=8")!)
    }
    
    @IBAction func myOrangeButtonPressed(_ sender: AnyObject) {
        
        UIApplication.shared.openURL(URL(string: "itms://itunes.apple.com/fr/app/orange-et-moi-lespace-client/id367722531?mt=8")!)
    }
}
