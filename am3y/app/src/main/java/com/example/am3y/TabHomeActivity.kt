package com.example.am3y

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment

class TabHomeActivity : Fragment() {

    internal var id = arrayOf<kotlin.String>("video", "images", "wishes")
    internal var img = intArrayOf(R.drawable.videoicon, R.drawable.photos, R.drawable.mypics)

    fun onCreate(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(com.example.am3y.R.layout.activity_tab_home, container, false)

        var grid: GridView = view.findViewById(R.id.grid)
        var adapter: CustomGrid = CustomGrid(this@TabHomeActivity.context, id, img)
        grid.adapter = adapter
        return view
    }
}
