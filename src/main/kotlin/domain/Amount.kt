package domain

import extensions.payment
import model.Menu

class Amount(private val orderMenu: List<Menu>) {
    fun beforeDiscountAmount(): Int = orderMenu.payment()
}