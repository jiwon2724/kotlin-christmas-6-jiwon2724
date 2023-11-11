package validation

import model.Menu

class InputValidation {
    fun validateDay(day: String) {
        require((day.toIntOrNull() != null) && (day.toInt() > 0))
        require(day.toInt() in VALID_DAY)
    }

    fun validateMenu(orderMenu: String) {
        val validMenu = orderMenu.split(",")
        validMenu.forEach { menu ->
            require(menu.contains("-"))
            val menuAndCount = menu.split("-")
            val productName = menuAndCount[0]
            val productOrderCount = menuAndCount[1]
            require(Menu.values().map { it.productName }.contains(productName))
            require((productOrderCount.toIntOrNull() != null) && (productOrderCount.toInt() > 0))
        }
    }

    companion object {
        private val VALID_DAY = 1..31
    }
}