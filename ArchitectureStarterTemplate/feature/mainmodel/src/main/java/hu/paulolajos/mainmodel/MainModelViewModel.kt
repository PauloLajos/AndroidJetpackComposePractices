package hu.paulolajos.mainmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainModelViewModel @Inject constructor(
    private val mainModelRepository: MainModelRepository
) : ViewModel() {

    val uiState: StateFlow<MainModelUiState> = mainModelRepository
        .mainModels.map<List<String>, MainModelUiState> { Success(data = it) }
        .catch { emit(Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun addMainModel(name: String) {
        viewModelScope.launch {
            mainModelRepository.add(name)
        }
    }
}

sealed interface MainModelUiState {
    object Loading : MainModelUiState
    data class Error(val throwable: Throwable) : MainModelUiState
    data class Success(val data: List<String>) : MainModelUiState
}