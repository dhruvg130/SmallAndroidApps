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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
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
@Preview(showSystemUi = true)
fun Display(
) {

    val images = listOf(
        R.drawable.kabir,
        R.drawable.khushi,
        R.drawable.me,
        R.drawable.paramatel,
        R.drawable.stanley,
        R.drawable.tyler,
        )

    var currentImageIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
                painter = painterResource(id = images[currentImageIndex]),
                contentDescription = "Children"
            )
        Spacer(modifier = Modifier.height(100.dp))
        Text(
                text = stringArrayResource(id = children_names[currentImageIndex])
            )
        Spacer(modifier = Modifier.height(50.dp))
        ChangePic(
            previousImage = {
                currentImageIndex = if (currentImageIndex > 0) {
                    currentImageIndex - 1
                } else {
                    images.size - 1
                }
            },
            nextImage = {
                currentImageIndex = if (currentImageIndex < images.size - 1) {
                    currentImageIndex + 1
                } else {
                    0
                }
            }
        )
    }
}
@Composable
fun ChangePic(
    previousImage: () -> Unit,
    nextImage: () -> Unit,
    modifier: Modifier = Modifier
){
    var screenNumber by remember { mutableStateOf(1) }
    Row {
        Button(onClick = previousImage ) {
            Text("Previous")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = nextImage ) {
            Text("Next")
        }
    }
}