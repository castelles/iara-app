package castelles.com.github.iaraapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import castelles.com.github.iaraapp.extension.safeEmit
import castelles.com.github.iaraapp.viewmodel.state.State
import castelles.com.github.api.model.UserResponse
import castelles.com.github.api.repository.contract.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): ViewModel() {

    private val _userFetcher = MutableStateFlow<State<UserResponse>?>(null)
    val userFetcher = _userFetcher.asStateFlow()

    fun getUserInformation() {
        /**
         * Here you place your github username
         */
        val username = "castelles"
        viewModelScope.launch {
            repository.getNotAuthenticatedUser(username).collectLatest {
                _userFetcher.safeEmit(State(it))
            }
        }
    }

}