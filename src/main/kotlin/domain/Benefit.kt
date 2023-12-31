package domain

import model.benefit.BenefitDetail
import model.benefit.BenefitType
import model.benefit.EventDay
import model.menu.MenuType
import model.menu.OrderMenu

class Benefit(
    private val expectDay: Int,
    private val orderMenu: List<OrderMenu>,
    private val present: Present
) {

    private var _beforeDiscountAmount: Int = 0
    private val beforeDiscountAmount: Int
        get() = _beforeDiscountAmount

    private fun christmasEvent(): BenefitDetail {
        if (EventDay.CHRISTMAS.day.contains(expectDay)) {
            val disCount = -(((expectDay-1) * CHRISTMAS_DISCOUNT_AMOUNT) + CHRISTMAS_BENEFIT_AMOUNT)
            return BenefitDetail(BenefitType.CHRISTMAS_D_DAY, disCount)
        }
        return BenefitDetail(BenefitType.NOTING)
    }

    private fun weekdayEvent(): BenefitDetail {
        var dessertCount = 0
        orderMenu
            .filter { order -> order.menu.type == MenuType.DESSERT }
            .forEach { dessert ->  dessertCount += dessert.count }
        val disCount = -(dessertCount * DAY_DISCOUNT)
        return BenefitDetail(BenefitType.WEEKDAY, disCount)
    }

    private fun weekendEvent(): BenefitDetail {
        var mainMenuCount = 0
        orderMenu
            .filter { order -> order.menu.type == MenuType.MAIN }
            .forEach { mainMenu -> mainMenuCount += mainMenu.count }
        val disCount = -(mainMenuCount * DAY_DISCOUNT)
        return BenefitDetail(BenefitType.WEEKEND, disCount)
    }

    private fun specialEvent(): BenefitDetail {
        if (EventDay.SPECIAL.day.contains(expectDay)) return BenefitDetail(BenefitType.SPECIAL, -SPECIAL_DISCOUNT)
        return BenefitDetail(BenefitType.NOTING)
    }

    private fun presentEvent(): BenefitDetail {
        val disCount = -(present.giveChampagne().let { it.menu.price * it.count })
        if (disCount != 0) return BenefitDetail(BenefitType.PRESENT_EVENT, disCount)
        return BenefitDetail(BenefitType.NOTING)
    }

   private fun checkWeekdayAndWeekend(): BenefitDetail {
        if (EventDay.WEEKEND.day.contains(expectDay)) return weekendEvent()
        return weekdayEvent()
    }

    fun setBeforeDiscountAmount(amount: Int) {
        _beforeDiscountAmount = amount
    }

    fun allBenefit(): List<BenefitDetail> {
        if (beforeDiscountAmount >= MINIMUM_PAYMENT_AMOUNT) {
            return listOf(christmasEvent(), checkWeekdayAndWeekend(), specialEvent(), presentEvent())
        }
        return emptyList()
    }

    companion object {
        private const val CHRISTMAS_BENEFIT_AMOUNT = 1000
        private const val CHRISTMAS_DISCOUNT_AMOUNT = 100

        private const val DAY_DISCOUNT = 2023
        private const val SPECIAL_DISCOUNT = 1000

        const val MINIMUM_PAYMENT_AMOUNT = 10_000
    }
}