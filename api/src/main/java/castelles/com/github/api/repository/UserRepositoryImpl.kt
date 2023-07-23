package castelles.com.github.api.repository

import castelles.com.github.api.datasource.UserDataSource
import castelles.com.github.api.model.UserResponse
import castelles.com.github.api.repository.contract.UserRepository
import castelles.com.github.api.utils.ErrorHandler
import castelles.com.github.api.utils.NetworkFetcher
import castelles.com.github.api.utils.NetworkFetcher.Error
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImpl(
    private val dataSource: UserDataSource
): UserRepository {

    override suspend fun getNotAuthenticatedUser(
        username: String,
        dispatcher: CoroutineDispatcher
    ): Flow<NetworkFetcher<UserResponse>> = flow {
        emit(NetworkFetcher.Loading)
        val result = dataSource.getNotAuthenticatedUser(username)
        emit(result)
    }.flowOn(dispatcher)

}