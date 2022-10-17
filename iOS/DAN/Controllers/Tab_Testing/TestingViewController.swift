//
//  TestingViewController.swift
//  mDAN
//
//  Created by Tayeb SEDRAIA on 14/10/2022.
//  Copyright © 2022 Devrap. All rights reserved.
//

import UIKit

class TestingViewController: DefaultTableViewController {

    //MARK: - Properties
    let textCellIdentifier      = "textCell"
    
    let descriptionSection      = 0
    let activationSection       = 1
    let useSection              = 2
    let linksSection            = 3
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        sectionHeaders = [
            "common_test",
            "common_check"
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let textCell        = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
        textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
        
        return textCell
        
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return 100
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        if (indexPath as NSIndexPath).section == linksSection {
            
            UIApplication.shared.openURL(URL(string:"SOME_URL_HERE")!)
        }
    }
}

