import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `217_ContainsDuplicate` {

    @Test
    fun case1() {
        val nums = intArrayOf(1,2,3,1)
        assertTrue(Solution().containsDuplicate(nums))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1,2,3,4)
        assertFalse(Solution().containsDuplicate(nums))
    }
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            println(nums.size)
            println(hashSetOf(nums).size)
            return nums.toSet().size != nums.size
        }
    }
}

