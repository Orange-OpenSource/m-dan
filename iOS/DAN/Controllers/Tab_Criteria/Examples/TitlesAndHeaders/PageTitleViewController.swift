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

class PageTitleViewController: DefaultTableViewController {
    
    let textCellIdentifier      = "textCell"
    let switchCellIdentifier    = "switchCell"
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        sectionHeaders = [
            "common_description",
            "common_example"
        ]
        
        cellsContent = [
            ["example_titleAndHeader_title_description"],
            [""],
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            let textCell: TextTableViewCell = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text             = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            let switchCell: SwitchCell = tableView.dequeueReusableCell(withIdentifier: switchCellIdentifier, for: indexPath) as! SwitchCell
            
            switchCell.accessibilitySegment.addTarget(self, action: #selector(PageTitleViewController.segmentValueDidChange(_:)), for: .valueChanged)
            switchCell.titleLabel.text = "example_titleAndHeader_title_segmentTitle".localized

            return switchCell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
    
    // MARK: - Private methods
    @objc func segmentValueDidChange(_ sender: UISegmentedControl) {
        
        title = sender.selectedSegmentIndex == 0 ? "common_example".localized : "mDAN"
    }
}

class SwitchCell : UITableViewCell {
    
    @IBOutlet weak var titleLabel:              UILabel!
    @IBOutlet weak var accessibilitySegment:    UISegmentedControl!
    
    override func awakeFromNib() {
        super.awakeFromNib()

        accessibilitySegment.tintColor  = .orange_orangeForWhiteBG()
        accessibilitySegment.setTitleTextAttributes([NSAttributedString.Key.font : UIFont.boldSystemFont(ofSize: 15)], for: UIControl.State())
    }
}
