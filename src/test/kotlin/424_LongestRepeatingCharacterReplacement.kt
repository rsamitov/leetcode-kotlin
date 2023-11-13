import kotlin.test.*

class `424_LongestRepeatingCharacterReplacement` {

    @Test
    fun case1() {
        val s = "ABAB"
        val k = 2
        assertEquals(4, Solution().characterReplacement(s, k))
    }

    @Test
    fun case2() {
        val s = "AABABBA"
        val k = 1
        assertEquals(4, Solution().characterReplacement(s, k))
    }

    class Solution {
        fun characterReplacement(s: String, k: Int): Int {

            var start = 0
            var end = 0

            val charMap = hashMapOf(s.elementAt(end) to 1)

            var max = 0
            while (end < s.length) {
                val sum = end - start + 1
                if ((sum - charMap.values.max()) <= k) {
                    max = maxOf(max, sum)
                    end += 1
                    if (end == s.length) {
                        return max;
                    }
                    charMap.compute(s.elementAt(end)) { _, count -> if (count == null) 1 else count + 1 }
                } else {
                    charMap.computeIfPresent(s.elementAt(start)) { _, count -> count - 1 }
                    start += 1
                }
            }

            return max;
        }
    }
}

