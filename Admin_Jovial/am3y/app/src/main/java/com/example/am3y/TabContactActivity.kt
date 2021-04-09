package com.example.am3y

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.am3y.R
import com.google.firebase.auth.FirebaseAuth


class TabContactActivity : Fragment() {
    lateinit var mRecyclerView: RecyclerView
    lateinit var mRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(com.example.am3y.R.layout.activity_tab_contact, container, false)
        mRecyclerView = view.findViewById(R.id.recycleViewlist)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager

        var mDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

        mRef = mDatabase.getReference().child("contacts")
        return view
    }

    override fun onStart() {
        super.onStart()
        val options: FirebaseRecyclerOptions<Model> =
            FirebaseRecyclerOptions.Builder<Model>().setQuery(mRef, Model::class.java)
                .setLifecycleOwner(this).build()
        var adapter = object : FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Model) {
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_listview, parent, false)
                System.out.println("TabContact")
                return ViewHolder(view)
            }

            override fun onDataChanged() {
                // If there are no chat messages, show a view that invites the user to add a message.
            }
        }
        mRecyclerView.setAdapter(adapter)
    }
}
