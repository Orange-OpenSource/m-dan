//
//  DeclarationDetailViewController.swift
//  DeclarationAccessibility
//
//  Created by Tayeb SEDRAIA on 22/11/2022.
//

import UIKit
import WebKit

class DeclarationDetailViewController: UIViewController, WKNavigationDelegate, WKUIDelegate {
    
    let webView = WKWebView()
    let bundle = Bundle(for: DeclarationDetailViewController.self)
    var indicator = UIActivityIndicatorView()
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        title = NSLocalizedString("declaration_detail_title", tableName: "Localizable", bundle: bundle, comment: "")
        if #available(iOS 13.0, *) {
            indicator = UIActivityIndicatorView(style: .large)
        } else {
            indicator = UIActivityIndicatorView(style: .gray)
        }
        
        indicator.center = view.center
        
        indicator.startAnimating()
        webView.addSubview(indicator)
        
        setUpNavigationBarClose()
        
        let language = Bundle.main.preferredLocalizations.first! as NSString
        let fileName = "mdan_" + (language as String)
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
    
    func setUpNavigationBarClose() {
        let close = UIBarButtonItem(barButtonSystemItem: .done, target: self, action:#selector(closeTapped))
        navigationItem.rightBarButtonItems = [close]
    }
    
    func webView(_ webView: WKWebView, didStartProvisionalNavigation navigation: WKNavigation!) {
        indicator.startAnimating()
    }
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        indicator.stopAnimating()
    }
    func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
        indicator.stopAnimating()
    }
    
    @objc func closeTapped(_ sender: UIBarButtonItem) {
        self.dismiss(animated: true, completion: nil)
    }
}

extension String {

    var localized: String {
        
        return NSLocalizedString(self, comment: "")
    }
}
