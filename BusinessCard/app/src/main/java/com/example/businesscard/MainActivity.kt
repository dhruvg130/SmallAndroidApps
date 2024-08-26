package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){

                }
            }
        }
    }
}
@Composable
fun BusinessCard(text1: String, text2: String, text3: String, text4: String, text5: String, modifier: Modifier = Modifier ) {
    val image = painterResource(R.drawable.img_3439)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(350.dp)
                .offset(y = 80.dp)
            //ChatGpt link which was used to help format image
            // https://chatgpt.com/share/c0d85a34-07f0-4797-a11b-749f86cf2964
        )
    }
    LowerPart(
        icon = ImageVector,
        number = text3,
        socialMedia = text4,
        email = text5
    )
    UpperPart(
        name = text1,
        title = text2
    )
}

@Composable
fun LowerPart(
    number: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier,
    icon: Any
){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .offset(y = -50.dp)
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Phone",
                tint = Color(red = 85, green = 3, blue = 3)

            )
            Text(
                text = number,
                fontSize = 22.sp,
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.instagram),
                contentDescription = null,
                modifier = Modifier.size(35.dp),
                colorFilter = ColorFilter.tint(Color(red = 85, green = 3, blue = 3))
            )
            Text(
                text = socialMedia,
                fontSize = 22.sp
            )
        }
        Row {
            Icon(
                imageVector = Icons.Filled.MailOutline,
                contentDescription = "Phone",
                modifier = Modifier
                    .size(30.dp),
                tint = Color(red = 85, green = 3, blue = 3)

            )
            Text(
                text = email,
                fontSize = 22.sp
            )

        }
    }
}

@Composable
fun UpperPart(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize ()
            .offset(y = 75.dp)
    ) {
        Text(
            text = name,
            fontSize = 60.sp,
        )
        Text(
            text = title,
            fontSize = 35.sp

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(
            text1 = stringResource(R.string.name) ,
            text2 = stringResource(R.string.position),
            text3 = stringResource(R.string.phone_number) ,
            text4 = stringResource(R.string.instagram),
            text5 = stringResource(R.string.email)
        )
    }
}