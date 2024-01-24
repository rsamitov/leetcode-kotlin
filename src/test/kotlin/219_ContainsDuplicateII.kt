import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `219_ContainsDuplicateII` {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 2, 3, 1)
        val k = 3
        assertTrue(Solution().containsNearbyDuplicate(nums, k))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 0, 1, 1)
        val k = 1
        assertTrue(Solution().containsNearbyDuplicate(nums, k))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1, 2, 3, 1, 2, 3)
        val k = 2
        assertFalse(Solution().containsNearbyDuplicate(nums, k))
    }


    class Solution {
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {

            if (k == 0) {
                return false
            }

            val set = HashSet<Int>(k)

            for (i in 0..<nums.size) {
                val currentNum = nums[i]
                if (!set.add(currentNum)) {
                    return true
                }
                if (i >= k) {
                    set.remove(nums[i - k])
                }
            }
            return false
        }
    }
}


