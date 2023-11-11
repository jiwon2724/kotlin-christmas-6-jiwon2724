package ui

import camp.nextstep.edu.missionutils.Console
import validation.InputValidation

class InputView(private val inputValidation: InputValidation = InputValidation()) {
    fun readDay(errorMessage: () -> Unit): Int {
        val inputDay = Console.readLine()
        return try {
            inputValidation.validateDay(inputDay)
        } catch (e: IllegalArgumentException) {
            errorMessage()
            readDay(errorMessage)
        }
    }

    companion object {

    }
}