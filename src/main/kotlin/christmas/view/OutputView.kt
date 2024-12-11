package christmas.view

import christmas.utils.FormatterUtil.formatWithComma

object OutputView {
    fun printPreview(reserveDay: Int) {
        println("12월 ${reserveDay}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun printOrders(menus: List<Pair<String, Int>>) {
        println("<주문 메뉴>")
        menus.forEach { menu ->
            println("${menu.first} ${menu.second}개")
        }
        println()
    }

    fun printBeforeDiscountAmount(beforeDiscountAmount: Int) {
        println("<할인 전 총주문 금액>")
        println("${beforeDiscountAmount}원\n")
    }

    fun printFreeEvent(freeEvent: Int) {
        println("<증정 메뉴>")
        if (freeEvent == 25000) println("샴페인 1개") else println("없음")
    }

    fun printDiscount(
        christmasDiscount: Int,
        weekdayDiscount: Int,
        weekendDisCount: Int,
        specialDiscount: Int,
        freeEvent: Int
    ) {
        println("<혜택 내역>")
        if (christmasDiscount != 0) println("크리스마스 디데이 할인: -${christmasDiscount.formatWithComma()}원")
        if (weekdayDiscount != 0) println("평일 할인: -${weekdayDiscount.formatWithComma()}원")
        if (weekendDisCount != 0) println("주말 할인: -${weekendDisCount.formatWithComma()}원")
        if (specialDiscount != 0) println("특별 할인: -${specialDiscount.formatWithComma()}원")
        if (freeEvent != 0) println("증정 이벤트: -${freeEvent.formatWithComma()}원")
        if (christmasDiscount == 0 && weekdayDiscount == 0
            && weekendDisCount == 0 && specialDiscount == 0 && freeEvent == 0
        ) println("없음")
        println()
    }

    fun printTotalDiscount(totalDiscount: Int) {
        println("<총혜택 금액>")
        println("-${totalDiscount.formatWithComma()}원\n")
    }

    fun printAfterDiscountAmount(afterDiscountAmount: Int) {
        println("<할인 후 예상 결제 금액>")
        println("${afterDiscountAmount.formatWithComma()}원\n")
    }

    fun printBatch(batch: String) {
        println("<12월 이벤트 배지>")
        println(batch)
    }
}