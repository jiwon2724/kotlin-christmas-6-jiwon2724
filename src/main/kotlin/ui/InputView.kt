package ui

import camp.nextstep.edu.missionutils.Console
import validation.InputValidation

class InputView(private val inputValidation: InputValidation = InputValidation()) {
    fun readDay(errorMessage: () -> Unit): String = handleException(errorMessage) {
        Console.readLine().let { day ->
            inputValidation.validateDay(day)
            day
        }
    }


    fun readMenu(errorMessage: () -> Unit): String = handleException(errorMessage) {
        Console.readLine().let { menu ->
            inputValidation.validateMenu(menu)
            menu
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