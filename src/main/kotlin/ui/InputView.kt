package ui

import camp.nextstep.edu.missionutils.Console
import validation.InputValidation

class InputView(private val inputValidation: InputValidation = InputValidation()) {
    fun readDay(errorMessage: () -> Unit): String {
        val inputDay = Console.readLine()
        return try {
            inputValidation.validateDay(inputDay)
            inputDay
        } catch (e: IllegalArgumentException) {
            errorMessage()
            readDay(errorMessage)
        }
    }

    fun readMenu(errorMessage: () -> Unit): String {
        val inputMenu = Console.readLine()
        return try {
            inputValidation.validateMenu(inputMenu)
            inputMenu
        } catch (e: IllegalArgumentException) {
            errorMessage()
            readMenu(errorMessage)
        }
    }

    companion object {

    }
}