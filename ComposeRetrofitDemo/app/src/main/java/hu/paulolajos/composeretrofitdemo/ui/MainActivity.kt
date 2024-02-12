package hu.paulolajos.composeretrofitdemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    GetData()
                }
            }
        }
    }
}

val LocalGetDataPreviewMode: ProvidableCompositionLocal<Boolean> = compositionLocalOf { false }

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun GetDataPreview() {
    ComposeRetrofitDemoTheme {
        CompositionLocalProvider(LocalGetDataPreviewMode provides true) {
            GetData()
        }
    }
}