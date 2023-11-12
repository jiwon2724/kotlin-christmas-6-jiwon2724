package domain

import model.EventDay
import model.menu.MenuType
import model.menu.OrderMenu

class Benefit(
    private val reserveDay: Int,
    private val orderMenu: List<OrderMenu>,
    private val present: Present
) {
    private fun christmasEvent(): Int {
        if (EventDay.CHRISTMAS.day.contains(reserveDay)) {
            return -(((reserveDay-1) * CHRISTMAS_DISCOUNT_AMOUNT) + CHRISTMAS_BENEFIT_AMOUNT)
        }
        return NOTHING
    }

    private fun weekEvent(): Int {
        if (EventDay.WEEKDAY.day.contains(reserveDay)) {
            var dessertCount = 0
            orderMenu
                .filter { order -> order.menu.type == MenuType.DESSERT }
                .forEach { dessert ->  dessertCount += dessert.count }
            return -(dessertCount * DAY_DISCOUNT)
        }
        return NOTHING
    }

    private fun weekendEvent(): Int {
        if (EventDay.WEEKEND.day.contains(reserveDay)) {
            val mainMenuCount = orderMenu.count { order -> order.menu.type == MenuType.MAIN }
            return -(mainMenuCount * DAY_DISCOUNT)
        }
        return NOTHING
    }

    private fun specialEvent(): Int {
        if (EventDay.SPECIAL.day.contains(reserveDay)) return -SPECIAL_DISCOUNT
        return NOTHING
    }

    fun allBenefit(): List<Int> {
        if (present.giveChampagne().count == 1) {
            return listOf(christmasEvent(), weekEvent(), specialEvent(), -25000)
        }
        return listOf(christmasEvent(), weekEvent(), specialEvent(), 0)
    }


    companion object {
        private const val CHRISTMAS_BENEFIT_AMOUNT = 1000
        private const val CHRISTMAS_DISCOUNT_AMOUNT = 100

        private const val DAY_DISCOUNT = 2023
        private const val SPECIAL_DISCOUNT = 1000

        private const val NOTHING = 0
    }
}