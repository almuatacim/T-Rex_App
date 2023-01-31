package ly.raqam.t_rex_counter.loginPage.data.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ly.raqam.t_rex_counter.loginPage.data.entity.userEntity
import ly.raqam.t_rex_counter.loginPage.data.repostiry.userRepostiryImp
import ly.raqam.t_rex_counter.loginPage.resource.resource

class loginViewModel: ViewModel() {
    var resourc  =resource.Init<userEntity>()
    var state = MutableLiveData<resource<userEntity>>(resourc)
    val loginrepostry = userRepostiryImp()
    fun login(user : userEntity){
        val rer = loginrepostry.login(user)
        state.value = rer
    }
}