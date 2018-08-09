package io.navendra.facerepo.model

import javax.inject.Inject

class UserRepository @Inject constructor(){

    fun getUsers() : List<User>{
        return UserDataFactory().makeUserList(40)
    }
}
