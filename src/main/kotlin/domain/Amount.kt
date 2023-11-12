package domain

import extensions.payment
import model.menu.Menu
import model.menu.OrderMenu

class Amount(private val orderMenu: List<OrderMenu>) {
    fun beforeDiscountAmount(): Int = orderMenu.payment()
}