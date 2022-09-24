package com.example.myappthur


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappthur.ui.theme.MyAppThurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppThurTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContainer()
                }
            }
        }
    }
}

val String.color get() = Alignment.CenterHorizontally


@Composable
fun MainContainer() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Banner()
        Column(
            verticalArrangement = Arrangement.spacedBy(85.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Score()
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(100.dp)
            ) {
                CenterText(word1 = "You Chose", word2 = "Rock")
                CenterText(word1 = "Android Chose", word2 = "Paper")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                ButtonBox(word = "Rock")
                ButtonBox(word = "Paper")
                ButtonBox(word = "Scissor")
            }
        }
        Text("#JetpackCompose",
            fontSize = 20.sp,
            color = Color(0xFF25262D),
            modifier = Modifier.padding(vertical = 10.dp)
        )
        
    }
}

@Composable
fun ButtonBox(word: String) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color(0xFF6305DC)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$word", color = Color.White, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun CenterText(word1: String, word2: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("$word1", fontSize = 16.sp, color = Color(0xFF25262D))
        Text("$word2", fontSize = 32.sp, color = Color(0xFF25262D), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Score() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Text("Score", fontSize = 30.sp, color = Color(0xFF25262D))
        Text("0 / 4", fontSize = 59.sp, color = Color(0xFF25262D), fontWeight = FontWeight.Bold)

    }
}

@Composable
fun Banner() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.r_vs_s),
            contentDescription = "R Vs S",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
    }
}
