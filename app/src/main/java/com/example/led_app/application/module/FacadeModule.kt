package com.example.led_app.application.module


import LedClientSimulation
import android.content.Context
import androidx.room.Room
import com.example.led_app.BuildConfig
import com.example.led_app.application.ports.inbound.LedClient
import com.example.led_app.application.ports.outbound.LedAppRepository
import com.example.led_app.config.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class FacadeModule(val applicationContext: Context) {
    val db: AppDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideLedRepository(): LedAppRepository {
//        db.clearAllTables()
        return db.ledDao()
    }

    @Provides
    fun provideLedClient(): LedClient {
        if (BuildConfig.FLAVOR == "stub") {
//            return StubLedClient()
        }
        return LedClientSimulation()
    }


}