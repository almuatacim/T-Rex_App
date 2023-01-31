package ly.raqam.t_rex_counter.loginPage.data.repostiry

import ly.raqam.t_rex_counter.loginPage.data.entity.userEntity
import ly.raqam.t_rex_counter.loginPage.data.model.userModel
import ly.raqam.t_rex_counter.loginPage.resource.resource

class userRepostiryImp:userRepostiry<userModel,userEntity> {
    var userlist = mutableListOf<userEntity>(userEntity(username = "1", password = "1"))
    override fun login(user: userEntity): resource<userEntity> {
        for (userin in userlist){
            if (userin.username == user.username && userin.password == user.password)
                return resource.successfully<userEntity>(data = user)
        }
        return resource.error<userEntity>()
    }

    override fun signup(user: userEntity){
        userlist.add(user)
        return
    }

    override fun logout() {
    }

}