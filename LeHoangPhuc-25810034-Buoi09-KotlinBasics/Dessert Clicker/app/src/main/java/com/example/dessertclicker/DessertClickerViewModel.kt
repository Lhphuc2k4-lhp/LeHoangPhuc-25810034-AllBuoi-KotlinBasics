package com.example.dessertclicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert

class DessertClickerViewModel : ViewModel() {

    var uiState by mutableStateOf(DessertClickerUiState())
        private set

    private val dessertList = Datasource.dessertList

    fun onDessertClicked() {
        val currentDessert = dessertList[uiState.currentDessertIndex]
        val dessertsSold = uiState.dessertsSold + 1

        val nextDessertIndex = dessertList.indexOfLast {
            dessertsSold >= it.startProductionAmount
        }

        uiState = uiState.copy(
            dessertsSold = dessertsSold,
            revenue = uiState.revenue + currentDessert.price,
            currentDessertIndex = nextDessertIndex
        )
    }

    fun getCurrentDessert(): Dessert {
        return dessertList[uiState.currentDessertIndex]
    }
}
