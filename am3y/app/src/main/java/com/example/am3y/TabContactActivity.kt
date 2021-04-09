package com.example.am3y

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TabContactActivity : Fragment()  {
    lateinit var mRecyclerView : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(com.example.am3y.R.layout.activity_tab_contact, container, false)
        mRecyclerView = view.findViewById(R.id.recycleViewlist)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager

        var mDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()

        val mRef: DatabaseReference = mDatabase.getReference("contacts")
        return view
    }

    override fun onStart() {
        super.onStart()
        var adapter = object: FirebaseRecyclerAdapter<Model, ViewHolder>(
                Model.class,
                        R.layout.listview,
                        ViewHolder.class,
                                mRef
        ){
            fun populateViewHolder(viewHolder: ViewHolder, model: Model, position: Int) {
                viewHolder.setDetails(this@TabContactActivity.context, model.name, model.image)
            }
        }
        mRecyclerView.setAdapter(adapter)
    }
}
