//
//  TextAndSubTextTableViewCell.swift
//  mDAN
//
//  Created by Tayeb SEDRAIA on 13/09/2021.
//  Copyright © 2021 Devrap. All rights reserved.
//

import UIKit

class TextAndSubTextTableViewCell: UITableViewCell {
    
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var subLabel: UILabel!
    
    override func awakeFromNib() {
    super.awakeFromNib()
}

override func setSelected(_ selected: Bool, animated: Bool) {
    super.setSelected(selected, animated: animated)
}

}
