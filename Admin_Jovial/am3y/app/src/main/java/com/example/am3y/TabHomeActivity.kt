package com.example.am3y

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import androidx.fragment.app.Fragment

class TabHomeActivity : Fragment() {

    internal var id = arrayOf<kotlin.String>("Wishes", "Videos", "Memories","ME4YOU")
    internal var img = intArrayOf(R.drawable.wishes, R.drawable.videoicon, R.drawable.photos, R.drawable.mypics)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        val view = inflater.inflate(R.layout.activity_tab_home, container, false)

        var grid: GridView = view.findViewById(R.id.grid)
        var adapter: CustomGrid = CustomGrid(this@TabHomeActivity.context, id, img)
        grid.adapter = adapter
        System.out.println("TabHome")
        grid.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Get the GridView selected/clicked item text
                val selectedItem = parent.getItemAtPosition(position).toString()

                var intent: Intent
                System.out.println(selectedItem)
                if(selectedItem.equals("Images"))
                    intent = Intent(this@TabHomeActivity.context, ImageActivity::class.java)
                else if(selectedItem.equals("Videos"))
                    intent = Intent(this@TabHomeActivity.context, VideoActivity::class.java)
                else if(selectedItem.equals("Memories"))
                    intent = Intent(this@TabHomeActivity.context, MemoriesActivity::class.java)
                else
                    intent = Intent(this@TabHomeActivity.context, MeActivity::class.java)
                startActivity(intent)
            }
        }
        return view
    }
}
