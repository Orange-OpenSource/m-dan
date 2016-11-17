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

class TabCustomTableViewCell: UITableViewCell {   
    
    @IBOutlet var onePageButton: UIButton!
    @IBOutlet var twoPageButton: UIButton!
    @IBOutlet var threePageButton: UIButton!
    
    var buttonList:Array<UIButton> = []
    var accessible = false
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        buttonList.append(onePageButton)
        buttonList.append(twoPageButton)
        buttonList.append(threePageButton)
        
        buttonClicked(onePageButton)
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    @IBAction func buttonClicked(_ sender: AnyObject) {
        
        for button:UIButton in buttonList {
            
            if button == sender as! UIButton {
                button.isSelected = true
                if accessible {
                    button.accessibilityTraits = UIAccessibilityTraitButton + UIAccessibilityTraitSelected
                }
                button.setTitleColor(UIColor.orange_orangeForWhiteBG(), for: UIControlState.selected)
                button.tintColor = UIColor.clear
            }
            else {
                button.isSelected = false
                if accessible {
                    button.accessibilityTraits = UIAccessibilityTraitNone
                    button.accessibilityTraits = UIAccessibilityTraitButton
                }
                button.setTitleColor(UIColor.orange_blackColor(), for: UIControlState())
            }
        }
    }
    
    func accessibleSegmentedControl() {
        
        onePageButton.accessibilityTraits = UIAccessibilityTraitButton + UIAccessibilityTraitSelected
        twoPageButton.accessibilityTraits = UIAccessibilityTraitButton
        threePageButton.accessibilityTraits = UIAccessibilityTraitButton
        
        
        onePageButton.accessibilityHint = "1 " + "common_of".localized + " " + String(buttonList.count)
        twoPageButton.accessibilityHint = "2 " + "common_of".localized + " " + String(buttonList.count)
        threePageButton.accessibilityHint = "3 " + "common_of".localized + " " + String(buttonList.count)
    }
    
    func nonAccessibleButton() {
        
        for button:UIButton in buttonList {
            button.accessibilityTraits = UIAccessibilityTraitNone
            button.accessibilityHint = ""
        }
    }
    
    

}
