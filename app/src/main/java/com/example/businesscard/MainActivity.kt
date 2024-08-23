package com.example.businesscard

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
    val image = painterResource()
}

@Composable
fun LowerPart(number: String, socialMedia: String, email: String, modifier: Modifier = Modifier ){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize ()
    ) {
        Text(
            text = number,
            fontSize = 30.sp,
        )
        Text(
            text = socialMedia,
            fontSize = 30.sp
        )
        Text(
            text = email,
            fontSize = 30.sp
        )
    }
}

@Composable
fun UpperPart(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize ()
    ) {
        Text(
            text = name,
            fontSize = 55.sp,
        )
        Text(
            text = title,
            fontSize = 30.sp

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        UpperPart(
            name = "Dhruv",
            title = "Student"
        )
        LowerPart(
            number = "11111",
            socialMedia = "hihh" ,
            email = "hhh")
    }
}