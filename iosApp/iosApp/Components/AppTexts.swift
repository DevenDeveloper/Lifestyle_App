//
//  AppTexts.swift
//  iosApp
//
//  Created by Deven on 28/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI


func Label(name: String) -> some View {
    return Text(name)
        .padding(.top, 16)
        .font(.system(size: 16, weight: .semibold))
        .frame(maxWidth: .infinity, alignment: .leading)
}

func UnderlineText(text: String) -> some View {
    return Text(text)
        .font(.system(size: 16, weight: .medium))
        .padding(.top, 16)
        .underline()
        .foregroundColor(.black)
        .frame(maxWidth: .infinity, alignment: .trailing)
}
