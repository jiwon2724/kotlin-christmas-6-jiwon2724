package validation

import model.menu.Menu
import model.menu.MenuType

class InputValidation {
    fun validateDay(day: String) {
        require((day.toIntOrNull() != null) && (day.toInt() > 0))
        require(day.toInt() in VALID_DAY)
    }

    fun validateMenu(orderMenu: String) {
        val orderResult = arrayListOf<String>()
        orderMenu.split(",").forEach { menu ->
            require(menu.contains("-"))
            val (menuName, productOrderCount) = menu.split("-")
            orderResult.add(menuName)
            require(Menu.values().map { it.menuName }.contains(menuName))
            require((productOrderCount.toIntOrNull() != null) && (productOrderCount.toInt() < 0))
        }
        val beverage = Menu.values().filter { it.type == MenuType.BEVERAGE }.map { it.menuName }
        require(!orderResult.all { beverage.contains(it) })
        require(orderResult.size <= MAX_ORDER_COUNT)
        require(orderResult.size == orderResult.distinct().size)
    }

    companion object {
        private val VALID_DAY = 1..31
        private const val MAX_ORDER_COUNT = 20
    }
}