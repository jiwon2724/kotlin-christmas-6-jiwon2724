package validation

class InputValidation {
    fun validateDay(day: String): Int {
        require((day.toIntOrNull() != null) && (day.toInt() > 0))
        require(day.toInt() in VALID_DAY)
        return day.toInt()
    }

    companion object {
        private val VALID_DAY = 1..31
    }
}