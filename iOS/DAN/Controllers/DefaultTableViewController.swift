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

class DefaultTableViewController: UITableViewController {

    //MARK: - Properties
    var cellsContent: [[String]]    = []
    var cellsSubtitle: [[String]]   = []
    var sectionHeaders: [String]    = []
    let headerCellIdentifier        = "defaultHeaderIdentifier"
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.backgroundColor   = UIColor.orange_grayForWhiteBG()
        tableView.rowHeight         = UITableView.automaticDimension
        
        tableView.register(UINib(nibName: "DefaultHeaderViewCell", bundle: nil), forCellReuseIdentifier: headerCellIdentifier)
        
        // Remove cell separators for empty cells
        tableView.tableFooterView = UIView()
        
        setUpDatas()
    }
    
    func setUpDatas() {
    }
    
    // MARK: - TableView DataSource
    override func numberOfSections(in tableView: UITableView) -> Int {
        return cellsContent.count
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return cellsContent[section].count
    }
    
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        
        return sectionHeaders[section].localized
    }
    
    // MARK: - TableView Delegate
    override func tableView(_ tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int) {
        
        if(sectionHeaders[section] == "common_accessibleExample"
            || sectionHeaders[section] == "common_notAccessibleExample"
            || sectionHeaders[section] == "common_accessibleCustomExample"
            || sectionHeaders[section] == "common_notAccessibleCustomExample") {
            
                return
        }
        else {
            let header: UITableViewHeaderFooterView     = view as! UITableViewHeaderFooterView
            header.contentView.backgroundColor          = .orange_greyBgColor()
            header.textLabel!.textColor                 = .orange_blackColor()
            header.layer.borderWidth = 1
            header.layer.borderColor = UIColor.orange_functionalGrey6().cgColor
        }
        
    }
    
    override func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        if(sectionHeaders[section] == "common_accessibleExample"
            || sectionHeaders[section] == "common_notAccessibleExample"
            || sectionHeaders[section] == "common_accessibleCustomExample"
            || sectionHeaders[section] == "common_notAccessibleCustomExample") {
            
            let defaultHeaderViewCell:DefaultHeaderViewCell = tableView.dequeueReusableCell(withIdentifier: headerCellIdentifier) as! DefaultHeaderViewCell
            
            if(sectionHeaders[section] == "common_accessibleExample" || sectionHeaders[section] == "common_accessibleCustomExample") {
                defaultHeaderViewCell.headerImageView.image = UIImage(named: "icon_check_good")
                defaultHeaderViewCell.imageViewHeaderConstraint.constant = 20.0
                defaultHeaderViewCell.headerLabel.text      = sectionHeaders[section].localized
            }
            else {
                defaultHeaderViewCell.headerImageView.image = UIImage(named: "icon_bad")
                defaultHeaderViewCell.headerImageView.tintColor = .orange_red()
                defaultHeaderViewCell.headerLabel.text      = sectionHeaders[section].localized
            }
            
            defaultHeaderViewCell.contentView.backgroundColor = .orange_greyBgColor()
            defaultHeaderViewCell.accessibilityTraits = UIAccessibilityTraits.header
            
            // Using a view container to fix a bug when using a tableViewCell as header
            let headerContainer = UIView(frame: defaultHeaderViewCell.frame)
            
            headerContainer.addSubview(defaultHeaderViewCell)
            
            return headerContainer;
        }
        
        let header: UITableViewHeaderFooterView     = UITableViewHeaderFooterView()
        header.textLabel?.adjustsFontSizeToFitWidth = true
        header.textLabel?.minimumScaleFactor        = 0.7
        
        return header;
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        tableView.deselectRow(at: indexPath, animated: true)
    }
    
    @objc func displayVoiceOverMessage(_ sender: UIBarButtonItem) {
        let alert = UIAlertController(title: "common_alertVoiceOverTitle".localized, message: "common_alertVoiceOver".localized, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "common_ok".localized, style: .default, handler: nil))
        
        self.present(alert, animated: true, completion: nil)
        
        alert.view.tintColor = .orange_orangeForWhiteBG()
    }
}


