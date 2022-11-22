//
//  CircularProgressBar.swift
//  a11y-modele-declaration
//
//  Created by Tayeb SEDRAIA on 22/03/2021.
//

import Foundation
import UIKit

@IBDesignable
public class CircularProgressBar: UIView {
    @IBInspectable public var color: UIColor? = .systemBlue {
        didSet { setNeedsDisplay() }
    }
    @IBInspectable public var ringWidth: CGFloat = 13

    public var progress: CGFloat = 0 {
        didSet { setNeedsDisplay() }
    }

    public var progressLayer = CAShapeLayer()
    public var backgroundMask = CAShapeLayer()

    override init(frame: CGRect) {
        super.init(frame: frame)
        setupLayers()

    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupLayers()
    }

    public func setupLayers() {
        backgroundMask.lineWidth = ringWidth
        backgroundMask.fillColor = nil
        backgroundMask.strokeColor = UIColor.black.cgColor
        layer.mask = backgroundMask

        progressLayer.lineWidth = ringWidth
        progressLayer.fillColor = nil
        layer.addSublayer(progressLayer)
        layer.transform = CATransform3DMakeRotation(CGFloat(90 * Double.pi / 180), 0, 0, -1)
    }

    public override func draw(_ rect: CGRect) {
        let circlePath = UIBezierPath(ovalIn: rect.insetBy(dx: ringWidth / 2, dy: ringWidth / 2))
        backgroundMask.path = circlePath.cgPath

        progressLayer.path = circlePath.cgPath
        progressLayer.lineCap = .round
        progressLayer.strokeStart = 0
        progressLayer.strokeEnd = progress
        progressLayer.strokeColor = UIColor.systemBlue.cgColor
    }
}
