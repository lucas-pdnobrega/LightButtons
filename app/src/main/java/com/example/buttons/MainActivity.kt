package com.example.buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.buttons.ui.theme.ButtonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppScaffold()
        }
    }
}

@Composable
fun AppScaffold() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Buttons()
    }
}

@Composable
fun Buttons(modifier: Modifier = Modifier) {
    var onandoff by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (onandoff) Color.White else Color.Black)
            .padding(30.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)) {
            if (onandoff) {
                Button(
                    onClick = {
                        onandoff = !onandoff
                    }
                ) {
                    Text("Turn off the lights!")
                }
            } else {
                FilledTonalButton(
                    onClick = {
                        onandoff = !onandoff
                    }
                ) {
                    Text("Turn on the lights!")
                }
            }
        }
    }
}