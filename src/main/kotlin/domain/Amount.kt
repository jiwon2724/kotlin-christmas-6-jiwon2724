package domain

import extensions.payment
import model.benefit.BenefitType
import model.menu.OrderMenu

class Amount(
    private val orderMenu: List<OrderMenu>,
    private val benefit: Benefit
) {
    fun beforeDiscountAmount(): Int = orderMenu.payment()

    fun totalBenefitAmount(): Int = benefit
        .allBenefit()
        .sumOf { it.disCount }

    fun afterDiscountAmount(): Int = benefit
        .allBenefit()
        .filter { it.type != BenefitType.PRESENT_EVENT }
        .sumOf { it.disCount }
}