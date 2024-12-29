package com.deven.lifestyleapp.android.ui.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.deven.lifestyleapp.android.R
import com.deven.lifestyleapp.android.ui.item.SliderWithTitleAndDescription
import com.deven.lifestyleapp.src.SliderDataLoader

@Composable
fun CustomWorkoutView() {
    val context = LocalContext.current
    Scaffold(
        topBar = { AppBar(title = "Custom workout", true,onBackPressed = { (context as? Activity)?.finish() }) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateTopPadding() - 10.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TimeSelectorCustom()

            }
            MyButton(
                name = "Create", modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.BottomCenter),
                onClick = { }
            )
        }

    }
}

@Composable
fun TimeSelectorCustom() {
    val sliderData = remember { SliderDataLoader().loadSliderData() }
    val sliderValues =
        remember { mutableStateListOf<Float>().apply { repeat(sliderData.size) { add(10f) } } }
    val totalTime = sliderValues.sum()

    LazyColumn {
        item {
            Column(
                Modifier
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(
                            bottomStart = 26.dp,
                            bottomEnd = 26.dp
                        )
                    )
                    .padding(all = 14.dp)
            ) {
                HeadingText("Select workout duration", fontSize = 20)
                Row(
                    Modifier.padding(top = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_girl),
                        contentDescription = null,
                        modifier = Modifier.size(45.dp)
                    )
                    Text(text = "Choose how long you want to exercise each capacity. 2 minutes of warm up and 2 minutes of cool down are automatically added to your workout.")
                }
            }
            LabelText("Select capacity time", paddingStart = 16)
        }
        items(sliderData.size) { index ->
            SliderWithTitleAndDescription(
                image = R.drawable.img_endurance,
                title = sliderData[index].title,
                description = sliderData[index].desc,
                sliderValue = remember { mutableFloatStateOf(sliderValues[index]) }
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HeadingText(label = "Total exercise time:", fontSize = 16)
                HeadingText(label = "${totalTime.toInt()} min", fontSize = 16)
            }
            PlacesItemsView(
                Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
            )
        }
    }
}