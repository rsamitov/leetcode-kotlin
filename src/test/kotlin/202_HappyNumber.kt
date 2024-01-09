import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `202_HappyNumber` {

    @Test
    fun case1() {
        assertTrue(Solution().isHappy(19))
    }

    @Test
    fun case2() {
        assertFalse(Solution().isHappy(2))
    }


    class Solution {
        fun isHappy(n: Int): Boolean {

            val past = HashSet<Int>()
            past.add(n)
            var result = n
            while (result != 1) {
                var newResult = 0;
                for (char in result.toString()) {
                    newResult += char.digitToInt() * char.digitToInt()
                }
                if(!past.add(newResult)) {
                    return false
                }
                result = newResult
            }
            return true;
        }
    }
}

