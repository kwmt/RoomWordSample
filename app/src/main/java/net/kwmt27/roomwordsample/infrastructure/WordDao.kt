package net.kwmt27.roomwordsample.infrastructure

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {
    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): List<WordEntity>

    @Insert
    suspend fun insert(word: WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}