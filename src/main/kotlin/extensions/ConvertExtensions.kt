package extensions

import model.OrderMenu

fun String.toOrderMenu(): List<OrderMenu> {
    val orderMenu = arrayListOf<OrderMenu>()
    split(",").forEach { menu ->
        val menuAndCount = menu.split("-")
        val productName = menuAndCount[0]
        val productOrderCount = menuAndCount[1].toInt()
        orderMenu.add(OrderMenu(productName = productName, count = productOrderCount))
    }
    return orderMenu
}