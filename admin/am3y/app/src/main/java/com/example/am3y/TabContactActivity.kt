package com.example.am3y

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class TabContactActivity : Fragment() {
    lateinit var mRecyclerView: RecyclerView
    lateinit var rootRef: FirebaseFirestore
    private var adapter: FirestoreRecyclerAdapter<Model, ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(com.example.am3y.R.layout.activity_tab_contact, container, false)
        mRecyclerView = view.findViewById(R.id.recycleViewlist)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this.context))

        rootRef = FirebaseFirestore.getInstance();
        var query: Query = rootRef.collection("contacts")
        val options = FirestoreRecyclerOptions.Builder<Model>()
            .setQuery(query, Model::class.java)
            .build()
        adapter = object : FirestoreRecyclerAdapter<Model, ViewHolder>(options) {
            override fun onBindViewHolder(
                holder: ViewHolder,
                position: Int,
                model: Model
            ) {
                holder.setName(model.name)
                holder.setImage(model.image)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_listview, parent, false)
                return ViewHolder(view)
            }
        }
        mRecyclerView.setAdapter(adapter)
        return view
    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop() {
        super.onStop()

        adapter?.stopListening()
    }
}
