package domain

import model.EventDay
import model.Menu

class Benefit(
    private val reserveDay: Int,
    private val orderMenu: List<Menu>
) {
    fun christmas(): Int {
        if (EventDay.CHRISTMAS.day.contains(reserveDay)) {
            return -((reserveDay-1) * CHRISTMAS_DISCOUNT_AMOUNT) + CHRISTMAS_BENEFIT_AMOUNT
        }
        return NOTHING
    }

    fun weekDay(): Int {
        // type도 enum class로 리팩토링 하기
        if (EventDay.WEEKDAY.day.contains(reserveDay)) {
            val dessertCount = orderMenu.count { it.type == "디저트" }
            return dessertCount * DAY_DISCOUNT
        }
        return NOTHING
    }

    fun weekendDay(): Int {
        // type도 enum class로 리팩토링 하기
        if (EventDay.WEEKEND.day.contains(reserveDay)) {
            val mainMenuCount = orderMenu.count { it.type == "메인" }
            return mainMenuCount * DAY_DISCOUNT
        }
        return NOTHING
    }

    companion object {
        private const val CHRISTMAS_BENEFIT_AMOUNT = 1000
        private const val CHRISTMAS_DISCOUNT_AMOUNT = 100

        private const val DAY_DISCOUNT = 2023
        private const val SPECIAL_DISCOUNT = 1000

        private const val NOTHING = 0
    }
}