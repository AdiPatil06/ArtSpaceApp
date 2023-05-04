package com.example.artspaceapp

import android.graphics.Paint.Align
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import org.w3c.dom.Text


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp( ){
    var step by remember { mutableStateOf(1)}
    when(step){
        1 -> ArtSpaceLayout(
            image = R.drawable.lemon_drink,
            ArtTitle = "Boss",
            ArtArtist = "Adi",
            Click = step,
            onClick =  {
                step = it
            }
        )
        2 -> ArtSpaceLayout(
            image = R.drawable.lemon_tree,
            ArtTitle = "dsfhu",
            ArtArtist = "Kiran",
            Click = step,
            onClick =  {
                step = it
            }
        )
        3 -> ArtSpaceLayout(
            image = R.drawable.lemon_squeeze,
            ArtTitle = "aaaa",
            ArtArtist = "ssss",
            Click = step,
            onClick =  {
                step = it
            }
        )
        else -> {
            if(step<=0)
                step = 3
            else
                step = 1
        }
    }
}


@Composable
fun ArtSpaceLayout(
    image: Int,
    ArtTitle: String,
    ArtArtist: String,
    Click: Int,
    onClick :(step :Int) -> Unit
){
    var click = Click
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .weight(5F)
                .border(width = 10.dp, color = Color.Black, shape = RectangleShape)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = ArtTitle, modifier = Modifier.weight(1F))
            Text(text = ArtArtist, modifier = Modifier.weight(1F))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        ) {
            Button(
                onClick = {
                    click -= 1
                    onClick(click)
                          },
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 10.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    click += 1
                    onClick(click)
                },
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 10.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}