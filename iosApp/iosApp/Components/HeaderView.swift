//
//  HeaderView.swift
//  iosApp
//
//  Created by Deven on 28/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//


import SwiftUI

struct HeaderView: View {
    var body: some View {
        VStack(alignment: .leading, spacing: 14) {
            Text("Select workout duration")
                .font(.system(size: 20, weight: .bold))
                .foregroundColor(.black)
            
            HStack(alignment: .top, spacing: 12) {
                Image("img_girl")
                    .resizable()
                    .frame(width: 45, height: 45)
                
                Text("Choose how long you want to exercise each capacity. 2 minutes of warm up and 2 minutes of cool down are automatically added to your workout.")
                    .font(.system(size: 16))
                    .foregroundColor(.black)
                    .lineSpacing(6)
            }
            .padding(.top, 14)
        }
        .padding(14)
        .background(
            Color.white
                .clipShape(CustomCorners(radius: 20, corners: [.bottomLeft, .bottomRight]))
        )
        .padding(.bottom, 16)
    }
}

struct HeaderView_Previews: PreviewProvider {
    static var previews: some View {
        HeaderView()
            .previewLayout(.sizeThatFits)
            .padding()
    }
}
