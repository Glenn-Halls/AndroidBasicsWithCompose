package com.example.androidbasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(){
    MiddleInfo(
        image = painterResource(id = R.drawable.aaa),
        nameText = stringResource(R.string.glenn_halls_name),
        titleText = stringResource(R.string.android_developer)
    )

    BottomInfo(
        topIcon = painterResource(id = R.drawable.octicons_mark_github_svg),
        topText = stringResource(R.string.glenn_halls),
        bottomIcon = painterResource(id = R.drawable.reshot_icon_mail_gx3mtbulvf),
        bottomText = stringResource(R.string.ghalls_dev_gmail_com)
    )
}


@Composable
private fun MiddleInfo(
    image: Painter,
    nameText: String,
    titleText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier =  modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                Modifier.fillMaxWidth(0.3f),
                alignment = Alignment.Center
            )
            Text(
                text = nameText,
                modifier = modifier
                    .padding(top = 8.dp, bottom = 4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp

            )
            Text(
                text = titleText,
                modifier = modifier,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
private fun BottomInfo(
    topIcon: Painter,
    topText: String,
    bottomIcon: Painter,
    bottomText: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .height(30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = topIcon,
                contentDescription = null
            )
            Spacer(modifier = modifier.padding(8.dp))
            Text(
                text = topText
            )
        }
        Spacer(modifier = modifier.padding(4.dp))
        Row(
            modifier = modifier
                .height(30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = bottomIcon,
                contentDescription = null
            )
            Spacer(modifier = modifier.padding(8.dp))
            Text(
                text = bottomText
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,)
@Composable
fun GreetingPreview() {
    AndroidBasicsWithComposeTheme {
        BusinessCardApp()
    }
}