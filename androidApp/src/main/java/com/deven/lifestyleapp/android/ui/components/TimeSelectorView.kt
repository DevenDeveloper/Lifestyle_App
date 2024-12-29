package com.deven.lifestyleapp.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun TimeSelectorView(onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LabelText("Time")

        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { onClick() },
            text = "Customize",
            style = MaterialTheme.typography.bodyMedium.copy(
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.W500
            )
        )
    }

    Column(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProgressSliderWithMinutes()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressSliderWithMinutes() {
    var sliderValue by remember { mutableFloatStateOf(10f) }

    val maxMinutes = 60
    val steps = maxMinutes - 1

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "How much time do you want to use?",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = sliderValue,
                onValueChange = { value ->
                    sliderValue = value
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
                                .fillMaxWidth(sliderValue / maxMinutes)
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
                text = "${sliderValue.toInt()} min",
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
