package ly.raqam.t_rex_counter

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import ly.raqam.t_rex_counter.counter_Page.CounterViewModel
import ly.raqam.t_rex_counter.counter_Page.counterState.CounterState

class MainActivity : AppCompatActivity() {
    private val vmcoun : CounterViewModel by viewModels()
    private lateinit var decrement: Button
    private lateinit var increment: Button
    private lateinit var contertxt: TextView
    private lateinit var txt: TextView
    private lateinit var progBar : ProgressBar
    private lateinit var txtevenodd : TextView
    private lateinit var switchBtn : Switch
    private lateinit var toggleButton: ToggleButton
//    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()

    }
    @SuppressLint("SuspiciousIndentation")
    fun initUi(){
        switchBtn = findViewById(R.id.switchbtn)
        progBar = findViewById(R.id.progBar)
        increment = findViewById(R.id.PlusBtn)
        decrement = findViewById(R.id.minesBtn)
        contertxt = findViewById(R.id.textView2)
        txt = findViewById(R.id.textView)
        txtevenodd = findViewById(R.id.evenoddtxt)
        toggleButton = findViewById(R.id.toggleButton)

        switchBtn.setText("turn on progressBar")
        switchBtn.setOnClickListener(){
            if(!switchBtn.isChecked)
            {switchBtn.setText("turn on progressBar")
                progBar.visibility =View.INVISIBLE

            }else {
                progBar.visibility = View.VISIBLE
                switchBtn.setText("turn on progressBar")
                val intent = Intent(this,RecyclerActivity::class.java)
                startActivity(intent)
            }
        }
        toggleButton.setOnClickListener(){
            if (!toggleButton.isChecked){
                progBar.visibility =View.INVISIBLE
            }else{
                progBar.visibility = View.VISIBLE
            val intent = Intent(this,Login::class.java)
                startActivity(intent)
            }
        }

        var counterOb = Observer<CounterState>{
             contertxt.text = it.count.toString()
            if(it.isLoading){
                progBar.visibility =View.VISIBLE
            }else{
                progBar.visibility =View.INVISIBLE
            }
            txtevenodd.text = it.evenodd
        }
        vmcoun.counterstate.observe(this,counterOb)
        increment.setOnClickListener(){
            vmcoun.icrement()
//            counter++
//            GlobalScope.launch {
//            for(i in 1 .. 100) {
//            }
//            }
//            contertxt.text = counter.toString()

        }

        decrement.setOnClickListener(){
            vmcoun.decrement()
//            counter--
//            contertxt.text = counter.toString()

        }
    }
}