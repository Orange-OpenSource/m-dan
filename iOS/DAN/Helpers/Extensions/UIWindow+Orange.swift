//
//  UIWindow+Orange.swift
//  mDAN
//
//  Created by Tayeb SEDRAIA on 04/11/2021.
//  Copyright © 2021 Devrap. All rights reserved.
//

import UIKit

extension UIWindow {
    static var key: UIWindow? {
        if #available(iOS 13, *) {
            return UIApplication.shared.windows.first { $0.isKeyWindow }
        } else {
            return UIApplication.shared.keyWindow
        }
    }
}
