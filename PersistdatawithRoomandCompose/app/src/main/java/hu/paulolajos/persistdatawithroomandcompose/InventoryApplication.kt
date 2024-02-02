package hu.paulolajos.persistdatawithroomandcompose

import android.app.Application
import hu.paulolajos.persistdatawithroomandcompose.data.AppContainer
import hu.paulolajos.persistdatawithroomandcompose.data.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}