import kotlin.test.*

class `392_IsSubsequence` {

    @Test
    fun case1() {
        val s = "abc"
        val t = "ahbgdc"
        assertTrue(Solution().isSubsequence(s, t))
    }

    @Test
    fun case2() {
        val s = "axc"
        val t = "ahbgdc"
        assertFalse(Solution().isSubsequence(s, t))
    }


    class Solution {
        fun isSubsequence(s: String, t: String): Boolean {
            if(s.isEmpty()) {
                return true
            }

            var currentChar = 0
            for (char in t) {
                if (char == s.elementAt(currentChar)) {
                    currentChar ++
                    if(currentChar == s.length) {
                        return true
                    }
                }
            }
            return false
        }
    }
}

