package christmas.domain

class Calculator(private val discount: Discount, private val consumer: Consumer) {
    fun beforeDiscountAmount(): Int {
        val matchingMenuPrice = consumer.getMatchingMenuPrice()
        var total = 0
        matchingMenuPrice.forEach { prices ->
            total += prices.sumOf { it * it }
        }
        return total
    }

    fun totalDiscount(): Int {
        return discount.christmasDiscount() + discount.weekdayDiscount() +
                discount.specialDiscount() + discount.weekendDisCount()
    }

    fun afterDiscountAmount(): Int {
        return beforeDiscountAmount() - totalDiscount()
    }

    fun freeEvent(): Int {
        if (beforeDiscountAmount() >= 120000) return 25000
        return 0
    }

    fun batch(): String {
        val totalDiscount = totalDiscount()
        return when {
            totalDiscount in 5000 until 10000 -> "별"
            totalDiscount in 10000 until 20000 -> "트리"
            totalDiscount > 20000 -> "산타"
            else -> ""
        }
    }
}
