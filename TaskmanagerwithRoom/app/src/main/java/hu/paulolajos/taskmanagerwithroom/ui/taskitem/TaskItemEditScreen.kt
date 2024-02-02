package hu.paulolajos.taskmanagerwithroom.ui.taskitem

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.paulolajos.taskmanagerwithroom.R
import hu.paulolajos.taskmanagerwithroom.ui.navigation.NavigationDestination

object TaskItemEditDestination : NavigationDestination {
    override val route = "item_edit"
    override val titleRes = R.string.edit_task_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    //viewModel: ItemEditViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Text(text = "Edit task screen")
}