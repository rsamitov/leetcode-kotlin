import kotlin.test.Test
import kotlin.test.assertEquals

class `58_LengthOfLastWord` {

    @Test
    fun case1() {
        val s = "Hello World"
        assertEquals(5, Solution().lengthOfLastWord(s))
    }

    @Test
    fun case2() {
        val s = "   fly me   to   the moon  "
        assertEquals(4, Solution().lengthOfLastWord(s))
    }

    class Solution {
        fun lengthOfLastWord(s: String): Int {

            var count = 0
            for (i in s.length - 1 downTo 0) {
                if (s[i] != ' ') {
                    count ++
                } else if (count > 0 ) {
                    break
                }
            }
            return count
        }
    }
}

