package ly.raqam.t_rex_counter.loginPage.data.repostiry

import ly.raqam.t_rex_counter.loginPage.data.entity.userEntity
import ly.raqam.t_rex_counter.loginPage.resource.resource

interface userRepostiry<M,E> {
    fun login(user : userEntity): resource<E>
    fun signup(user : userEntity)
    fun logout()

}