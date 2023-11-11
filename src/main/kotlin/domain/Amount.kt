package domain

import model.Menu

class Amount(private val orderMenu: List<Menu>) {
    fun beforeDiscountAmount(): Int = orderMenu.sumOf { it.price * it.count }
}