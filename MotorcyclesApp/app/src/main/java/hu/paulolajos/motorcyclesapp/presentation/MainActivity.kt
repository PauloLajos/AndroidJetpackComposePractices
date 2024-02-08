package hu.paulolajos.motorcyclesapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.MotorcyclesScreenViewModel
import hu.paulolajos.motorcyclesapp.presentation.navigation.MotorcyclesNavHost
import hu.paulolajos.motorcyclesapp.presentation.theme.MotorcyclesAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotorcyclesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MotorcyclesApp()
                }
            }
        }
    }
}

@Composable
fun MotorcyclesApp() {
    val navController = rememberNavController()
    val motorcyclesScreenViewModel: MotorcyclesScreenViewModel = hiltViewModel()

    MotorcyclesNavHost(
        motorcyclesScreenViewModel = motorcyclesScreenViewModel,
        navController = navController
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MotorcyclesAppTheme {
        MotorcyclesApp()
    }
}