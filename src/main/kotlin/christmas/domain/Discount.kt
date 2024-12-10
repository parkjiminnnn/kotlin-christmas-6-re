package christmas.domain

class Discount(private val calendar: Calendar, val consumer: Consumer) {
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
        val menuTypes = consumer.getMenuTypes()
        if (!calendar.isWeekend()) {
            return menuTypes.filter { it.first == "디저트" }.sumOf { it.second } * 2023
        }
        return 0
    }

    fun weekendDisCount(): Int {
        val menuTypes = consumer.getMenuTypes()
        if (calendar.isWeekend()) {
            return menuTypes.filter { it.first == "메인" }.sumOf { it.second } * 2023
        }
        return 0
    }
}
