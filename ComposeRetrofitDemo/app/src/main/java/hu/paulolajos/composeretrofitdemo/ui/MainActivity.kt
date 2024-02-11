package hu.paulolajos.composeretrofitdemo.ui

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
import dagger.hilt.android.AndroidEntryPoint
import hu.paulolajos.composeretrofitdemo.ui.composables.GetData
import hu.paulolajos.composeretrofitdemo.ui.theme.ComposeRetrofitDemoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRetrofitDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val mainViewModel: MainViewModel = hiltViewModel()
    GetData(mainViewModel = mainViewModel)
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    ComposeRetrofitDemoTheme {
        //
    }
}