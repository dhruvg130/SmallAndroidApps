package com.example.lemonade

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

            }
        }
    }
}

@Preview( showBackground = true )
@Composable
fun LemonPreview(){
    var screen by remember { mutableStateOf(1)}
    var painter : Int
    var sentence: String
    var clickCount by remember { mutableStateOf(1)}
    var onClick: () -> Unit
    when(screen){
        1 -> {
            painter = R.drawable.lemon_tree
            sentence= stringResource(id = R.string.tap)
            onClick = {
                screen = 2
                clickCount = (2..4).random()
            }
        }
        2 -> {
            painter = R.drawable.lemon_squeeze
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
            sentence = stringResource(id = R.string.drink)
            onClick = {
                screen = 4
            }
        }
        else -> {
            painter = R.drawable.lemon_restart
            sentence = stringResource(id = R.string.retap)
            onClick = {
                screen = 1
            }
        }
//        else -> Text(text = "error")
    }
    Screen(
        description = sentence,
        image = painter,
        clickImage = onClick
    )
}


@Composable
fun Screen(
    description: String,
    image: Int,
    clickImage: () -> Unit,
    modifier: Modifier = Modifier,
){
    Column {
        Row {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 18.sp,
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = clickImage,
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.LightGray
            ),
            shape = RoundedCornerShape(100.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = description,
                modifier = modifier
            )
        }
        Text(text = description)
    }
}
