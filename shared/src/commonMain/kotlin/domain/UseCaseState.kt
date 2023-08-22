package domain

sealed class UseCaseState<RESULT> {
    data class Success<RESULT>(val result: RESULT) : UseCaseState<RESULT>()
    data class Error<T>(val message: String) : UseCaseState<T>()
}