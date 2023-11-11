package domain

import extensions.payment
import model.Menu

class Present(private val orderMenu: List<Menu>) {
    fun giveChampagne(): Menu {
        if (orderMenu.payment() >= TOTAL_AMOUNT) return Menu.CHAMPAGNE.apply { count = 1 }
        return Menu.CHAMPAGNE.apply { count = 0 }
    }

    companion object {
        private const val TOTAL_AMOUNT = 120_000
    }
}