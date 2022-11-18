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

class RemoteControlTableViewCell: UITableViewCell {

    @IBOutlet var zeroButton: UIButton!
    @IBOutlet var oneButton: UIButton!
    @IBOutlet var twoButton: UIButton!
    @IBOutlet var threeButton: UIButton!
    @IBOutlet var fourButton: UIButton!
    @IBOutlet var fiveButton: UIButton!
    @IBOutlet var sixButton: UIButton!
    @IBOutlet var sevenButton: UIButton!
    @IBOutlet var heightButton: UIButton!
    @IBOutlet var nineButton: UIButton!
    
    @IBOutlet var remoteView: UIView!
    
    @IBOutlet var volumeView: UIView!
    @IBOutlet var volumePlusButton: UIButton!
    @IBOutlet var volumeMinusButton: UIButton!
    
    @IBOutlet var channelView: UIView!
    @IBOutlet var channelPlusButton: UIButton!
    @IBOutlet var channelMinusButton: UIButton!
    
    func renderAccessible() {
            
        remoteView.isAccessibilityElement = false
        remoteView.shouldGroupAccessibilityChildren = true
            
        remoteView.accessibilityElements = []
        remoteView.accessibilityElements?.append(oneButton)
        remoteView.accessibilityElements?.append(twoButton)
        remoteView.accessibilityElements?.append(threeButton)
        remoteView.accessibilityElements?.append(fourButton)
        remoteView.accessibilityElements?.append(fiveButton)
        remoteView.accessibilityElements?.append(sixButton)
        remoteView.accessibilityElements?.append(sevenButton)
        remoteView.accessibilityElements?.append(heightButton)
        remoteView.accessibilityElements?.append(nineButton)
        remoteView.accessibilityElements?.append(zeroButton)
            
        remoteView.accessibilityElements?.append(volumePlusButton)
        remoteView.accessibilityElements?.append(volumeMinusButton)
        volumePlusButton.accessibilityLabel  = "example_readingOrder_remoteControl_volumePlus".localized
        volumeMinusButton.accessibilityLabel = "example_readingOrder_remoteControl_volumeMinus".localized
            
        remoteView.accessibilityElements?.append(channelPlusButton)
        remoteView.accessibilityElements?.append(channelMinusButton)
        channelPlusButton.accessibilityLabel  = "example_readingOrder_remoteControl_channelPlus".localized
        channelMinusButton.accessibilityLabel = "example_readingOrder_remoteControl_channelMinus".localized
            
        isAccessibilityElement = false
        shouldGroupAccessibilityChildren = true
        accessibilityElements = remoteView.accessibilityElements
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        // Initialization code
        
        zeroButton.layer.cornerRadius = 22
        oneButton.layer.cornerRadius = 22
        twoButton.layer.cornerRadius = 22
        threeButton.layer.cornerRadius = 22
        fourButton.layer.cornerRadius = 22
        fiveButton.layer.cornerRadius = 22
        sixButton.layer.cornerRadius = 22
        sevenButton.layer.cornerRadius = 22
        heightButton.layer.cornerRadius = 22
        nineButton.layer.cornerRadius = 22
        
        remoteView.layer.cornerRadius = 10
        volumeView.layer.cornerRadius = 22
        channelView.layer.cornerRadius = 22
        
        //Color
        volumePlusButton.backgroundColor = UIColor.orange_orangeInnovation()
        volumeMinusButton.backgroundColor = UIColor.orange_orangeInnovation()
        channelPlusButton.backgroundColor = UIColor.orange_orangeInnovation()
        channelMinusButton.backgroundColor = UIColor.orange_orangeInnovation()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
