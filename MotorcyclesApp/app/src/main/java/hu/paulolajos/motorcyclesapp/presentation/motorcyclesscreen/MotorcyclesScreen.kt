package hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.paulolajos.motorcyclesapp.R
import hu.paulolajos.motorcyclesapp.domain.model.Motorcycle
import hu.paulolajos.motorcyclesapp.domain.util.MotorcycleOrder
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.components.Fab
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.components.MotorcycleItem
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.components.OrderSection
import hu.paulolajos.motorcyclesapp.presentation.theme.MotorcyclesAppTheme

@Composable
fun MotorcycleScreen(
    state: MotorcyclesScreenState,
    onItemClick: (id: Int) -> Unit,
    fabOnClick: (id: Int) -> Unit,
    onFilterButtonClick: (motorcyclesOrder: MotorcycleOrder) -> Unit,
    onButtonToggleOrderSelection: () -> Unit,
    onDeleteButtonClick: () -> Unit
) {
    val loadingMotorcyclesDescription = stringResource(id = R.string.loading_motorcycles)
    val emptyListDescription = stringResource(id = R.string.empty_list_description)
    val screenTitle = stringResource(id = R.string.screen_motorcycle_title)
    val filterIconTitle = stringResource(id = R.string.filter_icon_title)
    val buttonDeleteTitle = stringResource(id = R.string.btn_delete)

    Scaffold(
        floatingActionButton = { Fab { fabOnClick(0) } }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = screenTitle,
                    style = MaterialTheme.typography.titleLarge
                )
                IconButton(
                    onClick = onButtonToggleOrderSelection
                ) {
                    Icon(
                        //imageVector = Icons.Default.List, // .FilterList,
                        imageVector = ImageVector.vectorResource(R.drawable.filter_list_24px),
                        contentDescription = filterIconTitle
                    )
                }
                IconButton(
                    onClick = onDeleteButtonClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = buttonDeleteTitle
                    )
                }
            }
            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    motorcycleOrder = state.motorcycleOrder,
                    onOrderChange = {
                        onFilterButtonClick(it)
                    }
                )
            }
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.motorcycles) { motorcycle ->
                        MotorcycleItem(
                            modifier = Modifier.fillMaxWidth(),
                            motorcycle = motorcycle,
                            onCardItemClick = { onItemClick(motorcycle.id) })
                    }
                }
                if (state.isLoading && state.motorcycles.isEmpty()) {
                    CircularProgressIndicator(
                        Modifier
                            .semantics {
                                this.contentDescription = loadingMotorcyclesDescription
                            }
                    )
                }
                if (state.error != null) {
                    Text(
                        text = state.error,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center)
                    )
                }
                if (!state.isLoading && state.motorcycles.isEmpty()) {
                    Text(
                        text = emptyListDescription,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640, apiLevel = 33)
@Composable
private fun DefaultPreview() {
    MotorcyclesAppTheme {
        MotorcycleScreen(
            state = MotorcyclesScreenState(
                listOf(
                    Motorcycle(
                        id = 0,
                        brandName = "Honda",
                        model = "CBR 1000RRR"
                    ),
                    Motorcycle(
                        id = 0,
                        brandName = "Yamaha",
                        model = "YZF-R1M"
                    )
                ),
                true
            ),
            onItemClick = {},
            fabOnClick = {},
            onButtonToggleOrderSelection = {},
            onFilterButtonClick = {},
            onDeleteButtonClick = {}
        )
    }
}