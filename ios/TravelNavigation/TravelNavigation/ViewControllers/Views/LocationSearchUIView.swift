//
//  LocationSearchUIView.swift
//  TravelNavigation
//
//  Created by Viet Hua on 12/5/22.
//

import UIKit

class LocationSearchUIView: UIView {
    @IBOutlet var mContentView: UIView!
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupView()
    }
    
    @IBAction func buttonClick(_ sender: UIButton) {
        print("hello 2")
    }
    private func setupView() {
        Bundle.main.loadNibNamed("LocationSearchUIView", owner: self, options: nil)
        addSubview(mContentView)
        self.mContentView.frame = self.bounds
    }
}
