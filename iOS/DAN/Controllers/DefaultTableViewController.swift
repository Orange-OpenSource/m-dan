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
        
        tableView.rowHeight         = UITableView.automaticDimension
        
        tableView.register(UINib(nibName: "DefaultHeaderViewCell", bundle: nil), forCellReuseIdentifier: headerCellIdentifier)
        
        // Remove cell separators for empty cells
        tableView.tableFooterView = UIView()
    
        setUpDatas()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        setUpNavigationBar()
        setUpTabBar()
    }
    
    func setupLargeTitleAutoAdjustFont() {
        guard let navigationBar = navigationController?.navigationBar else {
            return
        }
        // recursively find the label
        func findLabel(in view: UIView) -> UILabel? {
            if view.subviews.count > 0 {
                for subview in view.subviews {
                    if let label = findLabel(in: subview) {
                        return label
                    }
                }
            }
            return view as? UILabel
        }

        if let label = findLabel(in: navigationBar) {
            if label.text == self.title {
                label.adjustsFontSizeToFitWidth = true
                label.minimumScaleFactor = 0.7
            }
        }
    }
    
    // MARK: - Navigation Bar Setting
    func setUpNavigationBar() {
        
        self.tableView.reloadData()
        
        navigationController?.navigationBar.prefersLargeTitles = true
        navigationController?.navigationBar.barTintColor = UIColor.systemBackground
        navigationController?.navigationBar.tintColor = UIColor.orange_orangeInnovation()
        
        DispatchQueue.main.async { [weak self] in
            self?.navigationController?.navigationBar.sizeToFit()
        }
        
        for navItem in(self.navigationController?.navigationBar.subviews)! {
             for itemSubView in navItem.subviews {
                 if let largeLabel = itemSubView as? UILabel {
                     largeLabel.text = self.title
                     largeLabel.numberOfLines = 0
                     largeLabel.lineBreakMode = .byWordWrapping
                 }
             }
        }
    }
    
    func setUpTabBar() {
        self.tabBarController?.tabBar.tintColor = UIColor.orange_orangeInnovation()
        self.tabBarController?.tabBar.barTintColor = UIColor.orange_orangeInnovation()
    }
    
    internal func reloadTransaction(){
        DispatchQueue.main.async {
            self.tableView.reloadData()
        }
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
        
        tableView.translatesAutoresizingMaskIntoConstraints = false
        
        
        if(sectionHeaders[section] == "common_accessibleExample"
            || sectionHeaders[section] == "common_notAccessibleExample"
            || sectionHeaders[section] == "common_accessibleCustomExample"
            || sectionHeaders[section] == "common_notAccessibleCustomExample") {
            return
        }
        else {
            let header: UITableViewHeaderFooterView     = view as! UITableViewHeaderFooterView
            header.contentView.backgroundColor          = UIColor.systemGray5
            header.textLabel?.textColor                 = UIColor.label
            header.textLabel?.numberOfLines = 0
            header.sizeToFit()
            header.textLabel?.sizeToFit()
            header.textLabel?.lineBreakMode = .byWordWrapping
            
            self.tableView.sectionHeaderHeight = UITableView.automaticDimension
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
                defaultHeaderViewCell.headerLabel.text      = sectionHeaders[section].localized
            }
            else {
                defaultHeaderViewCell.headerImageView.image = UIImage(named: "icon_bad")
                defaultHeaderViewCell.headerImageView.tintColor = .systemRed
                defaultHeaderViewCell.headerLabel.text      = sectionHeaders[section].localized
            }
            
            defaultHeaderViewCell.contentView.backgroundColor = .systemGray5
            defaultHeaderViewCell.accessibilityTraits = UIAccessibilityTraits.header
            
            // Using a view container to fix a bug when using a tableViewCell as header
            let headerContainer = UIView(frame: defaultHeaderViewCell.frame)
            
            headerContainer.addSubview(defaultHeaderViewCell)
            
            return headerContainer;
        }
        
        let header: UITableViewHeaderFooterView     = UITableViewHeaderFooterView()
        header.textLabel?.adjustsFontSizeToFitWidth = true
        header.textLabel?.numberOfLines = 0
        
        return header;
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        tableView.deselectRow(at: indexPath, animated: true)
    }
    
    @objc func displayVoiceOverMessage(_ sender: UIBarButtonItem) {
        let alert = UIAlertController(title: "common_alertVoiceOverTitle".localized, message: "common_alertVoiceOver".localized, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "common_ok".localized, style: .default, handler: nil))
        
        self.present(alert, animated: true, completion: nil)
    }
}


