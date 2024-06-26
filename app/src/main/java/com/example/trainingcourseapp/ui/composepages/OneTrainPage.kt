package com.example.trainingcourseapp.ui.composepages

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingcourseapp.R
import com.example.trainingcourseapp.activity.ActionDetailActivity
import com.example.trainingcourseapp.datamodel.OneActionData
import com.example.trainingcourseapp.ui.findActivity
import com.example.trainingcourseapp.ui.fromJson
import com.example.trainingcourseapp.ui.loadJsonStrFromAssets
import com.example.trainingcourseapp.ui.theme.TrainingCourseAppTheme

@Preview(showBackground = true)
@Composable
fun OneTrainPagePreview() {
    TrainingCourseAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OneTitle(text = "单次训练")
                ActionList()

            }

        }
    }
}

@Composable
fun ActionList() {
    val context = LocalContext.current.findActivity()
    val actionsList = context?.loadJsonStrFromAssets("actions.json")?.fromJson<OneActionData>()

    LazyColumn(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // check if actionsList is null or empty
        if (actionsList?.isEmpty() == true) {
            item {
                Text(
                    text = "暂无动作",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        } else {
            items(actionsList ?: emptyList()) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.background),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .background(Color(0xFFFFE082))
                            .clickable {
                                context?.startActivity(
                                    Intent(
                                        context,
                                        ActionDetailActivity::class.java
                                    ).apply {
                                        putExtra("actionData", it)
                                    }
                                )
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_img_placeholder),
                            contentDescription = "动作示意",
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxHeight()
                        )
                        Text(
                            text = it.name,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.secondary
                            ),
                            modifier = Modifier.padding(8.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Color.Transparent)
                        )
                        Text(
                            text = it.timeCost.display,
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.tertiary
                            ),
                            modifier = Modifier
                                .padding(2.dp)

                        )
                        Icon(
                            painter = painterResource(R.drawable.round_chevron_right_24),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.padding(8.dp)
                        )

                    }
                }
            }
        }
    }
}