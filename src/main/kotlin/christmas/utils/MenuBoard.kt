package christmas.utils

enum class MenuBoard(val menuName: String, val menuType: String, val menuPrice: Int) {
    MUSHROONSOUP("양송이수프", "애피타이저", 6000),
    TAPAS("타파스", "애피타이저", 5500),
    CAESARSALAD("시저샐러드", "애피타이저", 8000),
    TBONESTEAK("티본스테이크", "메인", 55000),
    BARBECUERIB("바비큐립", "메인", 54000),
    SEAFOODPASTA("해산물파스타", "메인", 35000),
    CHRISTMASPASTA("크리스마스파스타", "메인", 25000),
    CHOCOLATECAKE("초코케이크", "디저트", 15000),
    ICECREAM("아이스크림", "디저트", 5000),
    ZEROCOKE("제로콜라", "음료", 3000),
    REDWINE("레드와인", "음료", 60000),
    CHAMPAINE("샴페인", "음료", 25000);
}