//
//  UIViewController+Orange.swift
//  mDAN
//
//  Created by Tayeb SEDRAIA on 15/11/2022.
//  Copyright © 2022 Devrap. All rights reserved.
//

import Foundation
import UIKit
import SafariServices

extension UIViewController {
    func openURL(_ urlString: String) {
        if let url = URL(string: urlString) {
            let vc = SFSafariViewController(url: url)
            self.present(vc, animated: true)
        }
    }
}
