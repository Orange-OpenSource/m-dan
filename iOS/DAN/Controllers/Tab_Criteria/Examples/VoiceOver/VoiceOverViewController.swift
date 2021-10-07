//
//  VoiceOverViewController.swift
//  mDAN
//
//  Created by Tayeb SEDRAIA on 03/09/2021.
//  Copyright © 2021 Devrap. All rights reserved.
//

import Foundation
import UIKit

class VoiceOverViewController: DefaultTableViewController {

    let textCellIdentifier      = "textCell"
    let buttonCellIdentifier    = "buttonCell"
    let accessibleSection       = 1
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayVoiceOverMessage(_:)))
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        sectionHeaders = [
            "common_description",
            "common_example"
        ]
        
        cellsContent = [
            ["example_voiceOver_carousel_description"],
            [""],
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            let textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            
            let buttonCell: ButtonTableViewCell = tableView.dequeueReusableCell( withIdentifier: buttonCellIdentifier, for: indexPath) as! ButtonTableViewCell

            buttonCell.button.setTitle("example_voiceover_accent_title".localized, for: UIControl.State())
            buttonCell.button.tag                   = (indexPath as NSIndexPath).section // allow to differenciate buttons while preparing for segue
//            buttonCell.button.accessibilityLabel    = (indexPath as NSIndexPath).section == accessibleSection ? "example_horizontalScroll_carousel_buttonLabelAccessible".localized : "example_horizontalScroll_carousel_buttonLabelNonAccessible".localized
            
            return buttonCell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            return UITableView.automaticDimension
        }
        else {
            
            return 90;
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return 100
    }
    
    // MARK: - Storyboard
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        let carouselVC          = segue.destination as! VoiceOverCarouselViewController
        carouselVC.isAccessible = (sender as AnyObject).tag == accessibleSection
    }
}
