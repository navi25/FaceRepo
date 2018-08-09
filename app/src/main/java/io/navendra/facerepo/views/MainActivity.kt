package io.navendra.facerepo.views

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import io.navendra.facerepo.R
import io.navendra.facerepo.model.User
import io.navendra.facerepo.viewModel.UserViewModel
import io.navendra.facerepo.views.adapters.UserAdapter
import io.navendra.facerepo.views.adapters.UserClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: LinearLayoutManager
    private lateinit var viewAdapter: UserAdapter
    private val userViewModel by lazy { ViewModelProviders.of(this).get(UserViewModel::class.java) }

    inner class userClickListener : UserClickListener(){
        override fun onClick(v: View?) {
            startUserDetailActivity(v)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        initRecyclerView()
        viewAdapter.users = userViewModel.getUsers()
        viewAdapter.notifyDataSetChanged()
    }

    private fun initRecyclerView(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = UserAdapter()
        viewAdapter.userClickListener = userClickListener()
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(this@MainActivity,LinearLayoutManager.VERTICAL))
        }
    }

    fun startUserDetailActivity(v: View?){
        val user = getUser(v)
        val intent = Intent(this, UserDetailActivity::class.java).apply {
                    putExtra("name",user?.name)
                    putExtra("userName",user?.userName)
                    putExtra("email",user?.email)
                }
        startActivity(intent)
    }

    fun getUser(v: View?): User?{
       // if(v==null || v.id!= R.layout.user_item) return null

        var user = User()
        user.name = (v?.findViewById<TextView>(R.id.name) as TextView).text.toString()
        user.email = (v?.findViewById<TextView>(R.id.email) as TextView).text.toString()
        user.userName = (v?.findViewById<TextView>(R.id.userName) as TextView).text.toString()
        return user
    }
}
