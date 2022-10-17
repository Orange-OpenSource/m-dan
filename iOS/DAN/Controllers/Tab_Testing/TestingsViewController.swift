//
//  TestingsViewController.swift
//  mDAN
//
//  Created by Tayeb SEDRAIA on 13/10/2022.
//  Copyright © 2022 Devrap. All rights reserved.
//

import UIKit

class TestingsViewController: DefaultTableViewController {

    //MARK: - Properties
    let textCellIdentifier      = "textCell"
    let optionCellIdentifier    = "optionCell"
    var optionsKeys : [[String]]    = []

    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
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
                "contrastIncrease",
                "monoMode",
                "zoom"
            ],
            [
                "colorInversion",
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
        let section = self.tableView.indexPathForSelectedRow!.section
        let row                                         = ((tableView.indexPath(for: cell) as NSIndexPath?)?.row)!
                                                                                              
        let destinationVC: DefaultTableViewController   = segue.destination as! DefaultTableViewController

        destinationVC.title = cellsContent[section][row].localized
        destinationVC.cellsContent = [
            ["testing_\(optionsKeys[section][row])_desctription"],
            ["testing_\(optionsKeys[section][row])_check"]
        ]
        
    }
}

