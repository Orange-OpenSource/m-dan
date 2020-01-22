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

class ClickZoneSizeViewController: DefaultTableViewController {

    let textCellIdentifier                  = "textCell"
    let musicCellAccessibleIdentifier       = "musicCellAccessible"
    let musicCellNonAccessibleIdentifier    = "musicCellNonAccessible"
    let accessibleSection                   = 1
    var artistContent: [[String]]    = []

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
            "common_description",
            "common_accessibleExample",
            "common_notAccessibleExample"
        ]
        
        cellsContent = [
            ["example_clickZone_size_description"],
            ["Mary Daisy Jane", "About a girl"],
            ["Mary Daisy Jane", "About a girl"]
        ]
        
        artistContent = [
            [],
            ["Mael", "Nirvana"],
            ["Mael", "Nirvana"],
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            let textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            
            let songCell: SongTableViewCell
            
            // Accessible example
            if (indexPath as NSIndexPath).section == accessibleSection {
                songCell                                = tableView.dequeueReusableCell( withIdentifier: musicCellAccessibleIdentifier, for: indexPath) as! SongTableViewCell
                songCell.playButton.accessibilityLabel  = "example_clickZone_size_play_song".localized + " " + cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            }
            else {
                songCell    = tableView.dequeueReusableCell( withIdentifier: musicCellNonAccessibleIdentifier, for: indexPath) as! SongTableViewCell
            }
            
            let songImage: UIImage          = (indexPath as NSIndexPath).row == 0 ? UIImage(named: "song1")! : UIImage(named: "song2")!
            songCell.songTitleLabel.text    = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            songCell.artistLabel.text       = artistContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            songCell.songAlbumImage?.image  = songImage
            
            return songCell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            return UITableView.automaticDimension
        }
        else {
            
            return 100;
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return 100
    }
}
