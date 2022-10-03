package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun TutorialPageText(title: String, message: String, footer:String) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = footer,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )

}



@Composable
fun JetpackWithImage(title: String,message: String, footer: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth

        )
        TutorialPageText(title,message, footer)
    }
}

@Composable
fun ShowCompleteTaskPage(title: String,message: String) {
    val image = painterResource(R.drawable.ic_task_completed)
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

                ) {
            Image(
                painter = image,
                contentDescription =  null
            )
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = message,
                fontSize = 16.sp,
            )
        }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.QuadrantTitle1),
                description = stringResource(R.string.QuadrantText1),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.QuadrantTitle2),
                description = stringResource(R.string.QuadrantText2),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.QuadrantTitle3),
                description = stringResource(R.string.QuadrantText3),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.QuadrantTitle4),
                description = stringResource(R.string.QuadrantText4),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        ComposeQuadrantApp()
    }
}

