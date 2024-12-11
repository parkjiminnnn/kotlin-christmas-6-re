package christmas.utils

object FormatterUtil {
    fun Int.formatWithComma(): String = "%,d".format(this)
}