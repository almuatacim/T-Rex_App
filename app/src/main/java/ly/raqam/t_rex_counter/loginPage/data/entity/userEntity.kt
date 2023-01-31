package ly.raqam.t_rex_counter.loginPage.data.entity

import ly.raqam.t_rex_counter.loginPage.data.model.userModel

class userEntity(var username: String, var password: String) {
    fun tomModel():userModel{
        return userModel(username = username,password = password, token = "", isAdmin = false)
    }
}