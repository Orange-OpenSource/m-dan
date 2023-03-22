Accessibility-Statement-Library
------

Accessibility Statement Library contains a view showing the WCAG compliance status for its iOS application.

To use it, you need the XML accessibility result file from the [Orange va11ydette](https://la-va11ydette.orange.com/)

![Accessibility statement screen](preview_accessibility_statement.png)


Import Accessibility Statement lib in your project
------

1. To integrate DeclarationAccessibility into your Xcode project using CocoaPods, specify it in your Podfile
```
pod 'DeclarationAccessibility', :git => "https://gitlab.tech.orange/tayeb.sedraia/accessibility_ios_accessibility_statement.git"
```


Usage
-----
```swift
present(DeclarationViewController(), animated: true, completion: nil)
```

* Add the results XML file from the va11ydette in racine folder of your project and rename it "accessibility_result.xml"
* Fill in the attribute "declarations.detailUrl" with the complete accessibility statement URL of the app or fill in the storyboard ID (local webview)



Exemple
-----

1. To integrate DeclarationAccessibility with a Action (self.present)
```swift
import UIKit
import DeclarationAccessibility

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @available(iOS 10.0, *)
    @IBAction func buttonAction(_ sender: Any) {
        let declarationViewController = DeclarationViewController()
        declarationViewController.declarations.detailUrl = "https://a11y-guidelines.orange.com/fr/"
        declarationViewController.declarations.identityName = "ORANGE SA"
        declarationViewController.declarations.identityAdresse = "Siège social : 111, quai du Président Roosevelt, 92130 Issy-les-Moulineaux"
        declarationViewController.xmlPath = "accessibility_result"
        declarationViewController.setupNavigationleftBarCancelItem()
        declarationViewController.statusBarStyle = .lightContent
        let navigationController = UINavigationController(rootViewController: declarationViewController)
        self.present(navigationController, animated: true, completion: nil)
    }
}
```

2. To integrate DeclarationAccessibility with a Action (pushViewController)
* Prerequisite: add a navigation controller to the view
```swift
import UIKit
import DeclarationAccessibility

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @available(iOS 10.0, *)
    @IBAction func buttonAction(_ sender: Any) {
        let declarationViewController = DeclarationViewController()
        declarationViewController.declarations.detailUrl = "https://www.orange.fr/accessibilite?url=app.orangemoney.ios.orange.fr"
        declarationViewController.declarations.identityName = "ORANGE SA"
        declarationViewController.declarations.identityAdresse = "Siège social : 111, quai du Président Roosevelt, 92130 Issy-les-Moulineaux"
        declarationViewController.xmlPath = "accessibility_result"
        declarationViewController.statusBarStyle = .lightContent
        self.navigationController?.pushViewController(declarationViewController, animated: true)
    }
}
```

Warning
-----
If you have this problem while compiling :
```swift
open(_:options:completionHandler:) is unavailable in application extensions for iOS
shared is unavailable in application extensions for iOS: Use view controller based solutions where appropriate instead.
```
* it's probably due to the fact that you are using extensions in your application. Consequently, please insert lines in the podfile : 
```swift
    if target.name.eql? "DeclarationAccessibility"
        target.build_configurations.each do |config|
            config.build_settings['APPLICATION_EXTENSION_API_ONLY'] = "NO"
        end
    end
```
