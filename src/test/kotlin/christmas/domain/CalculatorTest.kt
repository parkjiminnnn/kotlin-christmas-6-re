package christmas.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CalculatorTest {
    private val calculator = Calculator(
        Discount(
            Calendar(3),
            Consumer("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        )
    )

    @Test
    fun `할인 전 총액 테스트`() {
        val excepted = 142000
        val result = calculator.beforeDiscountAmount()

        assertEquals(excepted, result)
    }

    @Test
    fun `총 혜택 금액 테스트`() {
        val excepted = 31246
        val result = calculator.totalDiscount()

            assertEquals(excepted, result)
    }

    @Test
    fun `혜택 후 총액 테스트`() {
        val excepted = 110754
        val result = calculator.afterDiscountAmount()

            assertEquals(excepted, result)

    }

    @Test
    fun `증정 이벤트 테스트`() {
        val excepted = 25000
        val result = calculator.freeEvent()

            assertEquals(excepted, result)
    }

    @Test
    fun `증정 배지 테스트`() {
        val excepted = "산타"
        val result = calculator.batch()

            assertEquals(excepted, result)
    }
}