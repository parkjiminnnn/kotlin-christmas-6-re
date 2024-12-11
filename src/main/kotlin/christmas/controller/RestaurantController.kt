package christmas.controller

import christmas.domain.Calculator
import christmas.domain.Calendar
import christmas.domain.Consumer
import christmas.domain.Discount
import christmas.utils.ErrorHandler.handleDrink
import christmas.utils.ErrorHandler.handleMenus
import christmas.utils.ErrorHandler.handleReserveDay
import christmas.view.InputView.inputMenusMessage
import christmas.view.InputView.inputReserveDayMessage
import christmas.view.OutputView.printAfterDiscountAmount
import christmas.view.OutputView.printBatch
import christmas.view.OutputView.printBeforeDiscountAmount
import christmas.view.OutputView.printDiscount
import christmas.view.OutputView.printFreeEvent
import christmas.view.OutputView.printOrders
import christmas.view.OutputView.printPreview
import christmas.view.OutputView.printTotalDiscount

class RestaurantController {
    fun run() {
        val reserveDay = validReserveDay()
        val consumer = validMenus()
        val calendar = Calendar(reserveDay)
        val discount = Discount(calendar, consumer)
        val calculator = Calculator(discount)

        printPreview(reserveDay)
        printOrders(consumer.getMenus())
        printBeforeDiscountAmount(calculator.beforeDiscountAmount())
        printFreeEvent(calculator.freeEvent())
        printDiscount(
            specialDiscount = discount.specialDiscount(),
            christmasDiscount = discount.christmasDiscount(),
            weekdayDiscount = discount.weekdayDiscount(),
            weekendDisCount = discount.weekendDisCount(),
            freeEvent = calculator.freeEvent()
        )
        printTotalDiscount(calculator.totalDiscount())
        printAfterDiscountAmount(calculator.afterDiscountAmount())
        printBatch(calculator.batch())
    }

    private fun validReserveDay(): Int {
        while (true) {
            try {
                val reserveDay = inputReserveDayMessage()
                Calendar(handleReserveDay(reserveDay))
                return handleReserveDay(reserveDay)
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    private fun validMenus(): Consumer {
        while (true) {
            try {
                val consumer = Consumer(inputMenusMessage())
                handleMenus(consumer.getMenus())
                handleDrink(consumer.getMenuTypes())
                return consumer
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
}