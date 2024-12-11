package christmas.utils

import christmas.utils.ErrorHandler.handleDrink
import christmas.utils.ErrorHandler.handleMenus
import christmas.utils.ErrorHandler.handleQuantity
import christmas.utils.ErrorHandler.handleReserveDay
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorHandlerTest {

    @Test
    fun `예약 날짜가 올바른 값이 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            handleReserveDay("a")
            handleReserveDay("0")
        }
    }

    @Test
    fun `입력 메뉴가 올바르지 않을시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            handleMenus(listOf("제로콜라" to 1, "아이스크림" to 1))
            handleMenus(listOf("사탕" to 1))

        }
    }

    @Test
    fun `음료만 주문시 예외발생`() {
        assertThrows<IllegalArgumentException> {
            handleDrink(listOf("제로콜라" to 1))
        }
    }

    @Test
    fun `수량이 올바르지 않으면 예외발생`() {
        assertThrows<IllegalArgumentException> {
            handleQuantity("21")
            handleQuantity("0")
        }

    }
}
