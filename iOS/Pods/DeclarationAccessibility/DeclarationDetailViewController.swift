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
    var activityIndicator = UIActivityIndicatorView()
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        title = NSLocalizedString("declaration_detail_title", tableName: "Localizable", bundle: bundle, comment: "")
        
        let language = Bundle.main.preferredLocalizations.first! as NSString
        let fileName = "mdan_" + (language as String)
        let url = URL(fileURLWithPath: Bundle.main.path(forResource: fileName, ofType: "html")!)
        let urlRequest = URLRequest(url: url)
        webView.load(urlRequest)
        webView.navigationDelegate = self
        if #available(iOS 13.0, *) {
            webView.backgroundColor = .systemBackground
        }
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

extension DeclarationDetailViewController {
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


extension String {

    var localized: String {
        
        return NSLocalizedString(self, comment: "")
    }
}
