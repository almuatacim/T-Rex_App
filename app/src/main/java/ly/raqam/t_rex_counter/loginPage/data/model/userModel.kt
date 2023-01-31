package ly.raqam.t_rex_counter.loginPage.data.model

import ly.raqam.t_rex_counter.loginPage.data.entity.userEntity

class userModel(var username : String, var password : String,var token : String, var isAdmin : Boolean = false) {
    fun toEntity(): userEntity{
        return userEntity(username= username, password = password)
    }
}