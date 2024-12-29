//
//  TimeSelectorCustomView.swift
//  iosApp
//
//  Created by Deven on 28/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TimeSelectorCustomView: View {
    @State private var strengthTime: Float = 10
    @State private var enduranceTime: Float = 10
    @State private var balanceTime: Float = 10
    @State private var flexibilityTime: Float = 10
    
    var totalTime: Int {
        Int(strengthTime + enduranceTime + balanceTime + flexibilityTime)
    }
    @State private var sliderItems: [SliderDataIos] = []
    
    init() {
        
        let sliderData = SliderDataLoader().loadSliderData()
        _sliderItems = State(initialValue: sliderData.map {
            SliderDataIos(imageName: $0.image, title: $0.title, desc: $0.desc, sliderValue: 10)
        })
        DispatchQueue.main.async {
            print("Slider Items in init: \(SliderDataLoader().loadSliderData())")
        }
        let thumbImage = UIImage(systemName: "circle.fill")
        UISlider.appearance().setThumbImage(thumbImage, for: .normal)
    }
    var body: some View {
        
        VStack(alignment: .leading, spacing: 10) {
            Text("Select capacity time")
                .font(.headline)
                .padding(.leading, 16)
            
            ForEach($sliderItems) { $item in
                SliderWithTitleAndDescription(
                    imageName: item.imageName,
                    title: item.title,
                    description: item.desc,
                    sliderValue: $item.sliderValue
                )
            }
            HStack {
                Text("Total exercise time:")
                    .font(.headline)
                Spacer()
                Text("\(totalTime) min")
                    .font(.headline)
            }
            .padding(20)
            .background(Color.white)
            .cornerRadius(12)
            .padding(.horizontal, 16)
        }
        
    }
}

struct SliderWithTitleAndDescription: View {
    let imageName: String
    let title: String
    let description: String
    @Binding var sliderValue: Float
    
    var body: some View {
        VStack(alignment: .leading, spacing: 10) {
            HStack(spacing: 12) {
                Image(imageName)
                    .resizable()
                    .frame(width: 40, height: 40)
                Text(title)
                    .font(.headline)
            }
            Text(description)
                .font(.subheadline)
                .foregroundColor(.black.opacity(0.8))
            ProgressSliderWithMinutes1(sliderValue: $sliderValue)
        }
        .padding(20)
        .background(Color.white)
        .cornerRadius(12)
        .padding(.horizontal, 16)
    }
}

struct ProgressSliderWithMinutes1: View {
    @Binding var sliderValue: Float
    let maxMinutes: Float = 60
   
    var body: some View {
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
