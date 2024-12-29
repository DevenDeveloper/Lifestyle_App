//
//  ProgressSliderWithMinutes.swift
//  iosApp
//
//  Created by Deven on 29/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ProgressSliderWithMinutes: View {
    @State private var sliderValue: Float = 10
    private let maxMinutes: Float = 60

    var body: some View {
        VStack(alignment: .leading) {
            Text("How much time do you want to use?")
                .font(.callout)

            HStack {
                Slider(
                    value: $sliderValue,
                    in: 0...maxMinutes,
                    step: 1
                )
                .accentColor(Color(hex: 0xFF63_004E))
                

                Text("\(Int(sliderValue)) min")
                    .font(.system(size: 14).weight(.semibold))
                    .frame(width: 80, alignment: .trailing)
            }
        }
    }
}

