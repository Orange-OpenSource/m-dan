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

class EmptyTableViewController: UITableViewController {
    
    //MARK: - Properties
    var cellsContent: [[String]]    = []
    var cellsSubtitle: [[String]]   = []
    var sectionHeaders: [String]    = []
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.rowHeight         = UITableView.automaticDimension
        
        // Remove cell separators
        tableView.separatorStyle = UITableViewCell.SeparatorStyle.none
    
        setUpDatas()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        setUpNavigationBar()
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
        navigationController?.navigationBar.barTintColor = UIColor.white
        
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
        
        self.navigationController?.navigationBar.tintColor = UIColor.orange_orangeForBlackText()
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
    
    /*
    @objc func displayVoiceOverMessage(_ sender: UIBarButtonItem) {
        let alert = UIAlertController(title: "common_alertVoiceOverTitle".localized, message: "common_alertVoiceOver".localized, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "common_ok".localized, style: .default, handler: nil))
        
        self.present(alert, animated: true, completion: nil)
        
        alert.view.tintColor = .orange_orangeForWhiteBG()
    }
     */
}


