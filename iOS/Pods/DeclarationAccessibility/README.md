Accessibility-Statement-Library
------

Accessibility Statement Library contains a view showing the WCAG compliance status for its iOS application.

To use it, you need the XML accessibility result file from the Orange va11ydette.

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


Exemple
-----

1. To integrate DeclarationAccessibility with a IBAction
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
        present(declarationViewController, animated: true, completion: nil)
    }
}
```

2. To integrate DeclarationAccessibility into your viewDidLoad
```swift
import UIKit
import DeclarationAccessibility

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        let declarationViewController = DeclarationViewController()
        self.show(declarationViewController, sender: nil)
        navigationController?.setNavigationBarHidden(true, animated: false)
        declarationViewController.declarations.detailUrl = "https://a11y-guidelines.orange.com/fr/"
        declarationViewController.declarations.identityName = "ORANGE SA"
        declarationViewController.declarations.identityAdresse = "Siège social : 111, quai du Président Roosevelt, 92130 Issy-les-Moulineaux"
    }
}
```
