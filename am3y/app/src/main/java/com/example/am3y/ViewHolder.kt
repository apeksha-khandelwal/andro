package com.example.am3y

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setDetails(context: Context?, name:String, image:String){
        var mTextView : TextView = itemView.findViewById(R.id.label)
        var mImage: com.mikhaellopez.circularimageview.CircularImageView = itemView.findViewById(R.id.image)

        mTextView.setText(name)
        Picasso.get().load(image).into(mImage)

    }

}