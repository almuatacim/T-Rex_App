package ly.raqam.t_rex_counter.loginPage.resource

sealed class resource<T>(data : T? = null){
    object loading
    class Init<T>:resource<T>()
    data class successfully<T>(var data: T? = null): resource<T>()
    data class error<T>(var message: T? = null): resource<T>()
}
