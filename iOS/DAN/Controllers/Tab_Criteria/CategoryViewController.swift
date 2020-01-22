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

class CategoryViewController: DefaultTableViewController {
    
    //MARK: - Properties
    let textCellIdentifier      = "textCell"
    let exampleCellIdentifier   = "exampleCell"
    var categoryKey             = ""
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Private methods
    override func setUpDatas() {
        var examples:       Array<String>
        var examplesDetail: Array<String>
        var whatFor:        Array<String>
        var howTo:          Array<String>
        
        whatFor = ["criteria_category_\(categoryKey)_whatFor"]
        howTo   = ["criteria_category_\(categoryKey)_howTo"]
        
        switch categoryKey {
        case "image":
            
            examples = [
                "example_image_info_title",
                "example_image_deco_title",
                "example_image_illustration_title"
            ]
            
            examplesDetail = [
                "example_image_info_shortDescription",
                "example_image_deco_shortDescription",
                "example_image_illustration_shortDescription"
            ]
            
        case "color":

            examples = [
                "example_color_contrast_title",
                "example_color_info_title"
            ]
            
            examplesDetail = [
                "example_color_contrast_shortDescription",
                "example_color_info_shortDescription"
            ]
            
        case "textualAlternative":
            
            examples = [
                "example_textualAlternative_image_title",
                "example_textualAlternative_elementState_title",
                "example_textualAlternative_form_title",
                "example_textualAlternative_date_title",
                "example_textualAlternative_textImage_title"
            ]
            
            examplesDetail = [
                "",
                "",
                "",
                "example_textualAlternative_date_shortDescription",
                "example_textualAlternative_textImage_shortDescription"
            ]
            
        case "titleAndHeader":

            examples = [
                "example_titleAndHeader_title_title",
                "example_titleAndHeader_headerBis_title",
                "example_titleAndHeader_header_title"
            ]
            
            examplesDetail = [
                "example_titleAndHeader_title_shortDescription",
                "example_titleAndHeader_headerBis_shortDescription",
                "example_titleAndHeader_header_shortDescription"
            ]
            
        case "elementState":
 
            examples = [
                "example_elementState_tab_title",
                "example_elementState_selectionList_title",
                "example_elementState_foldArea_title"
            ]
            
            examplesDetail = [
                "example_elementState_tab_shortDescription",
                "example_elementState_selectionList_shortDescription",
                "example_elementState_foldArea_shortDescription"
            ]
        
        case "standardComponents":

            examples = ["example_standardComponents_standardVsCustom_title"]
            
            examplesDetail = [
                "example_standardComponents_standardVsCustom_shortDescription"]

        case "clickZone":

            examples = [
                "example_clickZone_size_title"
            ]
            
            examplesDetail = [
                "example_clickZone_size_shortDescription"
            ]
            
        case "ghostElement":
            
            examples = [
                "example_ghostElement_alert_title"
            ]
            
            examplesDetail = [
                "example_ghostElement_alert_shortDescription"
            ]
            
        case "contentControl":

            examples = [
                "example_contentControl_carousel_title",
                "example_contentControl_slideshow_title"
            ]
            
            examplesDetail = [
                "example_contentControl_carousel_shortDescription",
                "example_contentControl_slideshow_shortDescription"
            ]
            
        case "contentChange":

            examples = [
                "example_contentChange_elementUpdate_title"
            ]
            
            examplesDetail = [
                "example_contentChange_elementUpdate_shortDescription"
            ]
            
        case "horizontalScroll":
            
            examples = [
                "example_horizontalScroll_carousel_title"
            ]
            
            examplesDetail = [
                "example_horizontalScroll_carousel_shortDescription"
            ]

            
        case "form":

            examples = [
                "example_form_label_title"
            ]
            
            examplesDetail = [
                "example_form_label_shortDescription"
            ]
            
        case "readingOrder":
            
            examples = [
                "example_readingOrder_remoteControl_title"
            ]
            
            examplesDetail = [
                "example_readingOrder_remoteControl_shortDescription"
            ]
            
        case "language":

            examples = [
                "example_language_accent_title"
            ]
            
            examplesDetail = [
                "example_language_accent_shortDescription"
            ]

            
        default:

            examples = [
                "Example_1",
                "Example_2",
                "Example_3"
            ]
            
            examplesDetail = [
                "Detail_1",
                "Detail_2",
                "Detail_3"
            ]
        }
        
        cellsContent = [
            whatFor,
            howTo
        ]
        
        cellsSubtitle = [
            [],
            []
        ]
        
        sectionHeaders = [
            "common_whatFor",
            "common_howTo"
        ]
        
        // cas des catégories avec exemples
        if(examples.count > 0) {
            cellsContent.append(examples)
            cellsSubtitle.append(examplesDetail)
            sectionHeaders.append("common_examples")
        }
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {

        if((indexPath as NSIndexPath).section == 0 || (indexPath as NSIndexPath).section == 1) {
            
            let textCell: TextTableViewCell
            
            textCell            = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            
            let cell: UITableViewCell
            
            cell = tableView.dequeueReusableCell(withIdentifier: exampleCellIdentifier, for: indexPath)
           
            cell.accessoryType              = .disclosureIndicator
            cell.isUserInteractionEnabled     = true
            cell.textLabel?.numberOfLines   = 1
            cell.textLabel?.text            = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            cell.textLabel?.font = UIFont.boldSystemFont(ofSize: 16.0)
            cell.detailTextLabel?.text      = cellsSubtitle[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized

            return cell
        }        
    }
    
    // MARK: - TableViewDelegate    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if((indexPath as NSIndexPath).section == 0 || (indexPath as NSIndexPath).section == 1) {
            
            return 100
        }
        else {
            
            return 50
        }
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if((indexPath as NSIndexPath).section == 0 || (indexPath as NSIndexPath).section == 1) {
            
            return UITableView.automaticDimension
        } else {
            
            return 50
        }
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        let cell: UITableViewCell = tableView.cellForRow(at: indexPath)!
        
        switch categoryKey {
            
        case "image":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-image-info", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 1 {
                self.performSegue(withIdentifier: "example-image-deco", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 2 {
                self.performSegue(withIdentifier: "example-image-illustration", sender: cell)
            }
        case "color":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-color-contrast", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 1 {
                self.performSegue(withIdentifier: "example-color-info", sender: cell)
            }
        case "textualAlternative":
            
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-image-illustration", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 1 {
                self.performSegue(withIdentifier: "example-elementstate-tab", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 2 {
                self.performSegue(withIdentifier: "example-form-label", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 3 {
                self.performSegue(withIdentifier: "example-textualalternative-date", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 4 {
                self.performSegue(withIdentifier: "example-textualalternative-textimage", sender: cell)
            }
            
        case "elementState":
            
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-elementstate-tab", sender: cell)
            }
            if (indexPath as NSIndexPath).row == 1 {
                self.performSegue(withIdentifier: "example-elementstate-selectionlist", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 2 {
                self.performSegue(withIdentifier: "example-elementstate-foldarea", sender: cell)
            }
        case "standardComponents":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-standardcomponents-tab", sender: cell)
            }

        case "titleAndHeader":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-titleAndHeader-title", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 1 {
                self.performSegue(withIdentifier: "example-titleAndHeader-headerBis", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 2 {
                self.performSegue(withIdentifier: "example-titleAndHeader-header", sender: cell)
            }
        case "clickZone":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-clickZone-size", sender: cell)
            }
        case "ghostElement":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-ghostElement-alert", sender: cell)
            }
        case "contentControl":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-contentControl-carousel", sender: cell)
            }
            else if (indexPath as NSIndexPath).row == 1 {
                self.performSegue(withIdentifier: "example-contentControl-slideshow", sender: cell)
            }
        case "contentChange":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-contentChange-elementUpdate", sender: cell)
            }
        case "horizontalScroll":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-horizontalScroll-carousel", sender: cell)
            }
        case "form":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-form-label", sender: cell)
            }
        case "readingOrder":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-readingorder-remotecontrol", sender: cell)
            }
        case "language":
            if (indexPath as NSIndexPath).row == 0 {
                self.performSegue(withIdentifier: "example-language-accent", sender: cell)
            }
            
        default:
            print("Category unknown")
        }
    }
    
    // MARK: - StoryBoard
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {

        let cell:UITableViewCell                = sender as! UITableViewCell
        let exampleNumber                       = ((tableView.indexPath(for: cell) as NSIndexPath?)?.row)!+1
        let examplesCount                       = tableView.dataSource?.tableView(tableView, numberOfRowsInSection: ((tableView.indexPath(for: cell) as NSIndexPath?)?.section)!)
        let theDestination: UIViewController    = segue.destination
        theDestination.title                    = "common_example".localized + " \(exampleNumber)/\(examplesCount!)"
    }
    
    
}
