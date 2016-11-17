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

class ElementStateFoldAreaViewController: DefaultTableViewController {

    let textCellIdentifier          = "textCell"
    let subtitleCellIdentifier      = "subtitleCell"
    let defaultCellIdentifier       = "defaultCell"
    let accessibleSection           = 1
    let accessibleFoldSection       = 2
    let notAccessibleSection        = 3
    let nonAccessibleFoldSection    = 4
    
    var accessibleIsFold:Bool       = false
    var nonAccessibleIsFold:Bool    = false

    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()

        let btnName = UIButton()
        btnName.setImage(UIImage(named: "icon_infos"), for: UIControlState())
        btnName.accessibilityLabel = "common_informationButton".localized
        btnName.tintColor = UIColor.white
        btnName.frame = CGRect(x: 0, y: 0, width: 20, height: 20)
        btnName.addTarget(self, action: #selector(displayVoiceOverMessage(_:)), for: .touchUpInside)
        
        let rightBarButton = UIBarButtonItem(customView: btnName)
        self.navigationItem.rightBarButtonItem = rightBarButton
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        
        sectionHeaders = [
            "common_description",
            "common_accessibleExample",
            "example_elementState_foldArea_firstnameList",
            "common_notAccessibleExample",
            "example_elementState_foldArea_firstnameList"
        ]
        
        cellsContent = [
            ["example_elementState_foldArea_description"],
            [""],
            ["Sarah", "Damien"],
            [""],
            ["Sarah", "Damien"]
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
        else if (indexPath as NSIndexPath).section == accessibleSection || (indexPath as NSIndexPath).section == notAccessibleSection {
            
            let textCell: UITableViewCell = tableView.dequeueReusableCell(withIdentifier: defaultCellIdentifier, for: indexPath)
            return textCell
        }
        else {
            
            let cell: UITableViewCell = tableView.dequeueReusableCell(withIdentifier: defaultCellIdentifier, for: indexPath)
            cell.textLabel?.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {

        return 44
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == accessibleSection || (indexPath as NSIndexPath).section == notAccessibleSection {
            return 0
        }
        else if (indexPath as NSIndexPath).section == nonAccessibleFoldSection {
            if(nonAccessibleIsFold) {
                return 0
            }
            return 44
        }
        else if (indexPath as NSIndexPath).section == accessibleFoldSection {
            if(accessibleIsFold) {
                return 0
            }
            return 44
        }

        return UITableViewAutomaticDimension
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        
        if section == nonAccessibleFoldSection || section == accessibleFoldSection {
            return 44
        }
        else {
            return 45
        }
    }

    override func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        if section == nonAccessibleFoldSection || section == accessibleFoldSection {
            
            let accordionHeaderView:AccordionHeaderTableViewCell = tableView.dequeueReusableCell(withIdentifier: "accordionHeaderIdentifier") as! AccordionHeaderTableViewCell
            
            let tapRec = UITapGestureRecognizer(target: self, action: #selector(ElementStateFoldAreaViewController.tappedView(_:)))
            accordionHeaderView.addGestureRecognizer(tapRec)
            accordionHeaderView.tag = section
            accordionHeaderView.titleLabel.text = sectionHeaders[section].localized
            
            if(section == nonAccessibleFoldSection) {
                if(nonAccessibleIsFold) { accordionHeaderView.arrowImageView.image = UIImage(named: "arrow-up-black") }
                else { accordionHeaderView.arrowImageView.image = UIImage(named: "arrow-down-black")}
            }
            else if(section == accessibleFoldSection) {
                if(accessibleIsFold) {
                    accordionHeaderView.arrowImageView.image = UIImage(named: "arrow-up-black")
                    accordionHeaderView.accessibilityHint = "example_elementState_foldArea_open_accessibilityHint".localized
                }
                else {
                    accordionHeaderView.arrowImageView.image = UIImage(named: "arrow-down-black")
                    accordionHeaderView.accessibilityHint = "example_elementState_foldArea_close_accessibilityHint".localized
                }
            }
            
            return accordionHeaderView;
        }

        return super.tableView(tableView, viewForHeaderInSection: section)
    }
    
    override func tableView(_ tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int) {
        
        if section != nonAccessibleFoldSection && section != accessibleFoldSection {
            super.tableView(tableView, willDisplayHeaderView: view, forSection: section)
        }
    }
    
    func tappedView(_ gesture:UITapGestureRecognizer) {

        let accordionHeaderView:AccordionHeaderTableViewCell = gesture.view as! AccordionHeaderTableViewCell
        let section = accordionHeaderView.tag
        
        if(section == nonAccessibleFoldSection) {
            nonAccessibleIsFold = !nonAccessibleIsFold
        }
        else if(section == accessibleFoldSection) {
            accessibleIsFold = !accessibleIsFold
        }
        tableView.reloadData()
    }
    
}
