import kotlin.test.*

class `125_ValidPalindrome` {

    @Test
    fun case1() {
        val s = "A man, a plan, a canal: Panama"
        assertTrue(Solution().isPalindrome(s))
    }

    @Test
    fun case2() {
        val s = "race a car"
        assertFalse(Solution().isPalindrome(s))
    }

    @Test
    fun case3() {
        val s = " "
        assertTrue(Solution().isPalindrome(s))
    }

    class Solution {
        fun isPalindrome(s: String): Boolean {
            var left = 0
            var right = s.length - 1

            while (left < right) {

                val leftChar = s[left].uppercaseChar()
                if (leftChar !in 'A'..'Z' && leftChar !in '0'..'9') {
                    left++
                    continue
                }
                val rightChar = s[right].uppercaseChar()
                if (rightChar !in 'A'..'Z' && rightChar !in '0'..'9') {
                    right--
                    continue
                }
                if (leftChar != rightChar) {
                    return false
                } else {
                    left++
                    right--
                }
            }
            return true
        }
    }
}

