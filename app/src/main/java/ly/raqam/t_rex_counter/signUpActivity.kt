package ly.raqam.t_rex_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import ly.raqam.t_rex_counter.loginPage.data.entity.userEntity
import ly.raqam.t_rex_counter.loginPage.data.repostiry.userRepostiryImp
import ly.raqam.t_rex_counter.loginPage.data.viewModel.loginViewModel

class signUpActivity : AppCompatActivity() {

    private lateinit var signupbtn : Button
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var confpassword : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initSignup()
    }
    fun initSignup(){
        val userRepo = userRepostiryImp()
        signupbtn = findViewById(R.id.signupbtn)
        username = findViewById(R.id.signupnametxt)
        password = findViewById(R.id.signuppasstxt)
        confpassword = findViewById(R.id.signupconfpasstxt)

        signupbtn.setOnClickListener(){
            userRepo.signup(userEntity(username = username.text.toString(), password = password.text.toString()))
        }
    }
}