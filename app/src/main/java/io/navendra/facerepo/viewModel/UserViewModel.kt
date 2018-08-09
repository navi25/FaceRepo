package io.navendra.facerepo.viewModel

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import dagger.Component
import io.navendra.facerepo.model.User
import io.navendra.facerepo.model.UserComponents.UserRepo
import io.navendra.facerepo.model.UserRepository
import io.navendra.facerepo.views.MainActivity
import javax.inject.Inject

class UserViewModel : ViewModel() {

    @Inject lateinit var userRepository:UserRepository

    fun getUsers() : List<User>{
        return userRepository.getUsers()
    }

    @Component
    interface Usek{
        fun ad(app:UserViewModel)
    }
}