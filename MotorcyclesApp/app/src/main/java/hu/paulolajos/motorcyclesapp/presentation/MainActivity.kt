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
import androidx.navigation.compose.rememberNavController
import hu.paulolajos.motorcyclesapp.presentation.navigation.MotorcyclesNavHost
import hu.paulolajos.motorcyclesapp.presentation.theme.MotorcyclesAppTheme

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

    MotorcyclesNavHost(
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