package io.navendra.facerepo.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.navendra.facerepo.R
import io.navendra.facerepo.model.User
import kotlinx.android.synthetic.main.user_item.view.*
import javax.inject.Inject

class UserAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    @Inject lateinit var context : Context

    init {
        
    }

    var users : List<User>? = null
    private val mInflater by lazy { LayoutInflater.from(context) }
    var userClickListener : UserClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.user_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       if(users !=null) return users!!.size
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(users!=null){
            val currentUser = users?.get(position)
            holder.email.text = currentUser?.email
            holder.name.text = currentUser?.name
            holder.userName.text = currentUser?.userName
        }
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val pic : ImageView
        val name : TextView
        val userName : TextView
        val email : TextView

        init {
            pic = view.findViewById(R.id.pic) as ImageView
            name = view.findViewById(R.id.name) as TextView
            userName = view.findViewById(R.id.userName) as TextView
            email = view.findViewById(R.id.email) as TextView

            view.setOnClickListener {
                userClickListener?.onClick(it)
            }
        }


    }
}