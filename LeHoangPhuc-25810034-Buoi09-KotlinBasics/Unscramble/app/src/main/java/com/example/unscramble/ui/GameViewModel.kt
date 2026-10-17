package com.example.unscramble.ui
import androidx.compose.runtime.ScopeUpdateScope
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import com.example.unscramble.data.SCORE_INCREASE
import kotlinx.coroutines.flow.update
import com.example.unscramble.data.MAX_NO_OF_WORDS
class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    private lateinit var  currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()
    private fun pickRandomWordAndShuffle(): String {
        val availableWords = allWords.filterNot { usedWords.contains(it) }

        if (availableWords.isEmpty()) {
            return ""
        }

        currentWord = availableWords.random()
        usedWords.add(currentWord)

        return shuffleCurrentWord(currentWord)
    }
    private fun shuffleCurrentWord(word: String) : String {
        val temWord = word.toCharArray()
        temWord.shuffle()
        while (String(temWord).equals(word)) {
            temWord.shuffle()
        }
        return String(temWord)
    }
    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }
    var userGuess by mutableStateOf("")
        private set
    fun resetGame(){
        usedWords.clear()
        userGuess = ""
        _uiState.value = GameUiState(
            currentScrambleWord = pickRandomWordAndShuffle()
        )
    }
    init {
        resetGame()
    }

    fun checkUserGuess(){
        if(userGuess.equals(currentWord, ignoreCase = true)) {
            val updateScope = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameScore(updateScope)
        } else {
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess("")
    }
    private fun updateGameScore(updatedScore: Int) {
        if (usedWords.size >= MAX_NO_OF_WORDS) {
            _uiState.update { currentState ->
                currentState.copy(
                    isGameOver = true,
                    score = updatedScore,
                    isGuessedWordWrong = false
                )
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambleWord = pickRandomWordAndShuffle(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }
    fun skipWord(){
        updateGameScore(_uiState.value.score)
        updateUserGuess("")
    }

}