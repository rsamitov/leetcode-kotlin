import kotlin.test.Test
import kotlin.test.assertEquals

class `13_RomanToInteger` {

    @Test
    fun case1() {
        val str = "III"
        assertEquals(3, Solution().romanToInt(str))
    }

    @Test
    fun case2() {
        val str = "LVIII"
        assertEquals(58, Solution().romanToInt(str))
    }

    @Test
    fun case3() {
        val str = "MCMXCIV"
        assertEquals(1994, Solution().romanToInt(str))
    }

    class Solution {

        fun romanToInt(s: String): Int {

            var prevous = ' '
            var ans = 0
            for (c in s.reversed()) {
                ans += when (c) {
                    'I' -> when (prevous) {
                                'V', 'X' -> -1
                                else -> 1
                            }
                    'V' -> 5
                    'X' -> when(prevous) {
                                'L', 'C' -> -10
                                else -> 10
                            }
                    'L' -> 50
                    'C' -> when(prevous) {
                                'D', 'M' -> -100
                                else -> 100
                            }
                    'D' -> 500
                    'M' -> 1000
                    else -> throw Exception()
                }
                prevous = c
            }
            return ans;
        }
    }
}

