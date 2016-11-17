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
fileprivate func < <T : Comparable>(lhs: T?, rhs: T?) -> Bool {
  switch (lhs, rhs) {
  case let (l?, r?):
    return l < r
  case (nil, _?):
    return true
  default:
    return false
  }
}

fileprivate func > <T : Comparable>(lhs: T?, rhs: T?) -> Bool {
  switch (lhs, rhs) {
  case let (l?, r?):
    return l > r
  default:
    return rhs < lhs
  }
}


class SlideshowViewController: UIViewController {

    var isAccessible = false
    var isFullScreen = false

    @IBOutlet weak var controlsView:    UIView!
    @IBOutlet weak var playButton:      UIButton!
    @IBOutlet weak var closeButton:     UIButton!
    @IBOutlet weak var previousButton:  UIButton!
    @IBOutlet weak var nextButton:      UIButton!
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if !isAccessible {
            
            perform(#selector(SlideshowViewController.enterFullscreen), with: nil, afterDelay: 0.5)
        }
        
        closeButton.isHidden                  = !isAccessible
        playButton.accessibilityLabel       = "example_contentControl_slideshow_playButtonLabel".localized
        closeButton.accessibilityLabel      = "example_contentControl_slideshow_closeButtonLabel".localized
        previousButton.accessibilityLabel   = "example_contentControl_slideshow_previousButtonLabel".localized
        nextButton.accessibilityLabel       = "example_contentControl_slideshow_nextButtonLabel".localized
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        
        super.viewDidAppear(animated)
        
        NotificationCenter.default.addObserver(self, selector: #selector(SlideshowViewController.voiceOverStatusDidChange(_:)), name: NSNotification.Name(rawValue: UIAccessibilityVoiceOverStatusChanged), object: nil)
    }

    override func viewWillDisappear(_ animated: Bool) {
        
        super.viewWillDisappear(animated)
        
        NotificationCenter.default.removeObserver(UIAccessibilityVoiceOverStatusChanged)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    func enterFullscreen() {
        
        UIView.animate(withDuration: 0.5, animations: { () -> Void in
            
            self.navigationController?.navigationBar.alpha      = 0
            self.tabBarController?.tabBar.alpha                 = 0
            self.controlsView.alpha                             = 0
            self.closeButton.alpha                              = self.isAccessible && UIAccessibilityIsVoiceOverRunning() ? 1 : 0
        }) 
        
        isFullScreen = true
    }
    
    func exitFullScreen() {
        
        self.closeButton.alpha = 0
        
        UIView.animate(withDuration: 0.5, animations: { () -> Void in
            
            self.navigationController?.navigationBar.alpha      = 1
            self.tabBarController?.tabBar.alpha                 = 1
            self.controlsView.alpha                             = 1
        }) 
        
        isFullScreen = false
    }
    
    // MARK: - User interaction
    @IBAction func playButtonPressed(_ sender: UIButton) {
    
        enterFullscreen()
    }
    
    @IBAction func closeButtonPressed(_ sender: AnyObject) {
    
        exitFullScreen()
    }
    
    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
            
        if touches.first?.tapCount > 1 {
            return
        }
        
        perform(Selector(isFullScreen ? "exitFullScreen" : "enterFullscreen"))
    }
    
    // MARK: - VoiceOver notifications
    func voiceOverStatusDidChange(_ notification: Notification) {
        
        self.closeButton.alpha = self.isAccessible && isFullScreen && UIAccessibilityIsVoiceOverRunning() ? 1 : 0
    }
}
