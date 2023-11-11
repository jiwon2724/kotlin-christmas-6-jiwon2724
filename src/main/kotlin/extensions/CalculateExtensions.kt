package extensions

import model.Menu

fun List<Menu>.payment() = sumOf { it.count * it.price }