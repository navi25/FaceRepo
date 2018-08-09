package io.navendra.facerepo.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.navendra.facerepo.R
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        Log.d(UserDetailActivity::class.java.simpleName,"Here")
        val nameVal = intent.getStringExtra("name")
        val userNameVal = intent.getStringExtra("userName")
        val emailVal = intent.getStringExtra("email")

        name.text = nameVal
        userName.text = userNameVal
        email.text = emailVal
    }
}
