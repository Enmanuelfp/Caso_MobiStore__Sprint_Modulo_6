package com.bootcamp.caso_mobistore__sprint_modulo_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bootcamp.caso_mobistore__sprint_modulo_6.navigation.NavManager
import com.bootcamp.caso_mobistore__sprint_modulo_6.ui.theme.Caso_MobiStore__Sprint_Modulo_6Theme
import com.bootcamp.caso_mobistore__sprint_modulo_6.viewModel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val viewModel:ProductViewModel by viewModels()
        setContent {
            Caso_MobiStore__Sprint_Modulo_6Theme {
               NavManager(viewModel)
            }
        }
    }
}

