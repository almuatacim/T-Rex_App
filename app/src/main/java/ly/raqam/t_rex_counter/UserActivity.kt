package ly.raqam.t_rex_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ly.raqam.t_rex_counter.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val country = intent.getStringExtra("country")
        val imageId = intent.getIntExtra("imageId",R.drawable.a)


        binding.Nametxt.text = name
        binding.Phonetxt.text = phone
        binding.Countrytxt.text = country
        binding.profileImage.setImageResource(imageId)
    }
}