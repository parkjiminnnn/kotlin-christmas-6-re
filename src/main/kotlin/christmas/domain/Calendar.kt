package christmas.domain

class Calendar(val reserveDay: Int) {

    fun isWeekend(): Boolean {
        val weekends = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 20)
        return weekends.contains(reserveDay)
    }

    fun isChristmasEvent(): Boolean {
        return reserveDay in 1..25
    }

    fun isSpecialEvent(): Boolean {
        val specialEventDays = listOf(3, 10, 17, 24, 25, 31)
        return specialEventDays.contains(reserveDay)
    }
}