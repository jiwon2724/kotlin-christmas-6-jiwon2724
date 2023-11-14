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
        assertEquals(200000, Amount(orderMenu = ORDER_MENU, benefit = BENEFIT).beforeDiscountAmount())
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
        )
    }
}