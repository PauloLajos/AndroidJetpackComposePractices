package hu.paulolajos.taskmanagerwithroom.app

import android.app.Application
import hu.paulolajos.taskmanagerwithroom.data.AppContainer
import hu.paulolajos.taskmanagerwithroom.data.AppDataContainer

class TaskManagerApp : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}