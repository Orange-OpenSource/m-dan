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

class SongTableViewCell: UITableViewCell {

    @IBOutlet var songTitleLabel:   UILabel!
    @IBOutlet var artistLabel:      UILabel!
    @IBOutlet var songAlbumImage:   UIImageView!
    @IBOutlet var playButton:       UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }

    @IBAction func playButtonPressed(_ sender: UIButton) {
        let alert = UIAlertController(title: "example_clickZone_size_play_alertTitle".localized, message: "", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "common_ok".localized, style: .default, handler: nil))
        alert.view.tintColor = .orange_orangeForWhiteBG()
        if let keyWindow = UIWindow.key {
            keyWindow.rootViewController?.present(alert, animated: true, completion: nil)
        }
    }
}
