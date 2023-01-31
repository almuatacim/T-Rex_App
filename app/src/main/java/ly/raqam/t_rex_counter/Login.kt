package ly.raqam.t_rex_counter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import cn.pedant.SweetAlert.SweetAlertDialog
import ly.raqam.t_rex_counter.loginPage.data.entity.userEntity
import ly.raqam.t_rex_counter.loginPage.data.viewModel.loginViewModel
import ly.raqam.t_rex_counter.loginPage.resource.resource

class Login : AppCompatActivity() {
    val vmlogin : loginViewModel by viewModels()
    private lateinit var usname : EditText
    private lateinit var pass : EditText
    private lateinit var logtxt : TextView
    private lateinit var logbtn : Button
    private lateinit var signbtn : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initlog()
    }
    fun initlog(){
        logbtn = findViewById(R.id.loginbtn)
        usname = findViewById(R.id.nametxt)
        logtxt = findViewById(R.id.messagetxt)
        pass = findViewById(R.id.passtxt)
        signbtn = findViewById(R.id.signuptxtbtn)
        var observer = Observer<resource<userEntity>>{
            when(it){
                is resource.successfully<userEntity> -> {
                    SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE).setTitleText("T-rex login App").setContentText("you are logging in successfully").show()
                    logtxt.text = "Login succed"
                    val intent = Intent(this,ListViewActivity::class.java)
                    startActivity(intent)
                }
                is resource.error<userEntity> ->{
                    SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE).setTitleText("T-rex login App").setContentText("your logging in was failed").show()
                     logtxt.text = "Login failed"
                }
                else -> {}
            }
        }
        vmlogin.state.observe(this,observer)
        logbtn.setOnClickListener(){
            vmlogin.login(userEntity(username = usname.text.toString(), password = pass.text.toString()))
        }
        signbtn.setOnClickListener(){
            val intent = Intent(this,signUpActivity::class.java)
            startActivity(intent)
        }
    }
}