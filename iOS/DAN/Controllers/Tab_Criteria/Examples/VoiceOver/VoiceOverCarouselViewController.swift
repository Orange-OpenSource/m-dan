//
//  VoiceOverCarouselViewController.swift
//  mDAN
//
//  Created by Tayeb SEDRAIA on 03/09/2021.
//  Copyright © 2021 Devrap. All rights reserved.
//

import UIKit

class VoiceOverCarouselViewController: UIViewController {
    
    // MARK: - Properties
    @IBOutlet weak var scrollView: UIScrollView!
    @IBOutlet weak var pageControl: UIPageControl!
    @IBOutlet weak var titleLabel: UILabel!
    
    
    var pageImages: [UIImage]           = []
    var pageViews:  [UIImageView?]      = []
    var accessibilityLabels: [String]   = []
    var isAccessible                    = false
    
    // MARK: - View life cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        pageImages = [
            UIImage(named: "gesture-1")!,
            UIImage(named: "gesture-2")!,
            UIImage(named: "gesture-3")!,
            UIImage(named: "gesture-4")!,
            UIImage(named: "gesture-5")!,
            UIImage(named: "gesture-6")!,
            UIImage(named: "gesture-7")!,
            UIImage(named: "gesture-8")!,
            UIImage(named: "gesture-9")!,
            UIImage(named: "gesture-10")!,
        ]
        
        accessibilityLabels = [
            "example_horizontalScroll_carousel_imageLabel1".localized,
            "example_horizontalScroll_carousel_imageLabel2".localized,
            "example_horizontalScroll_carousel_imageLabel3".localized,
            "example_horizontalScroll_carousel_imageLabel1".localized,
            "example_horizontalScroll_carousel_imageLabel2".localized,
            "example_horizontalScroll_carousel_imageLabel3".localized,
            "example_horizontalScroll_carousel_imageLabel1".localized,
            "example_horizontalScroll_carousel_imageLabel2".localized,
            "example_horizontalScroll_carousel_imageLabel3".localized,
            "example_horizontalScroll_carousel_imageLabel3".localized
        ]
        
        pageControl.isHidden          = !isAccessible
        pageControl.currentPage     = 0
        pageControl.numberOfPages   = pageImages.count
        titleLabel.text             = "example_voiceover_carousel_accessibleCarousel".localized
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        
        super.viewDidAppear(animated)
        
        setUpCarousel()
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
            pageView.isAccessibilityElement = true
            
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
    
    func displayNextPage() {
        
        pageControl.currentPage = pageControl.currentPage+1
        
        pageControlValueDidChange(pageControl)
    }
    
    @IBAction func pageControlValueDidChange(_ sender: UIPageControl) {
        
        if !isAccessible {
            return
        }
        
        let page = Int(floor((scrollView.contentOffset.x * 2.0 + scrollView.frame.size.width) / (scrollView.frame.size.width * 2.0)))
        
        scrollView.scrollRectToVisible(CGRect(
                                        x: scrollView.frame.size.width * CGFloat(sender.currentPage),
                                        y: 0,
                                        width: scrollView.frame.size.width,
                                        height: scrollView.frame.size.height), animated: true)
        
        pageControl.currentPage = page
        print(pageControl)
    }
    
    // MARK: - Scrollview delegate
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        
        let page = Int(floor((scrollView.contentOffset.x * 2.0 + scrollView.frame.size.width) / (scrollView.frame.size.width * 2.0)))
        
        // Update the page control
        pageControl.currentPage = page
        
        if isAccessible {
            UIAccessibility.post(notification: .layoutChanged, argument: pageControl)
        }
    }
    
}
