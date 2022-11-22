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
import WebKit
import DeclarationAccessibility

class OrangeAccessibilityViewController: UIViewController, WKNavigationDelegate, WKUIDelegate {

    @IBOutlet weak var myOrangeLabel:   UILabel!
    
    let webView = WKWebView()
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        title = "orange_accessibility_nav_title".localized
        
        /*
        let language = Bundle.main.preferredLocalizations.first! as NSString
        let fileName = "mdan_" + (language as String)
        let url = URL(fileURLWithPath: Bundle.main.path(forResource: fileName, ofType: "html")!)
        let urlRequest = URLRequest(url: url)
        webView.load(urlRequest)
        webView.navigationDelegate = self
        view = webView
         */
        
        let declarationViewController = DeclarationViewController()
        let language = Bundle.main.preferredLocalizations.first! as NSString
        let fileName = "mdan_" + (language as String)
        declarationViewController.declarations.detailUrl = fileName
        declarationViewController.declarations.identityName = "ORANGE SA"
        declarationViewController.declarations.identityAdresse = "Siège social : 111, quai du Président Roosevelt, 92130 Issy-les-Moulineaux"
        declarationViewController.xmlPath = "accessibility_result"
        self.embed(declarationViewController, inView: view)
        setUpNavigationBarClose()

    }
    
    func setUpNavigationBarClose() {
        navigationItem.largeTitleDisplayMode = .never
             //navigationController?.navigationBar.prefersLargeTitles = false
        self.navigationController?.navigationBar.tintColor = UIColor.orange_orangeInnovation()
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        webView.frame = view.bounds
    }
}
