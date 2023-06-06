package com.example.androidbasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    ComposeQuadrantsApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantsApp() {
    val topLeftTitle = stringResource(R.string.text_composable)
    val topLeftContent = stringResource(R.string.displays_text)
    val topLeftColor = Color(0xFFEADDFF)
    val topRightTitle = stringResource(R.string.image_composable)
    val topRightContent = stringResource(R.string.displays_image)
    val topRightColor = Color(0xFFD0BCFF)
    val bottomLeftTitle = stringResource(R.string.row_composable)
    val bottomLeftContent = stringResource(R.string.displays_row)
    val bottomLeftColor = Color(0xFFB69DF8)
    val bottomRightTitle = stringResource(R.string.column_composable)
    val bottomRightContent = stringResource(R.string.displays_column)
    val bottomRightColor = Color(0xFFF6EDFF)
    ComposeQuadrants(
        topLeftTitle,
        topLeftContent,
        topLeftColor,
        topRightTitle,
        topRightContent,
        topRightColor,
        bottomLeftTitle,
        bottomLeftContent,
        bottomLeftColor,
        bottomRightTitle,
        bottomRightContent,
        bottomRightColor
    )
}

@Composable
private fun ComposeQuadrants(
    topLeftTitle: String,
    topLeftContent: String,
    topLeftColor: Color,
    topRightTitle: String,
    topRightContent: String,
    topRightColor: Color,
    bottomLeftTitle: String,
    bottomLeftContent: String,
    bottomLeftColor: Color,
    bottomRightTitle: String,
    bottomRightContent: String,
    bottomRightColor: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()
    ) {
        Row(modifier = modifier.weight(1f)) {
            Quadrant(
                title = topLeftTitle,
                content = topLeftContent,
                color = topLeftColor,
                modifier = modifier.weight(1f)
            )
            Quadrant(
                title = topRightTitle,
                content = topRightContent,
                color = topRightColor,
                modifier = modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = bottomLeftTitle,
                content = bottomLeftContent,
                color = bottomLeftColor,
                modifier = modifier.weight(1f)
            )
            Quadrant(
                title = bottomRightTitle,
                content = bottomRightContent,
                color = bottomRightColor,
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun Quadrant(
    title: String,
    content: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,)
@Composable
fun GreetingPreview() {
    AndroidBasicsWithComposeTheme {
        ComposeQuadrantsApp()
    }
}