//
//  CustomWorkoutView.swift
//  iosApp
//
//  Created by Deven on 28/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CustomWorkoutView: View {
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        NavigationView {
            ZStack {
                Color(hex: 0xFFEB_EFF6)
                    .ignoresSafeArea()
                VStack {
                    ScrollView {
                        VStack {
                            HeaderView()
                            
                            TimeSelectorCustomView()
                            
                            PlaceItemView().padding(.horizontal, 16)
                        }
                    }
                    MyButton(name: "Create")
                }
                
            }
        }
        .toolbar {
            ToolbarItem(placement: .navigationBarLeading) {
                Button(action: {
                    presentationMode.wrappedValue.dismiss()
                }) {
                    ZStack {
                        Circle()
                            .fill(Color.white)
                            .frame(width: 22, height: 22)
                        Image(systemName: "chevron.left")
                            .font(.system(size: 10, weight: .bold))
                            .foregroundColor(.black)
                    }
                }
            }
        }
        .navigationBarBackButtonHidden(true)
        .navigationBarTitle("Custom workout", displayMode: .inline)
        .navigationTitle("Custom workout")
        .navigationBarTitleDisplayMode(.inline)
    }
}


#Preview {
    CustomWorkoutView()
}
