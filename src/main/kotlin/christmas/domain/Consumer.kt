package christmas.domain

import christmas.utils.ErrorHandler.handleQuantity

class Consumer(private val rawMenus: String) {
    fun getMenus(): List<Pair<String, Int>> {
        val menus = rawMenus.split(',')
        return menus.map { Pair(it.split("-")[0], handleQuantity(it.split("-")[1])) }
    }

    fun getMatchingMenuPrice(): List<List<Int>> {
        val menus = getMenus()
        return menus.map { menu ->
            MenuBoard.entries.find { it.menuName == menu.first }?.let { listOf(menu.second, it.menuPrice) }!!
        }
    }

    fun getMenuTypes(): List<Pair<String, Int>> {
        val menus = getMenus()
        return menus.map { menu ->
            MenuBoard.entries.find { it.menuName == menu.first }?.let { Pair(it.menuType, menu.second) }!!
        }
    }
}