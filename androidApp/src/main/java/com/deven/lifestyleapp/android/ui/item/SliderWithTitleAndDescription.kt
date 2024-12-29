package com.deven.lifestyleapp.android.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deven.lifestyleapp.android.ui.components.HeadingText

@Composable
fun SliderWithTitleAndDescription(
    image: Int,
    title: String,
    description: String,
    sliderValue: MutableState<Float>
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProgressSliderWithMinutes(
            image = image,
            title = title,
            description = description,
            sliderValue = sliderValue
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressSliderWithMinutes(
    image: Int,
    title: String,
    description: String,
    sliderValue: MutableState<Float>
) {
    val maxMinutes = 60
    val steps = maxMinutes - 1

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            HeadingText(label = title, fontSize = 18)
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 15.sp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = sliderValue.value,
                onValueChange = { value ->
                    sliderValue.value = value
                },
                valueRange = 0f..maxMinutes.toFloat(),
                steps = steps - 1,
                track = { _ ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(11.dp)
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(11.dp)
                                .background(MaterialTheme.colorScheme.background)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(sliderValue.value / maxMinutes)
                                .height(11.dp)
                                .background(MaterialTheme.colorScheme.secondary)
                        )
                    }
                },
                modifier = Modifier
                    .weight(0.9f)
                    .height(30.dp),
                colors = SliderDefaults.colors(
                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                    inactiveTrackColor = MaterialTheme.colorScheme.background,
                    thumbColor = MaterialTheme.colorScheme.primary,
                    activeTickColor = MaterialTheme.colorScheme.secondary,
                    inactiveTickColor = MaterialTheme.colorScheme.background
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "${sliderValue.value.toInt()} min",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .weight(0.2f)
                    .wrapContentWidth(Alignment.Start)
            )
        }
    }
}