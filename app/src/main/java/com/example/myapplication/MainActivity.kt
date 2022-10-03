package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
                    modifier = Modifier
                        .fillMaxSize(),
                        //.background(Color.DarkGray),
                    color = Color.DarkGray// MaterialTheme.colors.background


                ) {
                    BusinessCard("Roman Fedoniuk", "Kotlin Developer, C#/.Net, Java")
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

@Composable
fun BusinessCard(name: String, work: String){
    Box(
        contentAlignment = Alignment.Center,
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                tint = colorResource(R.color.green_50),
                painter = painterResource(R.drawable.ic_baseline_face_243),
                contentDescription = "Some Main Logo",
                modifier = Modifier
                    .height(144.dp)
                    .width(144.dp)
            )
            Text(
                text = name,
                fontSize = 32.sp
            )
            Text(
                text = work,
                color = colorResource(R.color.green_50)
            )
        }
    }
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .padding(bottom = 15.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_call_24),
                    contentDescription = "PhoneIcon",
                    modifier = Modifier
                        .weight(0.8f)
                )
                Text(
                    text = "12345678910",
                    color = colorResource(R.color.green_50),
                    modifier = Modifier
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_share_24),
                    contentDescription = "ShareIcon",
                    modifier = Modifier
                        .weight(0.8f)
                )

                Text(
                    text = "@IceKNT",
                    color = colorResource(R.color.green_50),
                    modifier = Modifier
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)

            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_email_24),
                    contentDescription = "ShareIcon",
                    modifier = Modifier
                        .weight(0.8f)
                    )
                Text(
                    text = "@zona0301256",
                    color = colorResource(R.color.green_50),
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        BusinessCard("Roman Fedoniuk", "Kotlin Developer, C#/.Net, Java")
    }
}

