package com.example.lemonade

import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
    when(screen){
        1 -> Screen(
            painter = painterResource(id = R.drawable.lemon_tree),
            description = stringResource(id = R.string.tree),
            modifier = Modifier
                .clickable { screen = 2 }
        )
        2 -> Screen(
            painter = painterResource(id = R.drawable.lemon_squeeze),
            description = stringResource(id = R.string.lemon),
            modifier = Modifier
                .clickable { screen = 3 }
        )
        3 -> Screen(
            painter = painterResource(id = R.drawable.lemon_drink),
            description = stringResource(id = R.string.tap),
            modifier = Modifier
                .clickable { screen = 4 }
        )
        4 -> Screen(
            painter = painterResource(id = R.drawable.lemon_restart),
            description = stringResource(id = R.string.retap),
            modifier = Modifier
                .clickable { screen = 1 }
        )
        else -> Text(text = "error")
    }
}


@Composable
fun Screen(
    painter: Painter,
    description: String,
    modifier: Modifier = Modifier
){
    Column {
        Row {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 18.sp,
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column {
            Image(
                painter = painter,
                contentDescription = description,
                modifier = modifier

            )
        }
    }
}
