package io.navendra.facerepo.model

import dagger.Component
import io.navendra.facerepo.views.MainActivity

class UserComponents{

    @Component
    interface UserRepo{
        fun add(app:MainActivity)
    }

}