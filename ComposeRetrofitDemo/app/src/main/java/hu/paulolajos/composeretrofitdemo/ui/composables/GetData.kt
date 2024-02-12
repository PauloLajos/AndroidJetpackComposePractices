package hu.paulolajos.composeretrofitdemo.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import hu.paulolajos.composeretrofitdemo.retrofit.Post
import hu.paulolajos.composeretrofitdemo.ui.LocalGetDataPreviewMode
import hu.paulolajos.composeretrofitdemo.ui.MainViewModel
import hu.paulolajos.composeretrofitdemo.util.ApiState

@Composable
fun GetData() {
    if (LocalGetDataPreviewMode.current) {
        LazyColumn {
            val data = listOf<Post>(
                Post(0,"Post1"),
                Post(1,"Post2"),
                Post(2,"Post3"),
                Post(3,"Post4"),
            )
            items(data) { response ->
                EachRow(post = response)
            }
        }
    } else {
        val mainViewModel: MainViewModel = hiltViewModel()

        when (val result = mainViewModel.response.value) {
            is ApiState.Success -> {
                LazyColumn {
                    items(result.data) { response ->
                        EachRow(post = response)
                    }
                }
            }

            is ApiState.Failure -> {
                Text(text = "${result.msg}")
            }

            ApiState.Loading -> {
                CircularProgressIndicator()
            }

            ApiState.Empty -> {

            }
        }
    }
}

@Composable fun EachRow(post: Post) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = post.body,
            modifier = Modifier.padding(10.dp)
        )
    }
}