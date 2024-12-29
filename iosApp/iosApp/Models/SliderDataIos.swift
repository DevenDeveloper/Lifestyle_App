//
//  SliderDataIos.swift
//  iosApp
//
//  Created by Deven on 28/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

struct SliderDataIos: Identifiable {
    let id = UUID()
    let imageName: String
    let title: String
    let desc: String
    var sliderValue: Float
}
