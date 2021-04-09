package com.example.am3y

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.am3y.R

class CustomGrid(internal var context: Context?, names: Array<String>, images: IntArray) :
        BaseAdapter() {
    internal var imagesid: IntArray = kotlin.IntArray(images.size)
    internal var namesid: Array<String?> = kotlin.arrayOfNulls<kotlin.String>(names.size)

    init {
        for (i in names.indices) {
            imagesid.set(i, images[i])
            namesid.set(i, names[i])
        }
    }

    override fun getCount(): Int {
        return namesid.size
    }

    override fun getItem(position: Int): Any? {
        return namesid[position]
    }

    override fun getItemId(position: Int): Long {
        return namesid[position] as Long
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // TODO Auto-generated method stub
        var grid: View
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if (convertView == null) {
            grid = inflater.inflate(R.layout.activity_grid, parent,false)
            val textView = grid.findViewById(R.id.text) as TextView
            val imageView = grid.findViewById(R.id.image) as ImageView
            textView.text = namesid[position]
            imageView.setImageResource(imagesid[position])
            System.out.println("CustomGrid")
        } else
            grid = convertView

        return grid
    }
}
