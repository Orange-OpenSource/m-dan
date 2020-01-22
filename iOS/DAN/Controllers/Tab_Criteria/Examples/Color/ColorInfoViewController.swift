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

class ColorInfoViewController: DefaultTableViewController {

    let textCellIdentifier          = "textCell"
    let legendCellIdentifier        = "legendCell"
    let serviceInfoCellIdentifier   = "serviceInfoCell"
    let accessibleSection           = 1
    
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
            "common_description",
            "common_accessibleExample",
            "common_notAccessibleExample"
        ]
        
        cellsContent = [
            ["example_color_info_description"],
            ["", "example_color_info_serviceMail", "example_color_info_serviceAudio", "example_color_info_serviceVideo", "example_color_info_serviceBrowser"],
            ["example_color_info_serviceMail", "example_color_info_serviceAudio", "example_color_info_serviceVideo", "example_color_info_serviceBrowser"]
        ]
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            let textCell: TextTableViewCell = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text             = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else if (indexPath as NSIndexPath).section == accessibleSection || (indexPath as NSIndexPath).section == 2 {
            
            if (indexPath as NSIndexPath).section == accessibleSection && (indexPath as NSIndexPath).row == 0 {
                
                let cell: LegendTableViewCell = tableView.dequeueReusableCell(withIdentifier: legendCellIdentifier, for: indexPath) as! LegendTableViewCell
                
                cell.legendTitleLabel.text      = "example_color_info_statusLegendTitle".localized
                cell.statusActiveLabel.text     = "example_color_info_statusLegendOn".localized
                cell.statusErrorLabel.text      = "example_color_info_statusLegendError".localized
                cell.statusInactiveLabel.text   = "example_color_info_statusLegendOff".localized
                
                cell.accessibilityElementsHidden = true
                
                return cell
            }
            else {
                var serviceImage: UIImage
                var statusImage: UIImage
                
                let serviceIndexRow = (indexPath as NSIndexPath).section == accessibleSection ? (indexPath as NSIndexPath).row-1 : (indexPath as NSIndexPath).row
                let accessibilityLabelStatus: String
                
                switch serviceIndexRow {
                    
                case 0:
                    serviceImage                = UIImage(named: "service_email")!
                    statusImage                 = UIImage(named: "status_on")!
                    accessibilityLabelStatus    = "example_color_info_AL_active".localized
                case 1:
                    serviceImage                = UIImage(named: "service_audio")!
                    statusImage                 = (indexPath as NSIndexPath).section == accessibleSection ? UIImage(named: "status_error")! : UIImage(named: "status_error_circle")!
                    accessibilityLabelStatus    = "example_color_info_AL_error".localized
                case 2:
                    serviceImage                = UIImage(named: "service_video")!
                    statusImage                 = (indexPath as NSIndexPath).section == accessibleSection ? UIImage(named: "status_off")! : UIImage(named: "status_off_circle")!
                    accessibilityLabelStatus    = "example_color_info_AL_inactive".localized
                case 3:
                    serviceImage                = UIImage(named: "service_browser")!
                    statusImage                 = (indexPath as NSIndexPath).section == accessibleSection ? UIImage(named: "status_error")! : UIImage(named: "status_error_circle")!
                    accessibilityLabelStatus    = "example_color_info_AL_error".localized
                default:
                    // TODO: how to handle nil images ?
                    serviceImage                = UIImage(named: "settings")!
                    statusImage                 = UIImage(named: "settings")!
                    accessibilityLabelStatus    = ""
                }
                
                let serviceInfoCell: ServiceInfoTableViewCell               = tableView.dequeueReusableCell(withIdentifier: serviceInfoCellIdentifier, for: indexPath) as! ServiceInfoTableViewCell
                serviceInfoCell.serviceTitleLabel.text                      = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
                serviceInfoCell.serviceImage.image                          = serviceImage
                serviceInfoCell.serviceStatusImage.image                    = statusImage
                serviceInfoCell.serviceStatusImage.isAccessibilityElement   = (indexPath as NSIndexPath).section == accessibleSection
                serviceInfoCell.serviceStatusImage.accessibilityLabel       = "example_color_info_AL_service".localized + " " + cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized + " " + accessibilityLabelStatus
                
                return serviceInfoCell
            }
        }
        else {
            
            return UITableViewCell()
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == accessibleSection && (indexPath as NSIndexPath).row == 0 {
            return UITableView.automaticDimension
        } else if (indexPath as NSIndexPath).section == 0 {
            return UITableView.automaticDimension
        } else {
            return 44
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        return 44
    }
}
