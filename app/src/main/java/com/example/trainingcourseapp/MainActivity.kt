package com.example.trainingcourseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingcourseapp.ui.theme.TrainingCourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingCourseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OneTitle(text = "动作集")
                        Greeting("Android")
                        ActionList()

                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    TrainingCourseAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OneTitle(text = "动作集")
                Greeting("Android")
                ActionList()
            }

        }
    }
}

@Composable
fun ActionList() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        items(14) {
            Card(shape = RoundedCornerShape(12.dp)) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Box(
                        modifier = Modifier
                            .fadingEdge(bottomFadingEdge())
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(Color(0xff93C583))

                    )

                    Text(
                        text = "Item $it",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp)
                    )

                    Text(
                        text = "This is item $it",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.background,
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(
                            bottom = 8.dp,
                            start = 4.dp,
                            end = 4.dp
                        )
                    )


                }
            }


        }
    }
}

@Composable
fun bottomFadingEdge(fColor: Color = Color(0xff93C583)): Brush {
    return Brush.verticalGradient(
        0f to fColor,
        0.3f to fColor,
        0.7f to fColor,
        1f to Color.Transparent
    )

}

@Composable
fun topFadingEdge(fColor: Color = Color.Blue): Brush {
    return Brush.verticalGradient(
        0f to Color.Transparent,
        0.3f to fColor,
        0.7f to fColor,
        1f to fColor
    )

}

fun Modifier.fadingEdge(brush: Brush): Modifier = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(brush = brush, blendMode = BlendMode.DstIn)
    }


@Composable
fun Greeting(name: String) {
    Text(
        text = "创建一个吧 $name!",
        modifier = Modifier.padding(20.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrainingCourseAppTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneTitle(text: String) {
    TopAppBar(
        title = {
            Text(text = text, modifier = Modifier.padding(10.dp))
        },
        modifier = Modifier.wrapContentSize(align = Alignment.Center)
    )

}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    TrainingCourseAppTheme {
        OneTitle(text = "动作集")
    }
}