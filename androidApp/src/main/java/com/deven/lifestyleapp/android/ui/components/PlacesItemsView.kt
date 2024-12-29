package com.deven.lifestyleapp.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.deven.lifestyleapp.android.R

@Composable
fun PlacesItemsView(modifier: Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    LabelText("Place", paddingStart = 16)
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        SelectionColumn(
            modifier = Modifier
                .weight(1f),
            imageRes = R.drawable.icon_gym,
            label = "Gym",
            isSelected = selectedIndex == 0,
            onClick = { selectedIndex = 0 }
        )

        SelectionColumn(
            modifier = Modifier
                .weight(1f),
            imageRes = R.drawable.icon_other,
            label = "Other",
            isSelected = selectedIndex == 1,
            onClick = { selectedIndex = 1 }
        )
    }
}

@Composable
fun SelectionColumn(
    modifier: Modifier,
    imageRes: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor =
        if (isSelected) MaterialTheme.colorScheme.tertiary else Color.Transparent

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(11))
            .clickable { onClick() }
            .border(2.dp, borderColor, RoundedCornerShape(12.dp))
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(2.dp, borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier.size(45.dp)
        )
        Text(text = label)
    }
}


