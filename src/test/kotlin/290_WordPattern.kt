import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `290_WordPattern` {

    @Test
    fun case1() {
        val pattern = "abba"
        val s = "dog cat cat dog"
        assertTrue(Solution().wordPattern(pattern, s))
    }

    @Test
    fun case2() {
        val pattern = "abba"
        val s = "dog cat cat fish"
        assertFalse(Solution().wordPattern(pattern, s))
    }

    @Test
    fun case3() {
        val pattern = "aaaa"
        val s = "dog cat cat dog"
        assertFalse(Solution().wordPattern(pattern, s))
    }


    class Solution {
        fun wordPattern(pattern: String, s: String): Boolean {
            for (word in s.splitToSequence(' ')) {
                println(word)
            }
            return true
        }
    }
}

