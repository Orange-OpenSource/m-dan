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

class GhostElementViewController: UIViewController {
    
    @IBOutlet var speedDescriptionHeaderLabel:  DefaultLabelHeader!
    @IBOutlet var nonAccessibleHeaderLabel:     DefaultLabelHeader!
    @IBOutlet var accessibleHeaderLabel:        DefaultLabelHeader!
    @IBOutlet var descriptionLabel:             UILabel!
    
    @IBOutlet weak var nonAccesibleButton:  UIButton!
    @IBOutlet weak var accessibleButton:    UIButton!
    @IBOutlet weak var popUpVIew:           UIView!
    @IBOutlet weak var popUpContainerView:  UIView!
    @IBOutlet weak var customAlertLabel:    UILabel!
    @IBOutlet weak var customAlertButton:   UIButton!
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        speedDescriptionHeaderLabel.text    = "common_description".localized
        nonAccessibleHeaderLabel.text       = "common_notAccessibleExample".localized
        accessibleHeaderLabel.text          = "common_accessibleExample".localized
        descriptionLabel.text               = "example_ghostElement_alert_description".localized
        customAlertLabel.text               = "example_ghostElement_alert_nonAccessibleAlerteTitle".localized

        nonAccesibleButton.setTitle("example_ghostElement_alert_buttonText".localized, for: UIControlState())
        accessibleButton.setTitle("example_ghostElement_alert_buttonText".localized, for: UIControlState())
        customAlertButton.setTitle("common_ok".localized, for: UIControlState())
        
        nonAccesibleButton.layer.cornerRadius   = 5
        accessibleButton.layer.cornerRadius     = 5
        popUpContainerView.layer.cornerRadius   = 5
        
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
    }
    
    // MARK: - Private methods
    @IBAction func displayDefaultAlert() {
        
        let alert = UIAlertController(title: "example_ghostElement_alert_accessibleAlerteTitle".localized, message: "example_ghostElement_alert_accessibleAlerteMessage".localized, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "common_ok".localized, style: .default, handler: nil))
        
        self.present(alert, animated: true, completion: nil)
        
        alert.view.tintColor = .orange_orangeForWhiteBG()
    }
    
    @IBAction func displayCustomAlert() {
        
        popUpVIew.isHidden = false
        self.navigationController!.navigationBar.isUserInteractionEnabled = false
    }

    @IBAction func hideCustomAlert(_ sender: AnyObject) {
        
        popUpVIew.isHidden = true
        self.navigationController!.navigationBar.isUserInteractionEnabled = true
    }
    
    func displayVoiceOverMessage(_ sender: UIBarButtonItem) {
        let alert = UIAlertController(title: "common_alertVoiceOverTitle".localized, message: "common_alertVoiceOver".localized, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "common_ok".localized, style: .default, handler: nil))
        
        self.present(alert, animated: true, completion: nil)
        
        alert.view.tintColor = .orange_orangeForWhiteBG()
    }
}
