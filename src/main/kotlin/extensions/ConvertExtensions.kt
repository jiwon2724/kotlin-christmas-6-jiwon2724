package extensions

import model.Menu
import model.OrderMenu

fun String.toOrderMenu(): List<Menu> {
    val orderMenu = arrayListOf<Menu>()
    split(",").forEach { menu ->
        val menuAndCount = menu.split("-")
        val productName = menuAndCount[0]
        val productOrderCount = menuAndCount[1].toInt()
        val product = Menu.valueOf(productName).apply { count = productOrderCount }
        orderMenu.add(product)
    }
    return orderMenu
}