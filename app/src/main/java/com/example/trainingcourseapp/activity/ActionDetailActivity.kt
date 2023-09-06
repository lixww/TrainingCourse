package com.example.trainingcourseapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.trainingcourseapp.ui.composepages.ActionInfoCard
import com.example.trainingcourseapp.ui.composepages.OneTitle
import com.example.trainingcourseapp.ui.theme.TrainingCourseAppTheme

class ActionDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingCourseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OneTitle(text = "动作详情")
                        ActionInfoCard("动作名称")
                        ActionInfoCard("动作示意")
                        ActionInfoCard("动作时长")

                    }

                }
            }
        }
    }
}