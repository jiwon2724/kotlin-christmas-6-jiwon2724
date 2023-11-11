package extensions

import model.OrderMenu

fun String.convertOrderMenu(): List<OrderMenu> {
    val orderMenu = arrayListOf<OrderMenu>()
    split(",").forEach { menu ->
        val menuAndCount = menu.split("-")
        val productName = menuAndCount[0]
        val count = menuAndCount[1].toInt()
        orderMenu.add(OrderMenu(
            productName = productName,
            count = count
        ))
    }
    return orderMenu
}