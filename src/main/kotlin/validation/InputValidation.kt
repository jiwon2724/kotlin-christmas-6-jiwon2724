package validation

import model.Menu

class InputValidation {
    fun validateDay(day: String) {
        require((day.toIntOrNull() != null) && (day.toInt() > 0))
        require(day.toInt() in VALID_DAY)
    }

    // 주석 작성한 부분 구현 끝난 후 함수로 분리해야해!
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
        // 음료만 주문시
        val beverage = Menu.values().filter { it.type == "음료" }.map { it.productName }
        require(!orderResult.all { beverage.contains(it) })

        // 메뉴 최대 20개
        require(orderResult.size <= MAX_ORDER_COUNT)

        // 중복 메뉴
        require(orderResult.size == orderResult.distinct().size)
    }

    companion object {
        private val VALID_DAY = 1..31
        private const val MAX_ORDER_COUNT = 20
    }
}