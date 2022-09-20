package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                LemonApp()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonButtonAndImage(modifier: Modifier = Modifier) {

    var currentStep by remember { mutableStateOf(1) }
    val imageResource = when(currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textString = when(currentStep) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon_tap
        3 -> R.string.lemon_drink
        else -> R.string.lemon_restart
    }
    Column(
        modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
    ){
        
        Text(stringResource(textString),
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 18.sp
        )
        Button(onClick = {
            if(currentStep == 2){
                var squeezes = 3
                while(squeezes != 0){
                    squeezes--
                    if(squeezes == 0){
                        currentStep++
                    }
                }



            }
            else if(currentStep == 4){
                currentStep = 1

            }else{
                currentStep++
            }

                         },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)) {
            Image(painterResource(imageResource), stringResource(id = R.string.lemon_tree_desc))
        }

    }
}

@Composable
fun LemonApp() {
    LemonButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}