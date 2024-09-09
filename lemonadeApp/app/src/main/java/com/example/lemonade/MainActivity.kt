package com.example.lemonade

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonPreview()
            }
        }
    }
}

@Preview( showSystemUi = true )
@Composable
fun LemonPreview(){
    var screen by remember { mutableStateOf(1)}
    val description: String
    val painter : Int
    val sentence: String
    var clickCount by remember { mutableStateOf(1)}
    val onClick: () -> Unit
    when(screen){
        1 -> {
            painter = R.drawable.lemon_tree
            description = stringResource(id = R.string.tree)
            sentence= stringResource(id = R.string.tap)
            onClick = {
                screen = 2
                clickCount = (2..4).random()
            }
        }
        2 -> {
            painter = R.drawable.lemon_squeeze
            description = stringResource(id = R.string.lemon)
            sentence = stringResource(id = R.string.keep_going)
            onClick = {
                clickCount--
                if (clickCount == 0) {
                    screen = 3
                }

            }
        }
        3 -> {
            painter = R.drawable.lemon_drink
            description = stringResource(id = R.string.glass)
            sentence = stringResource(id = R.string.drink)
            onClick = {
                screen = 4
            }
        }
        else -> {
            painter = R.drawable.lemon_restart
            description = stringResource(id = R.string.e_glass)
            sentence = stringResource(id = R.string.retap)
            onClick = {
                screen = 1
            }
        }
//        else -> Text(text = "error")
    }
    Screen(
        description = description,
        image = painter,
        sentence = sentence,
        clickImage = onClick
    )
}


@Composable
fun Screen(
    description: String,
    sentence: String,
    image: Int,
    clickImage: () -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(red = 196, green = 182, blue = 61)),
                textAlign = TextAlign.Center

            )
        }
        Spacer(modifier = Modifier.height(200.dp))
        Button(
            onClick = clickImage,
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.LightGray
            ),
            shape = RoundedCornerShape(80.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = description,
                modifier = modifier
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = sentence
        )
    }
}
