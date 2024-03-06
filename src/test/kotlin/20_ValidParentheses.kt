import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `20_ValidParentheses` {

    @Test
    fun case1() {
        val s = "()"
        assertTrue(Solution().isValid(s))
    }

    @Test
    fun case2() {
        val s = "()[]{}"
        assertTrue(Solution().isValid(s))
    }

    @Test
    fun case3() {
        val s = "(]"
        assertFalse(Solution().isValid(s))
    }


    class Solution {
        fun isValid(s: String): Boolean {

            val stack = mutableListOf<Char>()

            for (c in s) {
                when (c) {
                    '[', '(', '{' -> stack += c
                    ']' -> {
                        if (stack.isEmpty())
                            return false
                        if (stack.removeAt(stack.size - 1) != '[')
                            return false
                    }

                    ')' -> {
                        if (stack.isEmpty())
                            return false
                        if (stack.removeAt(stack.size - 1) != '(')
                            return false
                    }

                    '}' -> {
                        if (stack.isEmpty())
                            return false
                        if (stack.removeAt(stack.size - 1) != '{')
                            return false
                    }
                }
            }
            return stack.isEmpty()
        }
    }
}

