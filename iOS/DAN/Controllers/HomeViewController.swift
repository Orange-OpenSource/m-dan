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

class HomeViewController: UIViewController {
    
    @IBOutlet weak var logoImageView:   UIImageView!
    @IBOutlet weak var titleLabel:      UILabel!
    @IBOutlet weak var subTitleLabel:   UILabel!
    @IBOutlet weak var textLabel:       UILabel!
    @IBOutlet weak var criteriaImgView: UIImageView!
    @IBOutlet weak var devImgView:      UIImageView!
    @IBOutlet weak var voiceoverImgView:UIImageView!
    @IBOutlet weak var optionsImgView:  UIImageView!
    @IBOutlet weak var criteriaLabel:   UILabel!
    @IBOutlet weak var devLabel:        UILabel!
    @IBOutlet weak var voiceoverLabel:  UILabel!
    @IBOutlet weak var optionsLabel:    UILabel!
    @IBOutlet weak var criteriaView:    UIView!
    @IBOutlet weak var devView:         UIView!
    @IBOutlet weak var voiceoverView:   UIView!
    @IBOutlet weak var optionsView:     UIView!
    @IBOutlet weak var plusButton:    UIButton!
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "home_title".localized
        logoImageView.tintColorDidChange()
        criteriaImgView.tintColorDidChange()
        devImgView.tintColorDidChange()
        voiceoverImgView.tintColorDidChange()
        optionsImgView.tintColorDidChange()
        
        criteriaView.accessibilityLabel = "home_criteria_button".localized
        devView.accessibilityLabel = "home_dev_button".localized
        voiceoverView.accessibilityLabel = "home_voiceover_button".localized
        optionsView.accessibilityLabel = "home_options_button".localized
        
        //criteriaButton.setTitleColor(UIColor.orange_orangeForWhiteBG(), forState: .Highlighted)
        
        titleLabel.text     = "common_DAN".localized
        subTitleLabel.text  = "common_accessibilityDemonstrator".localized
        textLabel.text      = "home_content".localized
        criteriaLabel.text  = "home_criteria_button".localized
        devLabel.text       = "home_dev_button".localized
        voiceoverLabel.text = "home_voiceover_button".localized
        optionsLabel.text   = "home_options_button".localized

        plusButton.accessibilityLabel = "tab_plus_title_accessibilityLabel".localized
        plusButton.setTitle("...", for: UIControlState())
        plusButton.setTitleColor(UIColor.white, for: UIControlState())
        plusButton.setTitleColor(UIColor.orange_orangeForBlackBG(), for: UIControlState.highlighted)
        plusButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 16.0)
        plusButton.frame = CGRect(x: 0, y: 0, width: 20, height: 20)
    }
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}
