package io.navendra.facerepo.model

import java.util.*

class UserDataFactory{

    fun randomString() : String{
        return UUID.randomUUID().toString()
    }

    fun makeUser() : User{
        return User(randomString(),randomString(),randomString(),randomString())
    }

    fun makeUserList(count:Int) : List<User>{
        var users = mutableListOf<User>()
        repeat(count){
            users.add(makeUser())
        }
        return users
    }

}