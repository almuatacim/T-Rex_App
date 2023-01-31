package ly.raqam.t_rex_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    private lateinit var rvBrand : RecyclerView
    private lateinit var adapterBrand : BrandAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContentView(R.layout.activity_recycler)
        var brandList =  arrayListOf<Brand>(Brand("Libya", "hhhhhhhh"),Brand("misurat", "mmmmmm"),Brand("sfvbvbfvb", "aaaaaa"),Brand("Libya", "hhhhhhhh"),Brand("Libya", "hhhhhhhh"))
        adapterBrand = BrandAdapter(brandList)
        rvBrand = findViewById(R.id.recyclerView)
        rvBrand.adapter = adapterBrand
        rvBrand.hasFixedSize()
        rvBrand.layoutManager = LinearLayoutManager(this)

    }
}