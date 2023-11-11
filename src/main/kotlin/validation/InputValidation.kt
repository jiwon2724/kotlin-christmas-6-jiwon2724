package validation

import model.Menu

class InputValidation {
    fun validateDay(day: String) {
        require((day.toIntOrNull() != null) && (day.toInt() > 0))
        require(day.toInt() in VALID_DAY)
    }

    fun validateMenu(orderMenu: String) {
        val validMenu = orderMenu.split(",")
        val orderResult = arrayListOf<String>()
        validMenu.forEach { menu ->
            require(menu.contains("-"))
            val (productName, productOrderCount) = menu.split("-")
            orderResult.add(productName)
            require(Menu.values().map { it.productName }.contains(productName))
            require((productOrderCount.toIntOrNull() != null) && (productOrderCount.toInt() > 0))
        }
        val beverage = Menu.values().filter { it.type == "음료" }.map { it.productName }
        require(!orderResult.all { beverage.contains(it) })
    }

    companion object {
        private val VALID_DAY = 1..31
    }
}