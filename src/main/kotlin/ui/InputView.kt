package ui

import camp.nextstep.edu.missionutils.Console
import validation.InputValidation

class InputView(private val inputValidation: InputValidation = InputValidation()) {
    fun readDay(errorMessage: () -> Unit): String {
        return handleException(errorMessage) {
            val inputDay = Console.readLine()
            inputValidation.validateDay(inputDay)
            inputDay
        }
    }

    fun readMenu(errorMessage: () -> Unit): String {
        return handleException(errorMessage) {
            val inputMenu = Console.readLine()
            inputValidation.validateMenu(inputMenu)
            inputMenu
        }
    }

    companion object {
        private fun handleException(errorMessage: () -> Unit, validate: () -> String): String {
            return try {
                validate()
            } catch (e: IllegalArgumentException) {
                errorMessage()
                validate()
            }
        }
    }
}