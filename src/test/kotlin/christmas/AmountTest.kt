package christmas

import christmas.Constant.Companion.BENEFIT
import christmas.Constant.Companion.ORDER_MENU
import domain.Amount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class AmountTest {
    @Test
    fun `할인 전 총 주문 금액이 맞는지 확인`() {
        val amount = Amount(orderMenu = ORDER_MENU, benefit = BENEFIT)
        assertEquals(200000, amount.beforeDiscountAmount())
    }

    @Test
    fun `총 혜택 금액이 맞는지 확인`() {
        // 크리스마스 디데이 할인 : -1200
        // 특별 할인 : -1000
        // 증정 이벤트 -25000
        // 평일 할인 : -6069
        val amount = Amount(orderMenu = ORDER_MENU, benefit = BENEFIT)
        assertEquals(-33269, amount.totalBenefitAmount())
    }

    @Test
    fun `할인 후 금액이 맞는지 확인`() {
        val amount = Amount(orderMenu = ORDER_MENU, benefit = BENEFIT)
        assertEquals(191731, amount.beforeDiscountAmount() + amount.afterDiscountAmount())
    }
}