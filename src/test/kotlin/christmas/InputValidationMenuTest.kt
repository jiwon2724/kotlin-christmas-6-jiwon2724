package christmas

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import validation.InputValidation

class InputValidationMenuTest {
    @Test
    fun `메뉴가 -를 포함하지 않으면 예외가 발생한다`() {
        val input = "레드와인"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateMenu(input)
        }
    }

    @Test
    fun `존재하지 않는 메뉴 이름이 입력된 경우 예외가 발생한다`() {
        val input = "투움바파스타-1"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateMenu(input)
        }
    }

    @Test
    fun `주문 개수가 문자인 경우 예외가 발생한다`() {
        val input = "레드와인-s"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateMenu(input)
        }
    }

    @Test
    fun `주문 개수가 0인 경우 예외가 발생한다`() {
        val input = "레드와인-0"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateMenu(input)
        }
    }

    @Test
    fun `주문 개수가 음수인 경우 예외가 발생한다`() {
        val input = "레드와인--1"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateMenu(input)
        }
    }

    @Test
    fun `입력이 비어있는 경우 예외가 발생한다`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            InputValidation().validateMenu(input)
        }
    }

    @Test
    fun `메뉴(단수개) 주문수의 총 합이 20개가 넘는경우 예외가 발생한다`() {
        val input = "해산물파스타-20"
        assertThrows<IllegalArgumentException> {
            InputValidation().validateDay(input)
        }
    }

    @Test
    fun `메뉴(복수개) 주문수의 총 합이 20개가 넘는경우 예외가 발생한다`() {
        val input = listOf("해산물파스타-10", "레드와인-6", "샴페인-10")
        assertThrows<IllegalArgumentException> {
            input.forEach { menu ->
                InputValidation().validateDay(menu)
            }
        }
    }

    @Test
    fun `중복 주문이 있는 경우 예외가 발생한다`() {
        val input = listOf("해산물파스타-10", "해산물파스타-1")
        assertThrows<IllegalArgumentException> {
            input.forEach { menu ->
                InputValidation().validateDay(menu)
            }
        }
    }

    @Test
    fun `음료만 주문한 경우`() {
        val input = listOf("레드와인-10", "샴페인-1")
        assertThrows<IllegalArgumentException> {
            input.forEach { menu ->
                InputValidation().validateDay(menu)
            }
        }
    }
}