package hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hu.paulolajos.motorcyclesapp.presentation.theme.MotorcyclesAppTheme

@Composable
fun Fab(
    fabOnClick: (id: Int) -> Unit
) {
    FloatingActionButton(onClick = { fabOnClick(0) }) {
        Icon(
            Icons.Filled.Add,
            "Add new motorcycle"
        )
    }
}

@Preview
@Composable
fun FabPreview() {
    MotorcyclesAppTheme {
        Fab(fabOnClick = {})
    }
}