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

class TestingFontEnlargementViewController: EmptyTableViewController {

    let textCellIdentifier      = "textCell"
    let imageInfoCellIdentifier = "testingImageInfoCell"
    let accessibleSection       = 1
    let notAccessibleSection    = 2
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.title = "testings_option_fontEnlargement".localized
        
        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayFontEnlargementMessage(_:)))
         
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        sectionHeaders = [
            "",
            "",
            ""
        ]
        
        cellsContent = [
            ["testing_fontEnlargement_check"],
            [""],
            [""]
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
            
            let textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
    @objc func displayFontEnlargementMessage(_ sender: UIBarButtonItem) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let optionViewController = storyboard.instantiateViewController(withIdentifier: "OptionViewController") as! OptionViewController
        optionViewController.setUpNavigationBarClose()
        optionViewController.title = "options_option_characterScale".localized
        optionViewController.cellsContent = [
            ["option_characterScale_desctription"],
            ["option_characterScale_activation"]
        ]
        
        let navigationController = UINavigationController(rootViewController: optionViewController)
        self.present(navigationController, animated: true, completion: nil)
    }
}
