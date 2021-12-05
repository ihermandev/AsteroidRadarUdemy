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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg asteroids: DatabaseAsteroid)

    @Query("select * from $ASTEROID_TABLE")
    fun getAsteroids(): LiveData<List<DatabaseAsteroid>>

    @Query("select * from $ASTEROID_TABLE order by closeApproachDate ASC")
    fun getAsteroidsSortedByDate(): LiveData<List<DatabaseAsteroid>>

    @Query("select * from $ASTEROID_TABLE where closeApproachDate >= :startDate and closeApproachDate <= :endDate order by closeApproachDate ASC")
    fun getAsteroidsInDateRange(
        startDate: String,
        endDate: String
    ): LiveData<List<DatabaseAsteroid>>

    @Query("delete from $ASTEROID_TABLE")
    suspend fun clearTable(): Int

    @Query("delete from $ASTEROID_TABLE where closeApproachDate < :date")
    suspend fun deleteAsteroidsBeforeDate(date: String): Int
}
