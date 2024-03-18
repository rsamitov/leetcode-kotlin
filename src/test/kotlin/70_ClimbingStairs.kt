import kotlin.test.Test
import kotlin.test.assertEquals

class `70_ClimbingStairs` {

    @Test
    fun case1() {
        assertEquals(2, Solution().climbStairs(2))
    }

    @Test
    fun case2() {
        assertEquals(3, Solution().climbStairs(3))
    }


    class Solution {
        fun climbStairs(n: Int): Int {

            val map = HashMap<Int, Int>()
            map[0] = 1

            return climbStairs(n, map)
        }

        fun climbStairs(n: Int, map: HashMap<Int, Int>): Int {
            if (n < 0) return 0
            return map.computeIfAbsent(n) {
                climbStairs(it - 1, map) + climbStairs(it - 2, map)
            }
        }
    }
}

