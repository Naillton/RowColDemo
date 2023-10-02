package com.example.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rowcoldemo.ui.theme.RowColDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowColDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
private fun MainScreen() {
    /* Definindo que teremos um layout em linha, posicionando elementos um ao lado do outro
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        TextCell(text = "1")
        TextCell(text = "2")
        TextCell(text = "3")
    }
    definindo layout como coluna posicianando elemento um abaixo do outro
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextCell(text = "1")
        TextCell(text = "2")
        TextCell(text = "3")
    }*/
    // combinando Column e Row para criar layout personalizado
    /**
     * os valores passados como parametros dos layouts sao referentes as suas propriedades de alinhamento
     * note que os alinhamentos diferem de arrangment para aligment dependendo do layout
     */
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.background(Color.Blue).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )  {
            Column{
                TextCell(text = "1")
                TextCell(text = "2")
                TextCell(text = "3")
            }

            Column {
                TextCell(text = "4")
                TextCell(text = "5")
                TextCell(text = "6")
            }

            Column {
                TextCell(text = "7")
                TextCell(text = "8")
            }
        }
        Row(
            modifier = Modifier.background(Color.Yellow)
        ) {
            TextCell(text = "9")
            TextCell(text = "10")
            TextCell(text = "11")
        }
    }
}

@Composable
private fun TextCell(text: String) {
   Text(
       text = text,
       fontSize = 70.sp,
       fontWeight = FontWeight.Bold,
       textAlign = TextAlign.Center,
       modifier = Modifier
           .padding(4.dp)
           .size(100.dp, 100.dp)
           .border(4.dp, Color.Black)
   )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RowColDemoTheme {
        MainScreen()
    }
}