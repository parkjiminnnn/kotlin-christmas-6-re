package christmas.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CalendarTest {
    private val calendar = Calendar(3)

    @Test
    fun `주말인지 테스트`() {
        val excepted = false
        val result = calendar.isWeekend()

        assertEquals(excepted, result)
    }

    @Test
    fun `크리스마스 이벤트 기간인지 테스트`() {
        val excepted = true
        val result = calendar.isChristmasEvent()

        assertEquals(excepted, result)
    }

    @Test
    fun `스페셜 이벤트 기간인지 테스트`() {
        val excepted = true
        val result = calendar.isSpecialEvent()

        assertEquals(excepted, result)
    }
}