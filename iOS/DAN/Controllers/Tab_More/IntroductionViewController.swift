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

class IntroductionViewController: UIViewController {

    @IBOutlet weak var titleLabel:      UILabel!
    @IBOutlet weak var subtitleLabel:   UILabel!
    @IBOutlet weak var headerLabel1:    UILabel!
    @IBOutlet weak var headerLabel2:    UILabel!
    @IBOutlet weak var headerLabel3:    UILabel!
    @IBOutlet weak var textView1:       UITextView!
    @IBOutlet weak var textView2:       UITextView!
    @IBOutlet weak var textView3:       UITextView!
    @IBOutlet weak var imageView:       UIImageView!
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "common_accessibility".localized
        
        navigationItem.largeTitleDisplayMode = .never
        
        titleLabel.text     = "common_DAN".localized
        subtitleLabel.text  = "common_accessibilityDemonstrator".localized
        headerLabel1.text   = "intro_header1".localized
        headerLabel2.text   = "intro_header2".localized
        headerLabel3.text   = "intro_header3".localized
        textView1.text      = "intro_text1".localized
        textView2.text      = "intro_text2".localized
        textView3.text      = "intro_text3".localized
        
        // the following three-lines should in theory have no effect.
        // but in fact, they ensure that the UIImageView
        // correctly applies its tintColor to the vector template image
        self.imageView.tintColorDidChange()

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
}
