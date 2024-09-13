package com.example.artspace

import android.graphics.Picture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {

                }
            }
        }
    }

@Composable
fun Picture(
    childName: Int,
//    author: String, do later
    image: Int,
    nextImage: () -> Unit,
    previousImage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
                painter = painterResource(id = image),
                contentDescription = "Children"
            )
        Spacer(modifier = Modifier.height(100.dp))
        Text(
                text = stringResource(id = childName)
            )
        
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Button(onClick = previousImage ) {
                
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = { /*TODO*/ }) {

            }
        }
    }
}

fun changePic