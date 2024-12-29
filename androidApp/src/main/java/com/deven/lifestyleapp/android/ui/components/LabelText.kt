package com.deven.lifestyleapp.android.ui.components

import androidx.annotation.Size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabelText(label: String, paddingStart:Int = 0) {
    Text(
        modifier = Modifier.padding(top = 16.dp, start = paddingStart.dp),
        text = label,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.SemiBold
        ),
    )
}

@Composable
fun HeadingText(label: String, fontSize: Int = 22, color: Color = Color(0xFF313F59)) {
    Text(
        text = label,
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.SemiBold,
            color = color,
            fontSize = fontSize.sp
        ),
    )
}