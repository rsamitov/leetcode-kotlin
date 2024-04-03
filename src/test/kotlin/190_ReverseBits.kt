import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `190_ReverseBits` {

    @Test
    fun case1() {
        assertEquals(964176192, Solution().reverseBits(43261596))
    }

    class Solution {
        // you need treat n as an unsigned value
        fun reverseBits(n: Int): Int {
            var s = Integer.toBinaryString(n)
            s = "0".repeat(32 - s.length) + s;
            s = s.reversed()
            return Integer.parseUnsignedInt(s, 2)
        }
    }
}

