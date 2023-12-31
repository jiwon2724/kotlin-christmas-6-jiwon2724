package ui

import extensions.toFormattedMoney
import model.badge.BadgeType
import model.benefit.BenefitDetail
import model.benefit.BenefitType
import model.menu.OrderMenu

class OutputView {
    fun printWelcome() = println(WELCOME)
    fun promptReservationDate() = println(RESERVATION_DATE)
    fun promptMenuAndCount() = println(ORDER_MENU_AND_COUNT)
    fun printEventPreview(day: Int) = println(EVENT_BENEFIT_PREVIEW.format(day))

    fun printOrderMenus(orderMenu: List<OrderMenu>) {
        println(ORDER_MENU_HEADER)
        orderMenu.forEach { order -> println(MENU_FORMAT.format(order.menu.menuName, order.count)) }
        println()
    }

    fun printTotalAmount(totalAmount: String) {
        println(TOTAL_AMOUNT_HEADER)
        println("${AMOUNT_FORMAT.format(totalAmount)}\n")
    }


    fun printPresentMenu(presentMenu: OrderMenu) {
        println(PRESENT_MENU_HEADER)
        if (presentMenu.count == 1) {
            println("${MENU_FORMAT.format(presentMenu.menu.menuName, presentMenu.count)}\n")
            return
        }
        println(NOTHING)
    }

    fun printBenefitDetails(benefitDetail: List<BenefitDetail> = listOf()) {
        println(BENEFIT_DETAILS_HEADER)
        if (benefitDetail.isEmpty() || benefitDetail.all { it.disCount == 0 }) {
            println(NOTHING)
            return
        }
        benefitDetail.forEach { benefit ->
            if (benefit.type != BenefitType.NOTING) {
                println(BENEFIT_DETAILS.format(benefit.type.discountName, benefit.disCount.toFormattedMoney()))
            }
        }
        println()
    }

    fun printTotalBenefitAmount(amount: Int = 0) {
        println(TOTAL_BENEFIT_AMOUNT)
        println("${AMOUNT_FORMAT.format(amount.toFormattedMoney())}\n")
    }

    fun printExpectedPaymentAfterDiscount(payment: Int) {
        println(EXPECTED_PAYMENT_AFTER_DISCOUNT_HEADER)
        println("${AMOUNT_FORMAT.format(payment.toFormattedMoney())}\n")
    }

    fun printEventBadge(eventBadge: BadgeType) {
        println(EVENT_BADGE_HEADER)
        println(eventBadge.type)
    }

    fun printInvalidDay() = println(INVALID_DAY)
    fun printInvalidMenu() = println(INVALID_MENU)

    companion object {
        private const val AMOUNT_FORMAT = "%s원"
        private const val MENU_FORMAT = "%s %d개"
        private const val WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        private const val RESERVATION_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        private const val ORDER_MENU_AND_COUNT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
        private const val EVENT_BENEFIT_PREVIEW = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
        private const val ORDER_MENU_HEADER = "\n<주문 메뉴>"
        private const val TOTAL_AMOUNT_HEADER = "<할인 전 총주문 금액>"
        private const val PRESENT_MENU_HEADER = "<증정 메뉴>"
        private const val BENEFIT_DETAILS_HEADER = "<혜택 내역>"
        private const val BENEFIT_DETAILS = "%s: %s원"
        private const val TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>"
        private const val EXPECTED_PAYMENT_AFTER_DISCOUNT_HEADER = "<할인 후 예상 결제 금액>"
        private const val EVENT_BADGE_HEADER = "<12월 이벤트 배지>"

        private const val ERROR = "[ERROR]"
        private const val INVALID_DAY = "$ERROR 유효하지 않은 날짜입니다. 다시 입력해 주세요."
        private const val INVALID_MENU = "$ERROR 유효하지 않은 주문입니다. 다시 입력해 주세요."
        private const val NOTHING = "없음\n"
    }
}