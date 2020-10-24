import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun mainTest() {
        main()
        assertEquals(true, true)
    }

    @Test
    fun getCommission() {
        val expected = 0
        assertEquals(expected, getCommission(transferAmount = 1000))
    }

    @Test
    fun getCommission_MasterCard() {
        var expected = 0
        assertEquals(expected, getMasterCardCommission(transferAmount = 1000))
        expected = 26
        assertEquals(expected, getMasterCardCommission(monthSum = 75001, transferAmount = 1000))
    }


    @Test
    fun getCommission_Visa() {
        val cardType = "VISA"
        val monthSum = 75000
        var expected = 37
        assertEquals(expected, getCommission(cardType, monthSum, transferAmount = 1000))
        expected = 75
        assertEquals(expected, getCommission(cardType, monthSum, transferAmount = 10000))
    }

}