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

import Foundation
import WebKit

class LegalNoticeViewController: UIViewController, WKNavigationDelegate, WKUIDelegate {
    
    var webView = WKWebView()
    
    // MARK: - View life cycle
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "legal_notice_nav_title".localized
        
        let language = Bundle.main.preferredLocalizations.first! as NSString
        let fileName = "legal_notice_" + (language as String)
        let url = URL(fileURLWithPath: Bundle.main.path(forResource: fileName, ofType: "html")!)
        let urlRequest = URLRequest(url: url)
        webView.load(urlRequest)
        webView.navigationDelegate = self
        view = webView
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        webView.frame = view.bounds
    }
}

extension LegalNoticeViewController {
    func webView(_ webView: WKWebView, decidePolicyFor navigationAction: WKNavigationAction,
                 decisionHandler: @escaping (WKNavigationActionPolicy) -> Void) {
        guard
            let url = navigationAction.request.url,
            let scheme = url.scheme else {
                decisionHandler(.cancel)
                return
            }
        
        if (scheme.lowercased() == "mailto") {
            UIApplication.shared.open(url, options: [:], completionHandler: nil)
            decisionHandler(.cancel)
            return
        }
        decisionHandler(.allow)
    }
}
