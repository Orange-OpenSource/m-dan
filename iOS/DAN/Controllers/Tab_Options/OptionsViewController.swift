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

class OptionsViewController: DefaultTableViewController {

    //MARK: - Properties
    let textCellIdentifier      = "textCell"
    let optionCellIdentifier    = "optionCell"
    var optionsKeys : [String]  = []

    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {

        title = "tab_options_title".localized
        
        optionsKeys = [
            "characterScale",
            "contrastIncrease",
            "monoMode",
            "zoom",
            "colorInversion",
            "buttonForm",
            "selectionControl"
        ]
        
        sectionHeaders = [
            "common_whatIsIt",
            "options_section_accessibilityOptions"
        ]
        
        cellsContent = [
            ["options_description_cell"],
            [
                "options_option_characterScale",
                "options_option_contrastIncrease",
                "options_option_monoMode",
                "options_option_zoom",
                "options_option_colorInversion",
                "options_option_buttonForm",
                "options_option_selectionControl"
            ]
        ]
    }

    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if((indexPath as NSIndexPath).section == 0) {
            
            let textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            
            let textCell: TextTableViewCell

            textCell            = tableView.dequeueReusableCell(withIdentifier: optionCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label?.text    = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized

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
    
    // MARK: - StoryBoard
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        let cell:UITableViewCell                        = sender as! UITableViewCell
        let row                                         = ((tableView.indexPath(for: cell) as NSIndexPath?)?.row)!
        let destinationVC: DefaultTableViewController   = segue.destination as! DefaultTableViewController
        destinationVC.title = cellsContent[1][row].localized

        destinationVC.cellsContent = [
            ["option_\(optionsKeys[row])_desctription"],
            ["option_\(optionsKeys[row])_activation"]
        ]
    }
}
