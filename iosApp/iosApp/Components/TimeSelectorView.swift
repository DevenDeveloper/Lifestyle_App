//
//  TimeSelectorView.swift
//  iosApp
//
//  Created by Deven on 28/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct TimeSelectorView: View {
    var body: some View {
        HStack {
            Label(name: "Time")
                .frame(maxWidth: .infinity, alignment: .leading)
            NavigationLink(destination: CustomWorkoutView()) {
                UnderlineText(text: "Customize")
            }
        }
        .frame(maxWidth: .infinity)
        VStack(spacing: 10) {
            ProgressSliderWithMinutes()
        }
        .padding(20)
        .background(Color.white.cornerRadius(12))
        .frame(maxWidth: .infinity, alignment: .center)
    }
}
