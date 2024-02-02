package hu.paulolajos.taskmanagerwithroom.ui.taskitem

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.paulolajos.taskmanagerwithroom.R
import hu.paulolajos.taskmanagerwithroom.ui.navigation.NavigationDestination

object TaskItemDetailsDestination : NavigationDestination {
    override val route = "item_details"
    override val titleRes = R.string.task_detail_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItemDetailsScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    //viewModel: ItemDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Text(text = "Detail task screen")
}