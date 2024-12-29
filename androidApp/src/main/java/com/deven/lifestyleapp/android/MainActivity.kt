package com.deven.lifestyleapp.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deven.lifestyleapp.android.ui.screens.CustomWorkoutActivity
import com.deven.lifestyleapp.android.ui.screens.MyWorkoutView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyWorkoutView(onClick = {
                        navigateToCustomWorkoutActivity()
                    })
                }
            }
        }
    }

    private fun navigateToCustomWorkoutActivity() {
        val intent = Intent(this, CustomWorkoutActivity::class.java)
        startActivity(intent)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyWorkoutView(onClick = {})
    }
}
