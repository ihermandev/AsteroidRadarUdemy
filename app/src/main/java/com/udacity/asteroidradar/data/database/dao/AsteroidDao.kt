package com.udacity.asteroidradar.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.Constants.ASTEROID_TABLE
import com.udacity.asteroidradar.data.database.DatabaseAsteroid

@Dao
interface AsteroidDao {
    @Query("select * from $ASTEROID_TABLE")
    fun getAsteroids(): LiveData<List<DatabaseAsteroid>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg asteroids: DatabaseAsteroid)

    @Query("delete from $ASTEROID_TABLE")
    fun clearTable()
}
