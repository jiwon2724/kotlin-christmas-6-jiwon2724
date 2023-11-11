package extensions

import model.Menu
import java.text.DecimalFormat

fun String.toOrderMenu(): List<Menu> {
    val orderMenu = arrayListOf<Menu>()
    split(",").forEach { menu ->
        val (productName, productOrderCount) = menu.split("-")
        val product = Menu.values()
            .first { it.productName == productName }
            .apply { count = productOrderCount.toInt() }
        orderMenu.add(product)
    }
    return orderMenu
}

private val moneyFormat = DecimalFormat("#,###")
fun Int.toFormattedMoney(): String = moneyFormat.format(this)
