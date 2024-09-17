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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                    Display()
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
    val context = LocalContext.current
    val nameArray = context.resources.getStringArray(R.array.children_names)
    val ageArray = context.resources.getStringArray(R.array.age)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(
                painter = painterResource(id = images[currentImageIndex]),
                contentDescription = "Children",
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
            )
        Spacer(modifier = Modifier.height(100.dp))
        Text(
                text = nameArray[currentImageIndex],
                fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = nameArray[currentImageIndex] + " is " + ageArray[currentImageIndex] + " years old in this picture!",
            fontSize = 20.sp
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
        Button(
            onClick = previousImage,
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 6.dp
            )
        ) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null )
        }
        Spacer(modifier = Modifier.width(40.dp))
        Button(
            onClick = nextImage,
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 6.dp
            )
        ) {
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null )
        }
    }
}