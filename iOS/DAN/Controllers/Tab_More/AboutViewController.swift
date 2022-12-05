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

class AboutViewController: UIViewController, WKNavigationDelegate, WKUIDelegate {
    
    let webView = WKWebView()
    var activityIndicator = UIActivityIndicatorView()
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "about_title".localized
        
        self.loadActivityIndicatorView()
        navigationItem.largeTitleDisplayMode = .never
        let language = Bundle.main.preferredLocalizations.first! as NSString
        let fileName = "about_" + (language as String)
        let url = URL(fileURLWithPath: Bundle.main.path(forResource: fileName, ofType: "html")!)
        let urlRequest = URLRequest(url: url)
        webView.load(urlRequest)
        webView.navigationDelegate = self
        webView.backgroundColor = .systemBackground
        webView.isOpaque = false
        view = webView
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        webView.frame = view.bounds
    }
    
    func loadActivityIndicatorView() {
        if #available(iOS 13.0, *) {
            activityIndicator = UIActivityIndicatorView(style: .large)
        } else {
            activityIndicator = UIActivityIndicatorView(style: .gray)
        }
        
        activityIndicator.center = view.center
        webView.addSubview(activityIndicator)
        activityIndicator.startAnimating()
    }
}

extension AboutViewController {
    func webView(_ webView: WKWebView, didStartProvisionalNavigation navigation: WKNavigation!) {
        activityIndicator.startAnimating()
        webView.isOpaque = false
    }
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        activityIndicator.stopAnimating()
        webView.isOpaque = true
    }
    func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
        activityIndicator.stopAnimating()
        webView.isOpaque = true
    }
}
