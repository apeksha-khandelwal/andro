package com.example.am3y

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setName(name: String) {
        var mTextView: TextView = itemView.findViewById(R.id.label)

        System.out.println("viewHolder")
        mTextView.setText(name)

        mTextView.setOnClickListener(View.OnClickListener {
            //call the person
        })
    }

    fun setImage(image: String) {
        var mImage: com.mikhaellopez.circularimageview.CircularImageView =
            itemView.findViewById(R.id.image)
        Picasso.get().load(image).into(mImage)
    }
}
