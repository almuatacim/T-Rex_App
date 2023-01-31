package ly.raqam.t_rex_counter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class myAdapter(private val context : Activity, private val arraylist : ArrayList<User>): ArrayAdapter<User>(context, R.layout.list_item,arraylist) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item,null)
        val imageView : ImageView = view.findViewById(R.id.profile_pic)
        val userName : TextView = view.findViewById(R.id.personName)
        val lastMessage : TextView = view.findViewById(R.id.lastMessage)
        val lastMsgTime : TextView = view.findViewById(R.id.lastMsgtime)
        imageView.setImageResource(arraylist[position].imageId)
        userName.text = arraylist[position].name
        lastMessage.text = arraylist[position].lastmessage
        lastMsgTime.text = arraylist[position].lastMsgtime

        return view
    }
}