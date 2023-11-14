package christmas

import domain.Badge
import domain.Benefit
import domain.Present
import model.menu.Menu
import model.menu.OrderMenu

class Constant {
    companion object {
        val ORDER_MENU = listOf(
            OrderMenu(Menu.SEAFOOD_PASTA, 1),
            OrderMenu(Menu.RED_WINE, 2),
            OrderMenu(Menu.CHOCO_CAKE, 3)
        )

        val PRESENT = Present(ORDER_MENU)

        val BENEFIT = Benefit(
            orderMenu = ORDER_MENU,
            expectDay = 3,
            present = PRESENT
        ).apply { setBeforeDiscountAmount(200000) }
    }
}