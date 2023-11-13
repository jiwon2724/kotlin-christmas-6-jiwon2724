package ui

import camp.nextstep.edu.missionutils.Console
import validation.InputValidation

class InputView(private val inputValidation: InputValidation = InputValidation()) {
    fun readDay(errorMessage: () -> Unit): String {
        return try {
            Console.readLine().let { inputDay ->
                inputValidation.validateDay(inputDay)
                inputDay
            }
        } catch (e: IllegalArgumentException) {
            errorMessage()
            readDay(errorMessage)
        }
    }

    fun readMenu(errorMessage: () -> Unit): String {
        return try {
            Console.readLine().let { inputMenu ->
                inputValidation.validateMenu(inputMenu)
                inputMenu
            }
        } catch (e: IllegalArgumentException) {
            errorMessage()
            readMenu(errorMessage)
        }
    }
}
