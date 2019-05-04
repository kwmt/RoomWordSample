package net.kwmt27.roomwordsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.kwmt27.roomwordsample.infrastructure.WordEntity
import net.kwmt27.roomwordsample.infrastructure.WordRepository
import net.kwmt27.roomwordsample.infrastructure.WordRoomDatabase

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository

    val allWords: LiveData<List<WordEntity>>

    init {
        val worDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(worDao)
        allWords = repository.allWords
    }

    fun insert(word: WordEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

}