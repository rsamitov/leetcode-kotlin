import kotlin.test.Test
import kotlin.test.assertEquals

class `28_ FindTheIndexOfTheFirstOccurrenceInAString` {

    @Test
    fun case1() {
        val haystack = "sadbutsad"
        val needle = "sad"
        assertEquals(0, Solution().strStr(haystack, needle))
    }

    @Test
    fun case2() {
        val haystack = "leetcode"
        val needle = "leeto"
        assertEquals(-1, Solution().strStr(haystack, needle))
    }


    @Test
    fun case74() {
        val haystack = "abc"
        val needle = "c"
        assertEquals(2, Solution().strStr(haystack, needle))
    }

    class Solution {
        fun strStr(haystack: String, needle: String): Int {
            if(haystack.length < needle.length)
                return -1

            for (i in 0 .. (haystack.length - needle.length)) {
                var found = true
                for (j in needle.indices) {
                    found = haystack[i + j] == needle[j]
                    if (!found) break
                }
                if (found)
                    return i
            }
            return -1
        }
    }
}

