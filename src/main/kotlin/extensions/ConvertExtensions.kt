package extensions

import model.menu.Menu
import model.menu.OrderMenu
import java.text.DecimalFormat

fun String.toOrderMenu(): List<OrderMenu> {
    val orderMenu = arrayListOf<OrderMenu>()
    split(",").forEach { userInputMenu ->
        val (menuName, menuCount) = userInputMenu.split("-")
        val menu = Menu.values().first { it.menuName == menuName }
        orderMenu.add(OrderMenu(menu = menu, count = menuCount.toInt()))
    }
    return orderMenu
}

private val moneyFormat = DecimalFormat("#,###")
fun Int.toFormattedMoney(): String = moneyFormat.format(this)
