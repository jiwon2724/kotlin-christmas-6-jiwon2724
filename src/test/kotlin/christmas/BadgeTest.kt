package christmas

import domain.Badge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BadgeTest {
    @Test
    fun `혜택 금액에 따라 이벤트 배지 여부 확인`() {
        val allBenefitAmount = 30000
        assertEquals("산타", Badge(allBenefitAmount).eventBadge().type)
    }
}