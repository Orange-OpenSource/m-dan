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

class AboutViewController: UIViewController, UIWebViewDelegate {

    @IBOutlet weak var subtitleLabel:   UILabel!
    @IBOutlet weak var webview:   UIWebView!
    @IBOutlet weak var container:   UIView!
    @IBOutlet weak var scroll:   UIScrollView!
    
    
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        view.backgroundColor = UIColor.white
        
        title = "about_title".localized
        subtitleLabel.text  = "about_companyText".localized
        
        let language = Bundle.main.preferredLocalizations.first! as NSString
        let fileName = "about_" + (language as String)
        let url = URL(fileURLWithPath: Bundle.main.path(forResource: fileName, ofType: "html")!)
        let urlRequest = URLRequest(url: url)
        webview.delegate = self
        webview.scrollView.isScrollEnabled = false
        webview.scrollView.bounces = false
        webview.loadRequest(urlRequest)
        webview.isUserInteractionEnabled = true
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - UIWebViewDelegate
    func webViewDidFinishLoad(_ webView: UIWebView) {
        
        var frame = webView.frame
        frame.size.height = 1
        webView.frame = frame
        let fittingSize = webView.sizeThatFits(CGSize.zero)
        frame.size = fittingSize
        webView.frame = frame

        
        scroll.contentSize.height = frame.size.height + 200
        //container.frame.size.height = scroll.contentSize.height

    }
    
    func webView(_ webView: UIWebView, shouldStartLoadWith request: URLRequest, navigationType: UIWebView.NavigationType) -> Bool {
        if navigationType == UIWebView.NavigationType.linkClicked {
            UIApplication.shared.openURL(request.url!)
            return false
        }
        return true
    }

}
