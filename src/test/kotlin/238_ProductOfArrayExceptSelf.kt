import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `238_ProductOfArrayExceptSelf` {

    @Test
    fun case1() {
        assertEquals(intArrayOf(24, 12, 8, 6), Solution().productExceptSelf(intArrayOf(1, 2, 3, 4)))
    }


    class Solution {
        fun productExceptSelf(nums: IntArray): IntArray {
            val last = nums.lastIndex
            val ans = IntArray(nums.size) { 1 }
            var left = 1
            var right = 1

            for (i in nums.indices) {
                ans[i] *= left
                ans[last - i] *= right

                left *= nums[i]
                right *= nums[last - i]
            }

            return ans
        }
    }
}

