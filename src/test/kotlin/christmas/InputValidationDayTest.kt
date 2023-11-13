package christmas

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import validation.InputValidation

class InputValidationDayTest {
    @Test
    fun `날짜에 문자열이 입력된 경우 예외가 발생한다`() {
        val input = "1day"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateDay(input)
        }
    }

    @Test
    fun `날짜에 음수가 입력된 경우 예외가 발생한다`() {
        val input = "-1"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateDay(input)
        }
    }

    @Test
    fun `날짜 범위에 없는 수가 입력된 경우 예외가 발생한다`() {
        val input = "32"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateDay(input)
        }
    }
}