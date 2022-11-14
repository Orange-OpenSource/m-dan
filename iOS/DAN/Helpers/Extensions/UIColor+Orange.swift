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
import UIKit

extension UIColor {
    
    class func colorWithHex(_ hex: Int, alpha: CGFloat = 1.0) -> UIColor {
        let r = CGFloat((hex & 0xff0000) >> 16) / 255.0
        let g = CGFloat((hex & 0x00ff00) >>  8) / 255.0
        let b = CGFloat((hex & 0x0000ff) >>  0) / 255.0
        
        return UIColor(red: r, green: g, blue: b, alpha: alpha)
    }
    
    convenience init(hexaString: String, alpha: CGFloat = 1) {
        let chars = Array(hexaString.dropFirst())
        self.init(red:   .init(strtoul(String(chars[0...1]),nil,16))/255,
                  green: .init(strtoul(String(chars[2...3]),nil,16))/255,
                  blue:  .init(strtoul(String(chars[4...5]),nil,16))/255,
                  alpha: alpha)}
    
    
    // MARK: - Black
    class func orange_blackColor()          -> UIColor { return UIColor.black }
    
    // MARK: - White
    class func orange_whiteColor()          -> UIColor { return UIColor.white }
    
    // MARK: - Grey background header
    class func orange_greyBgColor()          -> UIColor { return UIColor.colorWithHex(0xF2F2F2) }
    
    // MARK: - Gray
    // MARK: Text
    class func orange_grayForWhiteBG()      -> UIColor { return UIColor.colorWithHex(0x666666) }
    
    // MARK: - Orange
    // MARK: Background
    class func orange_orangeForBlackText()  -> UIColor { return UIColor(hexaString: "#0075F6") }
    class func orange_orangeForWhiteText()  -> UIColor { return UIColor(hexaString: "#0054AE") }
    
    // MARK: Text
    class func orange_orangeForBlackBG()    -> UIColor { return UIColor(hexaString: "#0075F6") }
    class func orange_orangeForWhiteBG()    -> UIColor { return UIColor(hexaString: "#0054AE") }
    
    // MARK: Functional
    class func orange_red()                 -> UIColor { return UIColor.colorWithHex(0xC1431A) }
    class func orange_functionalRed()       -> UIColor { return UIColor.colorWithHex(0xDD2C00) }
    class func orange_green()               -> UIColor { return UIColor.colorWithHex(0x4EC924) }
    class func orange_functionalGrey6()     -> UIColor { return UIColor.colorWithHex(0xEEEEEE) }
    class func orange_functionalGrey5()     -> UIColor { return UIColor.colorWithHex(0xCCCCCC) }
}

extension UIColor {
    static func getColor(darkColor: UIColor, lightColor: UIColor) -> UIColor {
        if #available(iOS 13, *) {
            return UIColor { traitCollection  in
                return traitCollection.userInterfaceStyle == .dark ?
                    darkColor :
                    lightColor
            }
        }
        
        return darkColor
    }
    
    // Usage
    static var myAdaptiveColor: UIColor {
        return getColor(darkColor: .black, lightColor: .white)
    }
}
