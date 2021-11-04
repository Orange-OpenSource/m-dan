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

class DeveloperOptionViewController: DefaultTableViewController, UIWebViewDelegate {

    //MARK: - Properties
    let webviewLinksCellIdentifier  = "webviewLinksCell"
    //let descriptionSection          = 0
    let webviewCellIdentifier       = "webviewCell"
    var contentHeights : [CGFloat]  = [0.0, 0.0]
    var optionKey                   = ""
    var reload : [Bool]          = [false, false]
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        sectionHeaders = [
            "common_description", "common_links"
        ]

    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if ((indexPath as NSIndexPath).section == 0) {
            
            let webviewCell        = tableView.dequeueReusableCell(withIdentifier: webviewCellIdentifier, for: indexPath) as! WebviewTableViewCell
            
            let language = Bundle.main.preferredLocalizations.first! as NSString
            let fileName = optionKey + "_" + (language as String)
            let url = URL(fileURLWithPath: Bundle.main.path(forResource: fileName, ofType: "html")!)
            let urlRequest = URLRequest(url: url)
            webviewCell.webview.delegate = self
            webviewCell.webview.scrollView.isScrollEnabled = false
            webviewCell.webview.scrollView.bounces = false
            webviewCell.webview.loadRequest(urlRequest)
            let htmlHeight = contentHeights[(indexPath as NSIndexPath).section]
            webviewCell.webview.frame = CGRect(x: 0, y: 0, width: webviewCell.frame.size.width, height: htmlHeight)
            webviewCell.webview.reload()
            
            return webviewCell
            
            
        } else {
            
            let webviewCell        = tableView.dequeueReusableCell(withIdentifier: webviewLinksCellIdentifier, for: indexPath) as! WebviewTableViewCell
            
            let fileName = optionKey + "Links"
            let url = URL(fileURLWithPath: Bundle.main.path(forResource: fileName, ofType: "html")!)
            let urlRequest = URLRequest(url: url)
            webviewCell.webview.delegate = self
            webviewCell.webview.scrollView.isScrollEnabled = false
            webviewCell.webview.scrollView.bounces = false
            webviewCell.webview.loadRequest(urlRequest)
            let htmlHeight = contentHeights[(indexPath as NSIndexPath).section]
            webviewCell.webview.frame = CGRect(x: 0, y: 0, width: webviewCell.frame.size.width, height: htmlHeight)
            webviewCell.webview.reload()
            return webviewCell

        }
    }
    
    
    // MARK: - UIWebViewDelegate
    func webViewDidFinishLoad(_ webView: UIWebView) {
     
        if(!reload[webView.tag] && contentHeights[webView.tag] != 0.0){
            return
        }
        
        if(reload[webView.tag]) {
            reload[webView.tag] = false
        }
        
        var frame = webView.frame
        frame.size.height = 1
        webView.frame = frame
        let fittingSize = webView.sizeThatFits(CGSize.zero)
        frame.size = fittingSize
        webView.frame = frame
        
        contentHeights[webView.tag] = fittingSize.height + 10
        tableView.reloadData()
    }
    
    func webView(_ webView: UIWebView, shouldStartLoadWith request: URLRequest, navigationType: UIWebView.NavigationType) -> Bool {
        if navigationType == UIWebView.NavigationType.linkClicked {
            UIApplication.shared.openURL(request.url!)
            return false
        }
        return true
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return contentHeights[(indexPath as NSIndexPath).section]
    }
    
    override func viewWillTransition(to size: CGSize, with coordinator: UIViewControllerTransitionCoordinator) {
        reload = [true, true]
        tableView.reloadData()
    }
}
