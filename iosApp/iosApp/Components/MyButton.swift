//
//  MyButton.swift
//  iosApp
//
//  Created by Deven on 27/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI


struct MyButton: View {
    var name: String
    var body: some View {
        Button(action: {
        }) {
            Text(name)
                .font(.system(size: 16, weight: .semibold))
                .frame(maxWidth: .infinity, maxHeight: 50)
                .background(Color(hex: 0xFFFF_B100))
                .foregroundColor(.black)
                .frame(maxWidth: .infinity)
        }
    }
}
