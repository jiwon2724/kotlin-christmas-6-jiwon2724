package domain

import model.EventDay
import model.Menu
import model.MenuDetail

class Benefit(
    private val reserveDay: Int,
    private val orderMenu: List<Menu>
) {
    fun christmas(): Int {
        if (EventDay.CHRISTMAS.day.contains(reserveDay)) return -((reserveDay-1) * 100) + START_BENEFIT_AMOUNT
        return NOTHING
    }
    fun weekDay() {

    }

    companion object {
        private const val START_BENEFIT_AMOUNT = 1000
        private const val DISCOUNT_AMOUNT = 100
        private const val NOTHING = 0
    }
}