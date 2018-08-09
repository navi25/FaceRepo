package io.navendra.facerepo.application

import android.app.Application
import io.navendra.facerepo.dagger.AppComponent
import io.navendra.facerepo.dagger.AppModule
import io.navendra.facerepo.dagger.DaggerAppComponent

class FaceApplication : Application(){
    lateinit var faceComponent : AppComponent

    private fun initDagger(app: FaceApplication): AppComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        faceComponent = initDagger(this)
    }
}