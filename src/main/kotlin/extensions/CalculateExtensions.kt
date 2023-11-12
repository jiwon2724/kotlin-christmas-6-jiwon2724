package extensions

import model.menu.Menu

fun List<Menu>.payment() = sumOf { it.count * it.price }