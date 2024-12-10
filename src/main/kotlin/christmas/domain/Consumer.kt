package christmas.domain

import christmas.utils.ErrorHandler.handleQuantity
import christmas.utils.MenuBoard

class Consumer(private val rawMenus: String) {
    fun getMenus(): List<Pair<String, Int>> {
        val menus = rawMenus.split(',')
        return menus.map { Pair(it.split("-")[0], handleQuantity(it.split("-")[1])) }
    }

    fun getMatchingMenuPrice(): List<List<Int>> {
        val menus = getMenus()
        val matchingMenuPrices = mutableListOf<List<Int>>()
        menus.forEach { menu ->
            for (i in MenuBoard.entries) {
                if (i.menuName == menu.first)
                    matchingMenuPrices.add(listOf(menu.second, i.menuPrice))
            }
        }
        return matchingMenuPrices
    }

    fun getMenuTypes(): List<Pair<String, Int>> {
        val menus = getMenus()
        val menuTypes = mutableListOf<Pair<String, Int>>()
        menus.forEach {
            for (i in MenuBoard.entries) {
                if (it.first == i.menuName) menuTypes.add(Pair(i.menuType, it.second))
            }
        }
        return menuTypes
    }
}