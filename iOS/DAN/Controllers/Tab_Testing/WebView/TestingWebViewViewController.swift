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

class TestingWebViewViewController: DefaultTableViewController {

    //MARK: - Properties
    let textCellIdentifier      = "descCell"
    let creditCellIdentifier    = "gestureCell"

    
    let descriptionSection      = 0
    let gestureSection          = 1
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    // MARK: - Private methods
    override func setUpDatas() {

        title = "testings_option_webView".localized

        sectionHeaders = [
            "common_description",
            "common_example"
        ]
        
        cellsContent = [
            ["testing_webView_check"],
            [""],
        ]
    }
    
    func setUpNavigationBarClose() {
        
        self.tableView.reloadData()
        navigationItem.largeTitleDisplayMode = .never
             navigationController?.navigationBar.prefersLargeTitles = false
        navigationController?.navigationBar.barTintColor = UIColor.white
        
        self.navigationController?.navigationBar.tintColor = UIColor.orange_orangeForBlackText()
        let close = UIBarButtonItem(barButtonSystemItem: .done, target: self, action:#selector(closeTapped))
        navigationItem.rightBarButtonItems = [close]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == gestureSection {
            var textAndButtonCell: TextAndButtonTableViewCell
            
            textAndButtonCell            = tableView.dequeueReusableCell(withIdentifier: creditCellIdentifier, for: indexPath) as! TextAndButtonTableViewCell
            textAndButtonCell.button.setTitle("testing_webView_button".localized, for: UIControl.State())
            textAndButtonCell.button.backgroundColor = UIColor.orange_orangeForWhiteText()
            
            return textAndButtonCell
            
        } else {
            var textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if((indexPath as NSIndexPath).section == 0) {
            
            return 100
        }
        else {
            
            return 44
        }
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
    @objc func closeTapped(_ sender: UIBarButtonItem) {
        self.dismiss(animated: true, completion: nil)
    }
}
