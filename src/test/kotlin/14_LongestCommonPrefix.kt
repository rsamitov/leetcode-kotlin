import kotlin.math.min
import kotlin.test.Test
import kotlin.test.assertEquals

class `14_LongestCommonPrefix` {

    @Test
    fun case1() {
        val strs = arrayOf("flower", "flow", "flight")
        assertEquals("fl", Solution().longestCommonPrefix(strs))
    }

    @Test
    fun case2() {
        val strs = arrayOf("dog", "racecar", "car")
        assertEquals("", Solution().longestCommonPrefix(strs))
    }

    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty()) {
                return ""
            }
            var prefix = strs[0]

            if (strs.size == 1) {
                return prefix
            }

            for (i in 1 until strs.size) {
                var newPrefix = ""
                val str = strs[i]
                for (j in 0 until min(prefix.length, str.length)) {
                    if (prefix[j] == str[j]) {
                        newPrefix += prefix[j]
                    } else {
                        break
                    }
                }
                prefix = newPrefix
                if(prefix.isEmpty()) {
                    return prefix
                }
            }
            return prefix
        }
    }
}

