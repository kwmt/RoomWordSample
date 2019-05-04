package net.kwmt27.roomwordsample.infrastructure

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<WordEntity>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: WordEntity) {
        wordDao.insert(word)
    }
}