package io.navendra.facerepo.dagger

import android.os.Parcel
import dagger.Component
import io.navendra.facerepo.views.MainActivity
import java.util.*
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectMainActivity(target: MainActivity)
}

class ParcelExtension{
    fun Parcel.writeTreeMap(map : TreeMap<Any,Any>){

    }
}