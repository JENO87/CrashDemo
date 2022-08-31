package com.example.crashdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.crashdemo.ui.theme.CrashDemoTheme
import com.google.firebase.crashlytics.FirebaseCrashlytics

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrashDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val nr2 = "Int"

                    Column {

                        Button(onClick = {
                            FirebaseCrashlytics.getInstance().log("MY FIRST CRASH")
                            throw RuntimeException("Test Crash")
                        }) {
                            Text(text = "Test Crash")
                        }

                        Text(text = nr2.toInt().toString())

                    }
                }
            }
        }
    }
}