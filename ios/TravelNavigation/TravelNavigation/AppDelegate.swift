//
//  AppDelegate.swift
//  TravelNavigation
//
//  Created by Viet Hua on 12/4/22.
//

import UIKit

@main
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        guard let travelNavigationViewController = UIStoryboard.init(name: "TravelNavigation", bundle: nil).instantiateViewController(withIdentifier: "TravelNavigationViewController") as? TravelNavigationViewController else {
            return true
        }

        let rootNavigationController = UINavigationController(rootViewController: travelNavigationViewController)
        rootNavigationController.setNavigationBarHidden(true, animated: false)
        window?.rootViewController = rootNavigationController
        window?.makeKeyAndVisible()
        return true
    }
}

