import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `45_JumpGame2` {

    @Test
    fun case1() {
        assertEquals(2, Solution().jump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun case2() {
        assertEquals(2, Solution().jump(intArrayOf(2, 3, 0, 1, 4)))
    }

    @Test
    fun case25() {
        assertEquals(3, Solution().jump(intArrayOf(1, 2, 3, 4, 5)))
    }

    class Solution {
        fun jump(nums: IntArray): Int {
            var count = 0
            var l = 0
            var r = 0

            for (i in 0 until nums.size - 1) {

                r = maxOf(nums[i] + i, r)

                if (i == l) {
                    l = r
                    count++
                }

            }
            return count
        }
    }
}

