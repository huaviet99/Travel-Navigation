//
//  MapUIView.swift
//  TravelNavigation
//
//  Created by Viet Hua on 12/4/22.
//

import UIKit

class MapUIView: UIView {

    @IBOutlet var mContentView: UIView!
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupView()
    }
        
    private func setupView() {
        Bundle.main.loadNibNamed("MapUIView", owner: self, options: nil)
        addSubview(mContentView)
        self.mContentView.frame = self.bounds
    }


    @IBAction func buttonClick(_ sender: UIButton) {
        print("hello")
    }
}
