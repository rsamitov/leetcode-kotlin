import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `191_NumberOf1Bits` {

    @Test
    fun case1() {
        assertEquals(964176192, Solution().hammingWeight(43261596))
    }

    class Solution {
        fun hammingWeight(n: Int): Int {

            var count = 0
            var a = n

            while (a != 0) {
                if (a and 1 == 1) count++
                a = a ushr 1
            }
            return count
        }
    }
}

