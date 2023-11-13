package christmas

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import validation.InputValidation

class InputExceptionTest {
    @Test
    fun `입력한 날짜가 숫자나 지정된 범위의 날짜가 아니면 예외가 발생한다`() {
        val exceptionCase = listOf(
            listOf("1, 2, 3, 1day"), // 문자열
            listOf("1, 2, 3, -1"), // 음수
            listOf("1, 2, 3, 32") // 범위에 없는 수
        )
        assertThrows<IllegalArgumentException> {
            exceptionCase.forEach {
                it.forEach { case ->
                    InputValidation().validateDay(case)
                }
            }
        }
    }
}