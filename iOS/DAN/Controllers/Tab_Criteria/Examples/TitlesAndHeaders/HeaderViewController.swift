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

class HeaderViewController: DefaultTableViewController {

    let textCellIdentifier  = "textCell"
    
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
        
        var headers:[String] = []
        var cells:[[String]] = [[]]
        
        let countryCodes = Locale.isoRegionCodes.sorted(by: {
            
            (Locale.current as NSLocale).displayName(forKey: NSLocale.Key.countryCode, value: $0)! < (Locale.current as NSLocale).displayName(forKey: NSLocale.Key.countryCode, value: $1)!
        })
        
        for countryCode in countryCodes {
            
            let countryName         = (Locale.current as NSLocale).displayName(forKey: NSLocale.Key.countryCode, value: countryCode)!
            let noAccentCountryName = countryName.folding(options: .diacriticInsensitive, locale: Locale.current)
            
            if headers.count == 3 && cells[2].count > 2 {
                break;
            }
            
            let firstChar = String(noAccentCountryName[noAccentCountryName.startIndex])
            
            if !headers.contains(firstChar) {
                headers.append(firstChar)
            }
              
            if cells.count < headers.count {
                
                cells.append([countryName])
            }
            else {
                
                if cells[headers.index(of: firstChar)!].count >= 3 {
                    
                    continue
                }
                else {
                    cells[headers.index(of: firstChar)!].append(countryName)
                }
            }
        }
        
        sectionHeaders = [
            "common_description",
            "common_accessibleExample",
        ]
        sectionHeaders = sectionHeaders + headers
        /*
        sectionHeaders = sectionHeaders + ["common_notAccessibleExample"]
        sectionHeaders = sectionHeaders + headers
        */
        
        cellsContent = [
            ["example_titleAndHeader_header_description"],
            [""]
        ]
        cellsContent = cellsContent + cells
        /*
        cellsContent = cellsContent + [[""]]
        cellsContent = cellsContent + cells
        */
    }
    
    // MARK: - TableViewDataSource
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            let textCell: TextTableViewCell = tableView.dequeueReusableCell(withIdentifier: textCellIdentifier, for: indexPath) as! TextTableViewCell
            textCell.label.text             = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return textCell
        }
        else {
            let cell: UITableViewCell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
            
            cell.textLabel?.text = cellsContent[(indexPath as NSIndexPath).section][(indexPath as NSIndexPath).row].localized
            
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        let header: UIView = super.tableView(tableView, viewForHeaderInSection: section)!
        
        if section > 5 {
            header.isAccessibilityElement = false
        }
        return header;
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        if (indexPath as NSIndexPath).section == 0 {
            
            return UITableViewAutomaticDimension
        }
        else if ((indexPath as NSIndexPath).section == 1 || (indexPath as NSIndexPath).section == 5) && (indexPath as NSIndexPath).row == 0 {
            
            return 0;
        } else {
            
            return 44
        }
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return 44
    }
}
