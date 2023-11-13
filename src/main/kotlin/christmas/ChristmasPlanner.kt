package christmas

import domain.Amount
import domain.Badge
import domain.Benefit
import domain.Present
import extensions.toFormattedMoney
import extensions.toOrderMenu
import model.menu.OrderMenu
import ui.InputView
import ui.OutputView

class ChristmasPlanner(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun start() = with(outputView) {
        val expectDay = promptExpectDay()
        val orderMenu = promptOrderMenu()
        printEventPreview(expectDay)
        printOrderMenus(orderMenu)
        discountEvent(orderMenu, expectDay)
    }

    private fun OutputView.promptExpectDay(): Int {
        printWelcome()
        promptReservationDate()
        return inputView.readDay { printInvalidDay() }.toInt()
    }

    private fun OutputView.promptOrderMenu(): List<OrderMenu> {
        val orderMenu = inputView.readMenu { printInvalidMenu() }.toOrderMenu()
        printOrderMenus(orderMenu)
        return orderMenu
    }

    private fun OutputView.discountEvent(orderMenu: List<OrderMenu>, expectDay: Int) {
        val present = Present(orderMenu)
        val benefit = Benefit(orderMenu = orderMenu, expectDay = expectDay, present = present)
        val amount = Amount(orderMenu, benefit)

        printTotalAmount(amount.beforeDiscountAmount().toFormattedMoney())
        printPresentMenu(present.giveChampagne())
        if (!amount.isMinimumAmount()) printBenefitDetails(benefit.allBenefit()) else printBenefitDetails()
        printTotalBenefitAmount(amount.totalBenefitAmount())
        printExpectedPaymentAfterDiscount(amount.beforeDiscountAmount() + amount.totalBenefitAmount())

        eventBadge(amount)
    }

    private fun OutputView.eventBadge(amount: Amount) {
        val badge = Badge(amount.afterDiscountAmount())
        printEventBadge(badge.eventBadge())
    }
}