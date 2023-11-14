package christmas

import christmas.Constant.Companion.PRESENT
import model.menu.Menu
import model.menu.OrderMenu
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PresentTest {
    @Test
    fun `샴페인 증정 여부를 확인`() {
        assertEquals(OrderMenu(menu = Menu.CHAMPAGNE, count = 1), PRESENT.giveChampagne())
    }
}