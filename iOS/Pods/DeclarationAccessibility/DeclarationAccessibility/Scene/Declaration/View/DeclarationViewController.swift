//
//  DeclarationViewController.swift
//  DeclarationAccessibility
//
//  Created by Tayeb SEDRAIA on 17/05/2021.
//

import UIKit

@available(iOS 10.0, *)
open class DeclarationViewController: UIViewController {

    public var colorRed: CGFloat = 255
    public var colorGreen: CGFloat = 122
    public var colorBlue: CGFloat = 51
    public var declarations: Declaration = Declaration()
    public var elementDeclaration: String = String()
    
    let bundle = Bundle(for: DeclarationViewController.self)
    
    @IBOutlet weak var circularProgressBar: CircularProgressBar!
    @IBOutlet weak var declarationLabel: UILabel!
    @IBOutlet weak var averageTitleLabel: UILabel!
    @IBOutlet weak var resultDeclarationLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var dateDataLabel: UILabel!
    @IBOutlet weak var identityLabel: UILabel!
    @IBOutlet weak open var identityNameDataLabel: UILabel!
    @IBOutlet weak var identityAdresseDataLabel: UILabel!
    @IBOutlet weak var referentialLabel: UILabel!
    @IBOutlet weak var referentialDataLabel: UILabel!
    @IBOutlet weak var technologyLabel: UILabel!
    @IBOutlet weak var technologyDataLabel: UILabel!
    @IBOutlet weak var detailButton: UIButton!
    
    
    public override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        setupXml()
        setupColor()
        setupTextfields()
        setupValue()
    }

    open override func viewWillAppear(_ animated: Bool){

        super.viewWillAppear(animated)
        view.setNeedsLayout()
    }
    
    public func setupXml() {
        if let path = Bundle.main.url(forResource: "accessibility_result", withExtension: "xml") {
            if let parser = XMLParser(contentsOf: path) {
                parser.delegate = self
                parser.parse()
            }

            Logger.log(.success, path.debugDescription)
            setupValue()
        } else {
            Logger.log(.error, "No load xml file")
        }

    }

    public func setupColor() {
        let mainColor = UIColor(red: colorRed / 255, green: colorGreen / 255, blue: colorBlue / 255, alpha: 1)
        circularProgressBar.color = mainColor
    }
    
    public func setupTextfields() {
        
        title = NSLocalizedString("declaration_title", tableName: "Localizable", bundle: bundle, comment: "")
        dateLabel.text = NSLocalizedString("date_title", tableName: "Localizable", bundle: bundle, comment: "")
        identityLabel.text = NSLocalizedString("identity_title", tableName: "Localizable", bundle: bundle, comment: "")
        referentialLabel.text = NSLocalizedString("referential_title", tableName: "Localizable", bundle: bundle, comment: "")
        technologyLabel.text = NSLocalizedString("technology_title", tableName: "Localizable", bundle: bundle, comment: "")
        detailButton.setTitle(NSLocalizedString("detail_button", tableName: "Localizable", bundle: bundle, comment: ""), for: .normal)
        detailButton.titleLabel?.adjustsFontForContentSizeCategory = true
        detailButton.contentHorizontalAlignment = .right

    }
    
    public func setupValue() {
        let result = declarations.conformity.split(separator: " ")
        let conformityArrayDouble = result.map { Double($0)! }
        let sumArray = conformityArrayDouble.reduce(0, +)
        let average = (sumArray / Double(conformityArrayDouble.count))
        circularProgressBar.progress = CGFloat(average / 100)
        
        /// Average
        if !average.isNaN {
            averageTitleLabel.text = String(format: NSLocalizedString("average_title_label", tableName: "Localizable", bundle: bundle, comment: ""), Int(average).description + "%")

        } else {
            Logger.log(.error, "XML format is not conform")
            return
        }
        
        ///Decalaration result
        resultDeclarationLabel.text = String(format: NSLocalizedString("result_declaration_subtitle", tableName: "Localizable", bundle: bundle, comment: ""), Int(average).description + "%")
            
        ///Date result
        dateDataLabel.text = self.dateToFrench(inputDate: self.declarations.auditDate)

        ///Technology
        if let i = self.declarations.technologies.lastIndex(of: ",") {
            let _ = String(self.declarations.technologies.remove(at: i))
            technologyDataLabel.text = self.declarations.technologies
        }

        
        ///Referential
        let version = declarations.referentialVersion.split(separator: " ")
        let level = declarations.referentialLevel
        let fullReferential = "WCAG \(String(version.first!))  \(level)"
        referentialDataLabel.text = fullReferential
        
        ///Identity
        identityNameDataLabel.text = declarations.identityName
        identityAdresseDataLabel.text = declarations.identityAdresse
    }
    
    public func dateToFrench(inputDate: String) -> String {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-mm-dd"

        guard let date = dateFormatter.date(from: inputDate) else { return "" }
            dateFormatter.locale = Locale(identifier: "fr")
            dateFormatter.dateFormat = DateFormatter.dateFormat(fromTemplate: "dd-MMM-yyyy", options: 0, locale: dateFormatter.locale)
        let frenchDate = dateFormatter.string(from: date)
        return frenchDate
    }

    public init() {
        super.init(nibName: "DeclarationViewController", bundle: Bundle(for: DeclarationViewController.self))
    }
    
    required public init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    @IBAction func openDetailButton(_ sender: UIButton) {
        if let url = URL(string: declarations.detailUrl) {
            print(url)
            UIApplication.shared.open(url, options: [:], completionHandler: nil)
        }
    }
}

@available(iOS 10.0, *)
extension DeclarationViewController: XMLParserDelegate {

    public func parser(_ parser: XMLParser, didStartElement elementName: String, namespaceURI: String?, qualifiedName qName: String?, attributes attributeDict: [String : String] = [:]) {

        self.elementDeclaration = elementName
    }

    public func parser(_ parser: XMLParser, foundCharacters string: String) {
        let data = string.trimmingCharacters(in: CharacterSet.whitespacesAndNewlines)

        if (!data.isEmpty) {
            switch self.elementDeclaration {
            case "title_app":
                self.declarations.title += " \(data)"
            case "audit_date":
                self.declarations.auditDate += " \(data)"
            case "conformity":
                self.declarations.conformity += " \(data)"
            case "technology":
                self.declarations.technologies += "\(data), "
            case "version":
                self.declarations.referentialVersion += " \(data)"
            case "level":
                self.declarations.referentialLevel += data
            default:
                break
            }
        }
    }
}
