import kotlin.test.Test
import kotlin.test.assertEquals

class `209_MinimumSizeSubarraySum` {

    @Test
    fun case1() {
        val nums = intArrayOf(2, 3, 1, 2, 4, 3)
        val target = 7
        assertEquals(2, Solution().minSubArrayLen(target, nums))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 4, 4)
        val target = 4
        assertEquals(1, Solution().minSubArrayLen(target, nums))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)
        val target = 11
        assertEquals(0, Solution().minSubArrayLen(target, nums))
    }

    class Solution {
        fun minSubArrayLen(target: Int, nums: IntArray): Int {

            var start = 0
            var end = 0
            var min = Int.MAX_VALUE
            var currentSum = nums[end]
            while (true) {
                if (target == nums[end]) {
                    return 1
                }

                if (currentSum < target) {
                    end++
                    if( end < nums.size){
                        currentSum += nums[end];
                    } else {
                        break
                    }
                } else {
                    min = minOf(min, end - start)
                    currentSum -= nums[start]
                    start++
                }
            }

            if (min == Int.MAX_VALUE) {
                return 0
            } else {
                return min + 1
            }
        }
    }
}

