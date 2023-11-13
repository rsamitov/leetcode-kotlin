import kotlin.test.*

class `3_LongestSubstringWithoutRepeatingCharacters` {

    @Test
    fun case1() {
        val s = "abcabcbb"
        assertEquals(3, Solution().lengthOfLongestSubstring(s))
    }

    @Test
    fun case2() {
        val s = "bbbbb"
        assertEquals(1, Solution().lengthOfLongestSubstring(s))
    }

    @Test
    fun case3() {
        val s = "pwwkew"
        assertEquals(3, Solution().lengthOfLongestSubstring(s))
    }

    @Test
    fun case3a() {
        val s = ""
        assertEquals(0, Solution().lengthOfLongestSubstring(s))
    }

    @Test
    fun case879() {
        val s = " "
        assertEquals(1, Solution().lengthOfLongestSubstring(s))
    }

    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {
            var start = 0
            var end = 0

            val charSet = mutableSetOf<Char>()

            var max = 0

            while (end < s.length) {

                val nextChar = s.elementAt(end)
                if (!charSet.contains(nextChar)) {
                    charSet.add(nextChar)
                    end++
                } else {
                    charSet.remove(s.elementAt(start))
                    start++
                }

                val window = end - start
                if (window == charSet.size) {
                    max = maxOf(max, window)
                }
            }
            return max;
        }
    }
}

