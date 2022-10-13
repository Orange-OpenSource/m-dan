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

        title = "tab_testings_title".localized
        
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
        //let optionNumber                                = row+1
        //let optionsCount                                = tableView.dataSource?.tableView(tableView, numberOfRowsInSection: (tableView.indexPathForCell(cell)?.section)!)
        let destinationVC: DefaultTableViewController   = segue.destination as! DefaultTableViewController
        
        //destinationVC.title = "common_option".localized + " \(optionNumber)/\(optionsCount!)"
        destinationVC.title = cellsContent[1][row].localized

        destinationVC.cellsContent = [
            ["option_\(optionsKeys[row])_desctription"],
            ["option_\(optionsKeys[row])_activation"]
        ]
    }
}

