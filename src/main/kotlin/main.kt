fun main() {
    val currentTransfer = 1000000
    val monthSum = 100000
    val currentCard = "MasterCard"

    println("Комиссия при переводе $currentTransfer рупий с карты $currentCard равна " +
            "${getCommission(cardType = currentCard, monthSum = monthSum, transferAmount = currentTransfer)} рупий")
}

fun getCommission(cardType: String = "Vk Pay", monthSum: Int = 0, transferAmount: Int): Int {
    return when (cardType) {
        "VISA", "Мир" -> getVisaCommission(transferAmount)
        "MasterCard", "Maestro" -> getMasterCardCommission(monthSum, transferAmount)
        else -> 0               //это для Vk Pay (и черного нала)
    }
}

fun getMasterCardCommission(monthSum: Int = 0, transferAmount: Int): Int {
    return if (monthSum > 75000) (transferAmount * 0.006).toInt() + 20 else 0
}

fun getVisaCommission(transferAmount: Int): Int {
    val commission = (transferAmount * 0.0075).toInt()
    return if (commission < 35) 35 else commission
}
