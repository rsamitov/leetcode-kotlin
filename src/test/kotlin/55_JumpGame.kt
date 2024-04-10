import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.assertFalse

class `55_JumpGame` {

    @Test
    fun case2() {
        assertFalse(Solution().canJump(intArrayOf(1,1,2,2,0,1,1)))
    }

    class Solution {
        fun canJump(nums: IntArray): Boolean {
            if (nums.size == 1) return true

            println(nums.toList())
            println((0 .. nums.lastIndex).toList())

            var i = 0
            var max = nums[i]

            while (i < nums.size) {
                println("at ${nums[i]} max jump is $max")

                if (max >= nums.lastIndex) return true
                if (max == i) return false
                i ++
                max = max(max, i + nums[i])
            }
            return false
        }
    }
}

