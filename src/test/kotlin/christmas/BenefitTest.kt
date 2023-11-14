package christmas

import christmas.Constant.Companion.BENEFIT
import christmas.Constant.Companion.ORDER_MENU
import christmas.Constant.Companion.PRESENT
import domain.Benefit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BenefitTest {
    @Test
    fun `크리스마스 이벤트 할인 적용 확인`() {
        val christmasBenefit = BENEFIT.allBenefit()
        assertEquals(-1200, christmasBenefit[0].disCount)
    }

    @Test
    fun `평일 할인 적용 확인`() {
        val weekdayBenefit = BENEFIT.allBenefit()
        assertEquals(-6069, weekdayBenefit[1].disCount)
    }

    @Test
    fun `주말 할인 적용 확인`() {
        val weekendBenefit = Benefit(
            expectDay = 1,
            orderMenu = ORDER_MENU,
            present = PRESENT
        ).apply { setBeforeDiscountAmount(200000) }.allBenefit()
        assertEquals(-2023, weekendBenefit[1].disCount)
    }

    @Test
    fun `특별 할인 적용 확인`() {
        val specialBenefit = BENEFIT.allBenefit()
        assertEquals(-1000, specialBenefit[2].disCount)
    }

    @Test
    fun `증정 이벤트 여부 확인`() {
        val presentBenefit = BENEFIT.allBenefit()
        assertEquals(-25000, presentBenefit[3].disCount)
    }
}