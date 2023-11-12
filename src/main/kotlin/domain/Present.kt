package domain

import extensions.payment
import model.menu.Menu
import model.menu.OrderMenu

class Present(private val orderMenu: List<OrderMenu>) {
    fun giveChampagne(): OrderMenu {
        if (orderMenu.payment() >= TOTAL_AMOUNT) return OrderMenu(menu = Menu.CHAMPAGNE, count = 1)
        return OrderMenu(menu = Menu.CHAMPAGNE, count = 0)
    }

    companion object {
        private const val TOTAL_AMOUNT = 120_000
    }
}