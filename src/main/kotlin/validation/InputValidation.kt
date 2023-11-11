package validation

import model.Menu

class InputValidation {
    fun validateDay(day: String) {
        require((day.toIntOrNull() != null) && (day.toInt() > 0))
        require(day.toInt() in VALID_DAY)
    }

    companion object {
        private val VALID_DAY = 1..31
    }
}