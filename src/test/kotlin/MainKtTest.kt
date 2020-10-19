import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun main() {
    }

    @Test
    fun getCommission() {
        val expected = 0
        val cardType = "Vk Pay"
        val monthSum = 1000
        val transferAmount = 1000
        val result = getCommission(cardType, monthSum, transferAmount)
        assertEquals(expected, result)
    }

    @Test
    fun getCommission_MasterCard() {
        val expected = 0
        val cardType = "MasterCard"
        val monthSum = 75000
        val transferAmount = 1000
        val result = getCommission(cardType, monthSum, transferAmount)
        assertEquals(expected, result)
    }

    @Test
    fun getCommission_MasterCard_over75000() {
        val expected = 26
        val cardType = "MasterCard"
        val monthSum = 75001
        val transferAmount = 1000
        val result = getCommission(cardType, monthSum, transferAmount)
        assertEquals(expected, result)
    }


    @Test
    fun getCommission_Visa() {
        val expected = 35
        val cardType = "VISA"
        val monthSum = 75000
        val transferAmount = 1000
        val result = getCommission(cardType, monthSum, transferAmount)
        assertEquals(expected, result)
    }




}