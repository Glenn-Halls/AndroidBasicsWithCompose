package com.example.androidbasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasicswithcompose.ui.theme.AndroidBasicsWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticle()
                }
            }
        }
    }
}

@Composable
fun ComposeArticle (modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        HeadingBanner()
        Heading()
        Synopsis()
        Content()
    }
}

@Composable
fun Heading(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.heading),
        fontSize = 24.sp,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun Synopsis(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.synopsis),
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.content),
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun HeadingBanner(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,)
@Composable
fun GreetingPreview() {
    AndroidBasicsWithComposeTheme {
        ComposeArticle()
    }
}