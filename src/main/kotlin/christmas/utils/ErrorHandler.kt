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
            if (!menuBoards.contains(it.first) || handleDuplicateMenus(menus))
                throw IllegalArgumentException("ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }

    private fun handleDuplicateMenus(menus: List<Pair<String, Int>>): Boolean {
        val menuNames = menus.map { it.first }.toSet()
        return menuNames.size != menus.size
    }

    fun handleDrink(menuTypes: List<Pair<String, Int>>) {
        val menus = menuTypes.map { it.first }
        if (!menus.contains("메인") && !menus.contains("애피타이저") && !menus.contains("디저트")) throw IllegalArgumentException(
            "ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        )
    }

    fun handleQuantity(rawQuantity: String): Int {
        val quantity = rawQuantity.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        if (quantity > 20 || quantity <= 0) throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        return quantity
    }
}
