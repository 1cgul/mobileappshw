package edu.farmingdale.pizzapartybottomnavbar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.ceil


class PizzaPartyViewModel : ViewModel() {
    var totalPizzas by mutableIntStateOf(0)
    var numPeopleInput by mutableStateOf("")
    var hungerLevel by mutableStateOf("Medium")

    fun calculateNumPizzas(numPeople: Int, hungerLevel: String): Int {
        val slicesPerPizza = 8
        val slicesPerPerson = when (hungerLevel) {
            "Light" -> 2
            "Medium" -> 3
            "Hungry" -> 4
            else -> 5
        }

        return ceil(numPeople * slicesPerPerson / slicesPerPizza.toDouble()).toInt()
    }
}