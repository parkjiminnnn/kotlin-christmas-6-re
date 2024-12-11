package christmas.utils

import christmas.domain.MenuBoard

object ErrorHandler {
    fun handleReserveDay(rawReserveDay: String): Int {
        val reserveDay = rawReserveDay.toIntOrNull()
        if (reserveDay == null || reserveDay !in 1..31)
            throw IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        return reserveDay
    }

    fun handleMenus(menus: List<Pair<String, Int>>) {
        val menuBoards = MenuBoard.entries.map { it.menuName }
        menus.forEach {
            if (!menuBoards.contains(it.first)) throw IllegalArgumentException("ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }

    fun handleQuantity(rawQuantity: String):Int {
        val quality = rawQuantity.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        return quality
    }
}
