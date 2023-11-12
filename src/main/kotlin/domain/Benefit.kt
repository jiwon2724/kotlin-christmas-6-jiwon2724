package domain

class Benefit(private val reserveDay: Int) {
    fun christmas(): Int = ((reserveDay-1) * 100) + START_BENEFIT_AMOUNT
    
    companion object {
        private const val START_BENEFIT_AMOUNT = 1000
        private const val DISCOUNT_AMOUNT = 100
    }
}