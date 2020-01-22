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

class VoiceOverCarouselViewController: UIViewController, UIScrollViewDelegate, UIGestureRecognizerDelegate {
    
    // MARK: - Properties
    @IBOutlet weak var scrollView:      UIScrollView!
    @IBOutlet weak var contentLabel:    UILabel!
    @IBOutlet weak var pageControl:     UIPageControl!
    
    var pageImages: [UIImage]   = []
    var pageViews:  [UIView]    = []
    var titles: [String]        = []
    var contents: [String]      = []
    
    let appleDocUrl             = "http://help.apple.com/iphone/9/?lang=fr#/iph3e2e415f"
    let imagesLicenseURL        = "http://creativecommons.org/licenses/by-sa/2.0/deed.en"
    let imagesCreditURL         = "http://www.flickr.com/people/27512715@N02/"
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        pageImages = [
            UIImage(named: "gesture-1.jpg")!,
            UIImage(named: "gesture-2.jpg")!,
            UIImage(named: "gesture-3.jpg")!,
            UIImage(named: "gesture-4.jpg")!,
            UIImage(named: "gesture-5.jpg")!,
            UIImage(named: "gesture-6.jpg")!,
            UIImage(named: "gesture-7.jpg")!,
            UIImage(named: "gesture-8.jpg")!,
            UIImage(named: "gesture-9.jpg")!,
            UIImage(named: "gesture-10.jpg")!,
            #imageLiteral(resourceName: "icon_infos")
        ]
            
        titles = [
            "voiceover_gesture_action_1".localized,
            "voiceover_gesture_action_2".localized,
            "voiceover_gesture_action_3".localized,
            "voiceover_gesture_action_4".localized,
            "voiceover_gesture_action_5".localized,
            "voiceover_gesture_action_6".localized,
            "voiceover_gesture_action_7".localized,
            "voiceover_gesture_action_8".localized,
            "voiceover_gesture_action_9".localized,
            "voiceover_gesture_action_10".localized,
            ""
        ]
        
        contents = [
            "voiceover_gesture_result_1".localized,
            "voiceover_gesture_result_2".localized,
            "voiceover_gesture_result_3".localized,
            "voiceover_gesture_result_4".localized,
            "voiceover_gesture_result_5".localized,
            "voiceover_gesture_result_6".localized,
            "voiceover_gesture_result_7".localized,
            "voiceover_gesture_result_8".localized,
            "voiceover_gesture_result_9".localized,
            "voiceover_gesture_result_10".localized,
            ""
        ]
        
        pageControl.currentPage     = 0
        pageControl.numberOfPages   = pageImages.count
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        
        super.viewDidAppear(animated)
        
        setUpCarousel()

        pageControl.isAccessibilityElement  = true
        pageControl.accessibilityTraits     = UIAccessibilityTraits.adjustable
    }
    
    override func didRotate(from fromInterfaceOrientation: UIInterfaceOrientation) {
        
        for i:NSInteger in 0..<pageImages.count {
            
            pageViews[i].removeFromSuperview()
        }
        
        pageViews.removeAll()
        setUpCarousel()
    }
    
    // MARK: - Private methods
    func setUpCarousel() {
        
        for i:NSInteger in 0..<pageImages.count {
            
            let pageView = UIView()
            pageView.frame         = CGRect(
                x: scrollView.frame.size.width * CGFloat(i),
                y: 0,
                width: scrollView.frame.size.width,
                height: scrollView.frame.size.height).insetBy(dx: 10.0, dy: 0.0)
            
            let imageView           = UIImageView(image: pageImages[i])
            imageView.contentMode   = .scaleAspectFit
            imageView.translatesAutoresizingMaskIntoConstraints = false
            
            let imageHorizontalConstraint = NSLayoutConstraint(item: imageView, attribute: .centerX, relatedBy: .equal, toItem: pageView, attribute: .centerX, multiplier: 1, constant: 0)
            
            var imageWidthConstraint = NSLayoutConstraint(item: imageView, attribute: .width, relatedBy: .equal, toItem: nil, attribute: .notAnAttribute, multiplier: 1, constant: pageView.frame.size.width)
            var imageHeightConstraint = NSLayoutConstraint(item: imageView, attribute: .height, relatedBy: .equal, toItem: nil, attribute: .notAnAttribute, multiplier: 1, constant: 2*pageView.frame.size.height/3)
            
            imageView.isAccessibilityElement = false
            
            
            let titleLabel = UILabel()
            
            titleLabel.translatesAutoresizingMaskIntoConstraints = false
            let titleHorizontalConstraint = NSLayoutConstraint(item: titleLabel, attribute: .centerX, relatedBy: .equal, toItem: pageView, attribute:
            .centerX, multiplier: 1, constant: 0)
            let titleLeadingContraint = NSLayoutConstraint(item: titleLabel, attribute: .leading, relatedBy: .equal, toItem: pageView, attribute: .leading, multiplier: 1.0,constant: 25)
            let titleWidthConstraint = NSLayoutConstraint(item: titleLabel, attribute: .width, relatedBy: .equal, toItem: nil, attribute: .notAnAttribute, multiplier: 1, constant: pageView.frame.size.width - 50)
            
            titleLabel.text = titles[i]
            titleLabel.textColor = UIColor.white
            titleLabel.textAlignment = NSTextAlignment.center
            titleLabel.numberOfLines = 0
            titleLabel.font = UIFont.boldSystemFont(ofSize: 18.0)
            
            let contentLabel = UILabel()
            
            contentLabel.translatesAutoresizingMaskIntoConstraints = false
            let contentHorizontalConstraint = NSLayoutConstraint(item: contentLabel, attribute: .centerX, relatedBy: .equal, toItem: pageView, attribute: .centerX, multiplier: 1, constant: 0)
            let contentLeadingContraint = NSLayoutConstraint(item: contentLabel, attribute: .leading, relatedBy: .equal, toItem: pageView, attribute: .leading, multiplier: 1.0,constant: 15)
            let contentBottomContraint = NSLayoutConstraint(item: pageView, attribute: .bottom, relatedBy: .equal, toItem: contentLabel, attribute: .bottom, multiplier: 1.0,constant: 10)
            let contentWidthConstraint = NSLayoutConstraint(item: contentLabel, attribute: .width, relatedBy: .equal, toItem: nil, attribute: .notAnAttribute, multiplier: 1, constant: pageView.frame.size.width - 30)
            
            var titleBottomConstraint = NSLayoutConstraint(item: contentLabel, attribute: .top, relatedBy: .equal, toItem: titleLabel, attribute: .bottom, multiplier: 1, constant: 15)
            
            var imageBottomConstraint = NSLayoutConstraint(item: titleLabel, attribute: .top, relatedBy: .equal, toItem: imageView, attribute: .bottom, multiplier: 1, constant: 15)
            
            contentLabel.text = contents[i]
            contentLabel.textColor = UIColor.orange_functionalGrey5()
            contentLabel.textAlignment = NSTextAlignment.center
            contentLabel.numberOfLines = 0
            contentLabel.font = contentLabel.font.withSize(14)
            
            
            if(i == pageImages.count - 1){
                imageWidthConstraint = NSLayoutConstraint(item: imageView, attribute: .width, relatedBy: .equal, toItem: nil, attribute: .notAnAttribute, multiplier: 1, constant: pageView.frame.size.width/3)
                imageHeightConstraint = NSLayoutConstraint(item: imageView, attribute: .height, relatedBy: .equal, toItem: nil, attribute: .notAnAttribute, multiplier: 1, constant: pageView.frame.size.height/3)
                
                titleBottomConstraint = NSLayoutConstraint(item: contentLabel, attribute: .top, relatedBy: .equal, toItem: titleLabel, attribute: .bottom, multiplier: 1, constant: 15)
                
                imageBottomConstraint = NSLayoutConstraint(item: titleLabel, attribute: .top, relatedBy: .equal, toItem: imageView, attribute: .bottom, multiplier: 1, constant: 15)

                imageView.tintColor = UIColor.orange_orangeForBlackText()
                
                let creditTitleString  = NSMutableAttributedString(string:"voiceover_text_links".localized)
                let docLink     = NSMutableAttributedString(string:"voiceover_appleDocLink".localized)
                docLink.addAttribute(NSAttributedString.Key.link, value: appleDocUrl, range: NSMakeRange(0, docLink.length))
                //docLink.addAttribute(NSForegroundColorAttributeName, value: UIColor.orange_orangeForBlackText(),range: NSMakeRange(0, docLink.length))
                
                creditTitleString.append(docLink)
                titleLabel.isUserInteractionEnabled = true
                titleLabel.attributedText = creditTitleString
                let gestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(showDoc))
                gestureRecognizer.delegate = self
                titleLabel.addGestureRecognizer(gestureRecognizer)
                
                let creditString  = NSMutableAttributedString(string:"voiceover_imagesLicense".localized)
                let creditString2 = NSMutableAttributedString(string:"\n"+"voiceover_imagesCredit".localized)
                let link          = NSMutableAttributedString(string: "voiceover_imagesCreditLink".localized+")")
                
                link.addAttribute(NSAttributedString.Key.link, value: imagesCreditURL, range: NSMakeRange(0, link.length))
                link.addAttribute(NSAttributedString.Key.underlineStyle, value:1, range: NSMakeRange(0, link.length))
                
                creditString2.append(link)
                creditString.append(creditString2)
                
                creditString.addAttribute(NSAttributedString.Key.font, value: UIFont.systemFont(ofSize: 11), range: NSMakeRange(0, creditString.length))
                
                contentLabel.attributedText = creditString
                contentLabel.accessibilityLanguage = "en"
                contentLabel.textAlignment = NSTextAlignment.left
                
                contentLabel.isUserInteractionEnabled = true
                let gestureRecognizer2 = UITapGestureRecognizer(target: self, action: #selector(showCredit))
                gestureRecognizer2.delegate = self
                contentLabel.addGestureRecognizer(gestureRecognizer2)


            }
            
            pageView.addSubview(imageView)
            pageView.addSubview(titleLabel)
            pageView.addSubview(contentLabel)
            NSLayoutConstraint.activate([imageHorizontalConstraint, imageWidthConstraint, imageHeightConstraint, titleHorizontalConstraint, titleLeadingContraint, titleWidthConstraint, contentHorizontalConstraint, contentLeadingContraint, contentBottomContraint, contentWidthConstraint,  titleBottomConstraint, imageBottomConstraint])
            scrollView.addSubview(pageView)
            pageViews.append(pageView)
            
        }
        
        scrollView.contentSize = CGSize(
            width: scrollView.frame.size.width * CGFloat(pageImages.count),
            height: scrollView.frame.size.height)
        
    }
    
    @objc func showCredit(gestureRecognizer: UIGestureRecognizer) {
        UIApplication.shared.openURL(URL(string:imagesCreditURL)!)
    }
    
    @objc func showDoc(gestureRecognizer: UIGestureRecognizer) {
        UIApplication.shared.openURL(URL(string:appleDocUrl)!)
    }

    
    func displayNextPage() {
        
        pageControl.currentPage = pageControl.currentPage+1
        
        pageControlValueDidChange(pageControl)
    }
    
    @IBAction func pageControlValueDidChange(_ sender: UIPageControl) {
        
        let page = Int(floor((scrollView.contentOffset.x * 2.0 + scrollView.frame.size.width) / (scrollView.frame.size.width * 2.0)))
        
        scrollView.scrollRectToVisible(CGRect(
            x: scrollView.frame.size.width * CGFloat(sender.currentPage),
            y: 0,
            width: scrollView.frame.size.width,
            height: scrollView.frame.size.height), animated: true)
        
        pageControl.currentPage = page
        
    }
    
    // MARK: - Scrollview delegate

    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        
        let page = Int(floor((scrollView.contentOffset.x * 2.0 + scrollView.frame.size.width) / (scrollView.frame.size.width * 2.0)))
        
        // Update the page control
        pageControl.currentPage = page
        
        UIAccessibility.post(notification: .layoutChanged, argument: pageControl)
    }
}
