package com.nahuelvalencia.marvelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nahuelvalencia.marvelapp.navigation.Navigation
import com.nahuelvalencia.marvelapp.ui.theme.MarvelAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelAppTheme {
                Navigation()
            }
        }
    }
}
