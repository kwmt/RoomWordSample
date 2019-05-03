package net.kwmt27.roomwordsample.infrastructure

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class WordEntity(@PrimaryKey @ColumnInfo(name = "word") val word: String)