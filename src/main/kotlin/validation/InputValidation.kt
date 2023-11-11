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
            val menuName = menuAndCount[0]
            val menuCount = menuAndCount[1]
            require(Menu.values().map { it.productName }.contains(menuName))
            require((menuCount.toIntOrNull() != null) && (menuCount.toInt() > 0))
        }
    }

    companion object {
        private val VALID_DAY = 1..31
    }
}