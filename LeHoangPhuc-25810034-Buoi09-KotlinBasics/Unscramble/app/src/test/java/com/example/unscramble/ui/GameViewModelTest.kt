package com.example.unscramble.ui
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.Assert.assertTrue
import com.example.unscramble.data.MAX_NO_OF_WORDS

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        var currentGameUiState = viewModel.uiState.value

        val correctPlayerWord =
            getUnscrambledWord(currentGameUiState.currentScrambleWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value

        assertFalse(currentGameUiState.isGuessedWordWrong)
        assertEquals(SCORE_INCREASE, currentGameUiState.score)
    }
    @Test
    fun gameViewModel_IncorrectWordGuessed_ErrorFlagSet() {
        viewModel.updateUserGuess("wrong")
        viewModel.checkUserGuess()

        val currentGameUiState = viewModel.uiState.value

        assertTrue(currentGameUiState.isGuessedWordWrong)
        assertEquals(0, currentGameUiState.score)
    }
    @Test
    fun gameViewModel_SkipWord_NewWordShownAndScoreUnchanged() {
        val initialGameUiState = viewModel.uiState.value

        viewModel.skipWord()

        val currentGameUiState = viewModel.uiState.value

        assertEquals(0, currentGameUiState.score)
        assertEquals(
            initialGameUiState.currentWordCount + 1,
            currentGameUiState.currentWordCount
        )
        assertFalse(currentGameUiState.isGuessedWordWrong)
    }
    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased() {
        var currentGameUiState = viewModel.uiState.value

        val correctPlayerWord =
            getUnscrambledWord(currentGameUiState.currentScrambleWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        val lastWordCount = currentGameUiState.currentWordCount

        viewModel.skipWord()

        currentGameUiState = viewModel.uiState.value

        assertEquals(SCORE_INCREASE, currentGameUiState.score)
        assertEquals(
            lastWordCount + 1,
            currentGameUiState.currentWordCount
        )
    }
    @Test
    fun gameViewModel_CorrectWordGuessedOnLastWord_GameOver() {
        var currentGameUiState = viewModel.uiState.value

        // Đi đến từ cuối cùng
        while (currentGameUiState.currentWordCount < MAX_NO_OF_WORDS) {
            val correctPlayerWord =
                getUnscrambledWord(currentGameUiState.currentScrambleWord)

            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()

            currentGameUiState = viewModel.uiState.value
        }

        // Đoán đúng từ cuối cùng
        val correctPlayerWord =
            getUnscrambledWord(currentGameUiState.currentScrambleWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value

        assertTrue(currentGameUiState.isGameOver)
        assertEquals(
            MAX_NO_OF_WORDS,
            currentGameUiState.currentWordCount
        )
    }
}