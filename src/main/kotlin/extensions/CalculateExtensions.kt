package extensions

import model.menu.OrderMenu

fun List<OrderMenu>.payment() = sumOf { it.menu.price * it.count }