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

class DefaultLabelHeaderWithPadding: UILabel {
    
    required init(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)!
        
        self.textColor = UIColor.orange_blackColor()
        self.backgroundColor = UIColor.orange_greyBgColor()
        
        if #available(iOS 8.2, *) {
            self.font = UIFont.systemFont(ofSize: 17, weight:UIFontWeightMedium)
        } else {
            // Fallback on earlier versions
            self.font = UIFont.systemFont(ofSize: 17)
        }
    }
    
    override func drawText(in rect: CGRect) {
        let insets = UIEdgeInsets.init(top: 0, left: 15, bottom: 0, right: 15)
        super.drawText(in: UIEdgeInsetsInsetRect(rect, insets))
    }
}
