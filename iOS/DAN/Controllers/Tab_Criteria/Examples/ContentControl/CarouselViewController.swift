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

class CarouselViewController: UIViewController, UIScrollViewDelegate {

    // MARK: - Properties
    @IBOutlet weak var scrollView:  UIScrollView!
    @IBOutlet weak var titleLabel:  UILabel!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var pageImages: [UIImage]           = []
    var pageViews:  [UIImageView?]      = []
    var accessibilityLabels: [String]   = []
    var isAccessible                    = false
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if isAccessible {
            pageImages = [
                UIImage(named: "carousel_img1.jpg")!,
                UIImage(named: "carousel_img2.jpg")!,
                UIImage(named: "carousel_img3.jpg")!,
            ]
            
            accessibilityLabels = [
                "example_contentControl_carousel_imageLabel1".localized,
                "example_contentControl_carousel_imageLabel2".localized,
                "example_contentControl_carousel_imageLabel3".localized
            ]
        }
        else {
            
            pageImages = [
                UIImage(named: "carousel_img3.jpg")!,
                UIImage(named: "carousel_img1.jpg")!,
                UIImage(named: "carousel_img2.jpg")!,
                UIImage(named: "carousel_img3.jpg")!,
                UIImage(named: "carousel_img1.jpg")!
            ]
            
            accessibilityLabels = [
                "example_contentControl_carousel_nonAccessibleImageLabel3".localized,
                "example_contentControl_carousel_nonAccessibleImageLabel1".localized,
                "example_contentControl_carousel_nonAccessibleImageLabel2".localized,
                "example_contentControl_carousel_nonAccessibleImageLabel3".localized,
                "example_contentControl_carousel_nonAccessibleImageLabel1".localized,
            ]
        }
        
        pageControl.isHidden          = !isAccessible
        pageControl.currentPage     = 0
        pageControl.numberOfPages   = pageImages.count
        titleLabel.text             = isAccessible ? "example_contentControl_carousel_accessibleCarousel".localized : "example_contentControl_carousel_nonAccessibleCarousel".localized
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        
        super.viewDidAppear(animated)
        
        setUpCarousel()
        
        if isAccessible {
            pageControl.isAccessibilityElement  = true
            pageControl.accessibilityTraits     = .adjustable
        }
        else {
            
            scrollView.isScrollEnabled = false
            
            scrollView.scrollRectToVisible(CGRect(
                x: scrollView.frame.size.width,
                y: 0,
                width: scrollView.frame.size.width,
                height: scrollView.frame.size.height), animated: false)
            
            pageControl.currentPage = 1
            
            let _ = Timer.scheduledTimer(timeInterval: 2.5, target: self, selector: #selector(CarouselViewController.displayNextPage), userInfo: nil, repeats: true)
        }
    }
    
    override func didRotate(from fromInterfaceOrientation: UIInterfaceOrientation) {
    
        for i:NSInteger in 0..<pageImages.count {
        
            pageViews[i]?.removeFromSuperview()
        }

        pageViews.removeAll()
        setUpCarousel()
    }
    
    // MARK: - Private methods
    func setUpCarousel() {
        
        for i:NSInteger in 0..<pageImages.count {
            
            let pageView            = UIImageView(image: pageImages[i])
            pageView.contentMode    = .scaleAspectFit
            pageView.frame          = CGRect(
                x: scrollView.frame.size.width * CGFloat(i),
                y: 0,
                width: scrollView.frame.size.width,
                height: scrollView.frame.size.height).insetBy(dx: 10.0, dy: 0.0)
            
            pageView.accessibilityLabel     = accessibilityLabels[i]
            pageView.isAccessibilityElement = true  //isAccessible
            
            if isAccessible && i == 1 || isAccessible && i == 2 {
                
                pageView.accessibilityTraits.insert(.button)
            }
            
            scrollView.addSubview(pageView)
            pageViews.append(pageView)
        }
        
        scrollView.contentSize = CGSize(
            width: scrollView.frame.size.width * CGFloat(pageImages.count),
            height: scrollView.frame.size.height)

    }
    
    @objc func displayNextPage() {
        
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
    func scrollViewDidEndScrollingAnimation(_ scrollView: UIScrollView) {
        
        if !isAccessible {
            
            if pageControl.currentPage == pageViews.count-1 {
                
                scrollView.scrollRectToVisible(CGRect(
                    x: scrollView.frame.size.width,
                    y: 0,
                    width: scrollView.frame.size.width,
                    height: scrollView.frame.size.height), animated: false)
                
                pageControl.currentPage = 1
            }
        }
    }
    
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        
        let page = Int(floor((scrollView.contentOffset.x * 2.0 + scrollView.frame.size.width) / (scrollView.frame.size.width * 2.0)))
        
        // Update the page control
        pageControl.currentPage = page
        
        if isAccessible {
            UIAccessibility.post(notification: .layoutChanged, argument: pageControl)
        }
    }
}
