//
//  SelectionItem.swift
//  iosApp
//
//  Created by Deven on 27/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI


struct SelectionItem: View {
    let imageName: String
    let label: String
    let isSelected: Bool
    let onClick: () -> Void

    var body: some View {
        VStack {
            Image(imageName)
                .resizable()
                .scaledToFit()
                .frame(height: 42)
                .padding(.top, 14)
                .padding(.bottom, 4)

            Text(label)
                .font(.system(size: 14, weight: .none))
                .foregroundColor(.black.opacity(0.8))
        }
        .frame(maxWidth: .infinity)
        .padding(.bottom, 14)
        .background(Color.white)
        .cornerRadius(8)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(
                    isSelected ? Color(hex: 0xFFFF_B100) : Color.clear,
                    lineWidth: 2
                )
        )
        .onTapGesture {
            onClick()
        }
    }
}
