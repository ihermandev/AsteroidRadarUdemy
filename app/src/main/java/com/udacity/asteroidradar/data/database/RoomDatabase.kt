package com.udacity.asteroidradar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroidradar.Constants.DATABASE_NAME
import com.udacity.asteroidradar.data.database.dao.AsteroidDao
import com.udacity.asteroidradar.data.database.dao.PictureDao

@Database(
    entities = [DataBasePicture::class, DatabaseAsteroid::class],
    version = 1,
    exportSchema = false
)
abstract class AsteroidsDatabase : RoomDatabase() {
    abstract val pictureDao: PictureDao

    abstract val asteroidDao: AsteroidDao
}

private lateinit var INSTANCE: AsteroidsDatabase

fun getDatabase(context: Context): AsteroidsDatabase {
    synchronized(AsteroidsDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AsteroidsDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
    return INSTANCE
}

