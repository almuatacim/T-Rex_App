package ly.raqam.t_rex_counter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BrandAdapter(var brandList : ArrayList<Brand>) : RecyclerView.Adapter<BrandAdapter.ItemHolder>() {

    class ItemHolder(item : View): RecyclerView.ViewHolder(item){
        var txtTile : TextView = item.findViewById(R.id.titletxt)
        var txtsubTile : TextView = item.findViewById(R.id.subtitletxt)
        var image : ImageView = item.findViewById(R.id.logo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var currentItem = LayoutInflater.from(parent.context).inflate(R.layout.branditem,parent,false)
        return ItemHolder(currentItem)
    }

    override fun getItemCount(): Int {
        return brandList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.txtTile.text = brandList[position].name
        holder.txtsubTile.text = brandList[position].dis
    }
}