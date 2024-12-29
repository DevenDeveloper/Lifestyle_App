package com.deven.lifestyleapp.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.deven.lifestyleapp.android.R
import com.deven.lifestyleapp.android.ui.components.AppBar
import com.deven.lifestyleapp.android.ui.components.MyButton
import com.deven.lifestyleapp.android.ui.components.PlacesItemsView
import com.deven.lifestyleapp.android.ui.components.TimeSelectorView

@Composable
fun MyWorkoutView(onClick: () -> Unit) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { AppBar(title = "My Workout") }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .padding(top = paddingValues.calculateTopPadding())
                .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_workout),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .aspectRatio(1f)
                        .align(Alignment.CenterHorizontally)
                )
                PlacesItemsView(Modifier.fillMaxWidth())
                TimeSelectorView(onClick = onClick)
            }
            MyButton(
                name = "Create", modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.BottomCenter),
                onClick = onClick
            )
        }
    }
}


