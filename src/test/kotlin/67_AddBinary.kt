import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.assertEquals

class `67_AddBinary` {

    @Test
    fun case1() {
        assertEquals("100", Solution().addBinary("11", "1"))
    }

    @Test
    fun case2() {
        assertEquals("10101", Solution().addBinary("1010", "1011"))
    }

    class Solution {
        fun addBinary(a: String, b: String): String {

            var carry = false
            var ans = StringBuilder(max(a.length, b.length) + 1)

            for (i in 1..max(a.length, b.length)) {
                var ad = a.getOrElse(a.length - i) { '0' } == '1'
                var bd = b.getOrElse(b.length - i) { '0' } == '1'


                if ((ad && bd)
                    || (!ad && !bd)) {
                    if (carry) ans.append('1')
                    else ans.append('0')
                    carry = ad && bd
                } else {
                    if (carry) ans.append('0')
                    else ans.append('1')
                }
            }
            if (carry) ans.append('1')
            return ans.reverse().toString()
        }
    }
}

