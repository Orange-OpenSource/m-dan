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

class TestingsViewController: DefaultTableViewController {

    //MARK: - Properties
    let textCellIdentifier      = "textCell"
    let optionCellIdentifier    = "optionCell"
    var optionsKeys : [[String]]    = []

    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        print("TestingsViewController")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    
    // MARK: - Private methods
    override func setUpDatas() {

        title = "tab_testings_title".localized
        
        optionsKeys = [
            [""],
            [
                "generalNavigation",
                "fontEnlargement",
                "screenReader",
                "selectionControl"
            ],
            [
                "contrastColor",
                "buttonForm",
                "webView"
            ],
        ]
        
        sectionHeaders = [
            "testings_section_description",
            "testings_section_situationTest",
            "testings_section_anotherTest"
        ]
        
        cellsContent = [
            ["testings_description_cell"],
            [
                "testings_option_generalNavigation",
                "testings_option_fontEnlargement",
                "testings_option_screenReader",
                "testings_option_selectionControl"
            ],
            [
                "testings_option_useColorContrast",
                "testings_option_useMultimedia",
                "testings_option_screenWebView"
            ],
        ]
    }

    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        //let cell: UITableViewCell = tableView.cellForRow(at: indexPath)!
        
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

            //self.performSegue(withIdentifier: "example-titleAndHeader-title", sender: cell)
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
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        let cell = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
        
        switch cell {
        case "testings_option_generalNavigation".localized :
            self.performSegue(withIdentifier: "testing-generalNavigation", sender: cell)
        case "testings_option_fontEnlargement".localized :
            self.performSegue(withIdentifier: "testing-fontEnlargement", sender: cell)
        case "testings_option_screenReader".localized :
            self.performSegue(withIdentifier: "testing-screenReader", sender: cell)
        case "testings_option_selectionControl".localized :
            self.performSegue(withIdentifier: "testing-selectionControl", sender: cell)
        case "testings_option_useColorContrast".localized :
            self.performSegue(withIdentifier: "testing-colorContrastTool", sender: cell)
        default:
            print("Category unknown")
        }
    }
     

     
     
    /*
    // MARK: - StoryBoard
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let cell:UITableViewCell                        = sender as! UITableViewCell
        let section = self.tableView.indexPathForSelectedRow!.section
        let row                                         = ((tableView.indexPath(for: cell) as NSIndexPath?)?.row)!
                                                                                              
        let destinationVC: DefaultTableViewController   = segue.destination as! DefaultTableViewController

        print("cellsContent ", cellsContent)
        print("cellsContent ", "testings_option_generalNavigation".localized)
            print("Dedans")
            destinationVC.title = cellsContent[section][row].localized
            destinationVC.cellsContent = [
                ["testing_\(optionsKeys[section][row])_check"]
            ]

    }
     */
}

