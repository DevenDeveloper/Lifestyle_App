//
//  PlacePicker.swift
//  iosApp
//
//  Created by Deven on 28/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct PlaceItemView: View {
    @State private var selectedIndex: Int = 0
    
    var body: some View {
        VStack {
            Label(name: "Place")
            
            HStack(spacing: 10) {
                SelectionItem(
                    imageName: "icon_gym",
                    label: "Gym",
                    isSelected: selectedIndex == 0,
                    onClick: { selectedIndex = 0 }
                )
                .frame(maxWidth: .infinity)

                SelectionItem(
                    imageName: "icon_other",
                    label: "Other",
                    isSelected: selectedIndex == 1,
                    onClick: { selectedIndex = 1 }
                )
                .frame(maxWidth: .infinity)
            }
            .padding(.horizontal, 6)
        }
    }
}
