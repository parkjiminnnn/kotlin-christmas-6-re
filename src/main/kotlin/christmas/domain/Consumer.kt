package christmas.domain

import christmas.utils.MenuBoard

class Consumer(private val rawMenus: String) {
    private fun getMenus(): List<Pair<String, Int>> {
        val menus = rawMenus.split(',')
        return menus.map { Pair(it.split("-")[0], it.split("-")[1].toInt()) }
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

    fun getMenuTypes() {

    }
}