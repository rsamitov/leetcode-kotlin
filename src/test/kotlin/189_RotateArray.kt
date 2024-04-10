import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class `189_RotateArray` {

    @Test
    fun case2() {
        val nums = intArrayOf(-1, -100, 3, 99)
        Solution().rotate(nums, 2)
        assertEquals(intArrayOf(3, 99, -1, -100), nums)
    }

    class Solution {
        fun rotate(nums: IntArray, k: Int) {

            val queue = LinkedList<Int>()

            for (i in nums.size - (k % nums.size) until nums.size) {
                queue.add(nums[i])
            }

            for (i in nums.indices) {
                queue.add(nums[i])
                nums[i] = queue.remove()
            }
        }
    }
}

