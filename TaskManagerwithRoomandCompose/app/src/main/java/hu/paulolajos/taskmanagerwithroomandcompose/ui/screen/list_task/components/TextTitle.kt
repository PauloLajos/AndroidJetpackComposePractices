package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(
    taskTitle: String
) {
    Text(
        text = taskTitle,
        color = Color.DarkGray,
        fontSize = 25.sp
    )
}