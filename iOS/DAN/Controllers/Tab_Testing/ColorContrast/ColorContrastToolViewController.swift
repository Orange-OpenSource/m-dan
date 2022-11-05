import UIKit

class ColorContrastToolViewController: DefaultTableViewController {

    let textCellIdentifier      = "textCell"
    let imageInfoCellIdentifier = "testingImageInfoCell"
    let accessibleSection       = 1
    let notAccessibleSection    = 2
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.title = "testings_option_useColorContrast".localized
        self.navigationItem.rightBarButtonItem = .infosButton(self, action: #selector(displayVoiceOverMessage(_:)))
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
            ["testing_contrastColor_check"],
            [""],
            [""]
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
            
            let cell: TestingImageInfoTableViewCell = tableView.dequeueReusableCell(withIdentifier: imageInfoCellIdentifier, for: indexPath) as! TestingImageInfoTableViewCell
            
            
            if (indexPath as NSIndexPath).section == accessibleSection {
                cell.accessibilityConfiguration()
            }
            
            return cell
        }
    }
    
    // MARK: - TableViewDelegate
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        /*if indexPath.section == notAccessibleSection || indexPath.section == accessibleSection {
            return 213
        }
        else {
            return UITableViewAutomaticDimension
        }*/
        
        return UITableView.automaticDimension
    }
    
    override func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return UITableView.automaticDimension
    }
    
}

// ---------------------------------------------------------------------------
// Cell
// ---------------------------------------------------------------------------
class TestingImageInfoTableViewCell: UITableViewCell {
    
    @IBOutlet var buttonView: UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
    
    func accessibilityConfiguration() {
        
        buttonView.accessibilityLabel = "example_image_info_accessibilityLabel".localized
        buttonView.accessibilityHint = "example_image_info_accessibilityHint".localized
        buttonView.accessibilityTraits = UIAccessibilityTraits.button
        buttonView.setImage(UIImage(named: "ColorContrastOK"), for: .normal)
        
    }
    
}


