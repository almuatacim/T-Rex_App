package ly.raqam.t_rex_counter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ly.raqam.t_rex_counter.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListViewBinding
    private lateinit var    userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageId = intArrayOf(
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.t_rex_app,
            R.drawable.ic_launcher_foreground
        )
        val name = arrayOf(
            "mohammed Alahwal", "almahdi alza3louk", "emhemmed algzery", "T-Rex App", "Test"
        )
        val lastmessage = arrayOf(
            "hey whats up", "fake wahmy", "trojans fake team", "It's T-Rex Hi", "Just for Test"
        )
        val lastMsgtime = arrayOf(
            "8:00 am", "10:20 am", "2:45 pm", "6:32 pm", "5:50 am"
        )
        val phoneNo = arrayOf(
            "091847765", "0923468473", "754777568", "0922283847", "0000000000"
        )
        val country = arrayOf(
            "Libya", "Libya", "Libya", "Tripoli", "Benghazi"
        )
        userArrayList = ArrayList()
        for (i in name.indices){
            val user = User(name[i],lastmessage[i],lastMsgtime[i],phoneNo[i],country[i],imageId[i])
            userArrayList.add(user)
        }
        binding.listview.isClickable = true
        binding.listview.adapter = myAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            val name = name[position]
            val phone = phoneNo[position]
            val country = country[position]
            val imageId = imageId[position]

            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("country",country)
            i.putExtra("imageId",imageId)
            startActivity(i)

        }

    }
}