//
//  UIBarButtonItem+Orange.swift
//  mDAN
//
//  Created by Alexandre Dorys-Charnalet on 06/12/2019.
//  Copyright © 2019 Devrap. All rights reserved.
//

import UIKit

extension UIBarButtonItem {
    static func infosButton(_ target: Any?, action: Selector) -> UIBarButtonItem {
        let button = UIButton(type: .system)
        button.setImage(UIImage(named: "icon_infos"), for: .normal)
        button.addTarget(target, action: action, for: .touchUpInside)
        button.accessibilityLabel = "common_informationButton".localized
        button.tintColor = UIColor.orange_orangeInnovation()

        let menuBarItem = UIBarButtonItem(customView: button)
        menuBarItem.customView?.translatesAutoresizingMaskIntoConstraints = false
        
        if #available(iOS 9.0, *) {
            menuBarItem.customView?.heightAnchor.constraint(equalToConstant: 24).isActive = true
            menuBarItem.customView?.widthAnchor.constraint(equalToConstant: 24).isActive = true
        }

        if #available(iOS 11.0, *) {
            menuBarItem.largeContentSizeImage = UIImage(named: "icon_infos")
            menuBarItem.largeContentSizeImageInsets = UIEdgeInsets(top: 130, left: 130, bottom: 130, right: 130)

        } else {
            // Fallback on earlier versions
        }
        
        
        return menuBarItem
    }
    
    static func guideButton(_ target: Any?, action: Selector) -> UIBarButtonItem {
        let button = UIButton(type: .system)
        button.setImage(UIImage(named: "icon_guid_ios"), for: .normal)
        button.addTarget(target, action: action, for: .touchUpInside)
        button.accessibilityLabel = "common_guideButton".localized
        button.tintColor = UIColor.orange_orangeInnovation()

        let menuBarItem = UIBarButtonItem(customView: button)
        menuBarItem.customView?.translatesAutoresizingMaskIntoConstraints = false
        
        if #available(iOS 9.0, *) {
            menuBarItem.customView?.heightAnchor.constraint(equalToConstant: 24).isActive = true
            menuBarItem.customView?.widthAnchor.constraint(equalToConstant: 24).isActive = true
        }

        if #available(iOS 11.0, *) {
            menuBarItem.largeContentSizeImage = UIImage(named: "icon_guid_ios")
            menuBarItem.largeContentSizeImageInsets = UIEdgeInsets(top: 130, left: 130, bottom: 130, right: 130)

        } else {
            // Fallback on earlier versions
        }
        
        
        return menuBarItem
    }
}
