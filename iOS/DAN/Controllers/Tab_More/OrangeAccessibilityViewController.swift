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
import DeclarationAccessibility

class OrangeAccessibilityViewController: UIViewController {

    @IBOutlet weak var myOrangeLabel:   UILabel!

    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        title = "orange_accessibility_nav_title".localized
        setupDeclaration()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    private func setupDeclaration() {
        let declarationViewController = DeclarationViewController()
        self.show(declarationViewController, sender: nil)
        navigationController?.setNavigationBarHidden(false, animated: false)
        declarationViewController.declarations.detailUrl = "https://a11y-guidelines.orange.com/fr/"
        declarationViewController.declarations.identityName = "ORANGE SA"
        declarationViewController.declarations.identityAdresse = "Siège social : 111, quai du Président Roosevelt, 92130 Issy-les-Moulineaux"
    }
}
