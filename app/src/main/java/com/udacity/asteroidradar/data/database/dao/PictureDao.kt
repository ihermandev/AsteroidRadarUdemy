package com.udacity.asteroidradar.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.Constants.PICTURE_TABLE
import com.udacity.asteroidradar.data.database.DataBasePicture

@Dao
interface PictureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPicture(picture: DataBasePicture)

    @Query("delete from $PICTURE_TABLE")
    suspend fun clearTable(): Int

    @Query("select * from $PICTURE_TABLE ORDER BY id DESC LIMIT 1")
    fun getPictureOFDay(): LiveData<DataBasePicture>
}
