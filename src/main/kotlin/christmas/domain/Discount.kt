package christmas.domain

class Discount(private val calendar: Calendar) {
    fun christmasDiscount(): Int {
        if (calendar.isChristmasEvent()) {
            return 1000 + ((calendar.reserveDay - 1) * 100)
        }
        return 0
    }

    fun specialDiscount(): Int {
        if (calendar.isSpecialEvent()) return 1000
        return 0
    }

    fun weekdayDiscount(): Int {
        if (!calendar.isWeekend()) {

        }
        return 0
    }

    fun weekendDisCount(): Int {
        if (calendar.isWeekend()) {

        }
        return 0
    }
}
