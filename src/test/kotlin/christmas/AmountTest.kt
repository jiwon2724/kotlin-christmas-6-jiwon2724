package christmas

import domain.Amount
import domain.Benefit
import domain.Present
import model.menu.Menu
import model.menu.OrderMenu
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class AmountTest {
    @Test
    fun `할인 전 총 주문 금액이 맞는지 확인`() {
        val amount = Amount(orderMenu = ORDER_MENU, benefit = BENEFIT)
        assertEquals(200000, amount.beforeDiscountAmount())
    }

    @Test
    fun `총 혜택 금액이 맞는지 확인`() {
        // 크리스마스 디데이 할인 : -1200
        // 특별 할인 : -1000
        // 증정 이벤트 -25000
        // 평일 할인 : -6069
        val amount = Amount(orderMenu = ORDER_MENU, benefit = BENEFIT)
        assertEquals(-33269, amount.totalBenefitAmount())
    }

    @Test
    fun `할인 후 금액이 맞는지 확인`() {
        val amount = Amount(orderMenu = ORDER_MENU, benefit = BENEFIT)
        assertEquals(191731, amount.beforeDiscountAmount() + amount.afterDiscountAmount())
    }

    companion object {
        private val ORDER_MENU = listOf(
            OrderMenu(Menu.SEAFOOD_PASTA, 1),
            OrderMenu(Menu.RED_WINE, 2),
            OrderMenu(Menu.CHOCO_CAKE, 3)
        )

        private val PRESENT = Present(ORDER_MENU)

        private val BENEFIT = Benefit(
            orderMenu = ORDER_MENU,
            expectDay = 3,
            present = PRESENT
        ).apply { setBeforeDiscountAmount(200000) }
    }
}