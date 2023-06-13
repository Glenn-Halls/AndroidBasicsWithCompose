package com.example.androidbasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasicswithcompose.ui.theme.AndroidBasicsWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsWithComposeTheme {
                LemonadeStandApp()
            }
        }
    }
}

@Composable
fun LemonadeStand(
    imageId: Int,
    descriptionId: Int,
    stringId: Int,
    clickAction: () -> Unit,
    modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Button(
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            ),
            shape = RoundedCornerShape(15),
            onClick = clickAction
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = stringResource(id = descriptionId)
            )
        }
        Spacer(modifier = modifier.size(16.dp))
        Text(
            modifier = modifier,
            text = stringResource(id = stringId),
            fontSize = 18.sp
        )
    }
}

@Composable
fun LemonLogic() {

    var currentStage by remember { mutableStateOf(1) }
    var numSqueezes by remember { mutableStateOf(0) }

    when (currentStage) {
        1 -> {
            LemonadeStand(
                imageId = R.drawable.lemon_tree,
                descriptionId = R.string.lemon_tree,
                stringId = R.string.tap_lemon,
                { currentStage++ }
            )
        }
        2 -> {
            LemonadeStand(
                imageId = R.drawable.lemon_squeeze,
                descriptionId = R.string.lemon,
                stringId = R.string.keep_tapping,
                {
                    numSqueezes++
                    val squeezesNeeded = (2..4).random()
                    if (numSqueezes >= squeezesNeeded) {
                        numSqueezes = 0
                        currentStage++
                    }
                }
            )
        }
        3 -> {
            LemonadeStand(
                imageId = R.drawable.lemon_drink,
                descriptionId = R.string.glass_lemonade,
                stringId = R.string.tap_lemonade,
                { currentStage++ }
            )
        }
        4 -> {
            LemonadeStand(
                imageId = R.drawable.lemon_restart,
                descriptionId = R.string.empty_glass,
                stringId = R.string.tap_glass,
                { currentStage = 1}
            )
        }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true
        )
@Composable
fun LemonadeStandApp() {
    LemonLogic()
}
