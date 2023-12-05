import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class `27_RemoveElement` {

    @Test
    fun case1() {
        val nums1 = intArrayOf(3,2,2,3)
        val `val` = 3
        val k = Solution().removeElement(nums1, `val`)
        assertEquals(2, k)
        assertContentEquals(intArrayOf(2, 2), nums1.copyOfRange(0, k) )
    }

    @Test
    fun case2() {
        val nums1 = intArrayOf(0,1,2,2,3,0,4,2)
        val `val` = 2
        val k = Solution().removeElement(nums1, `val`)
        assertEquals(5, k)
        // this should be in any order
        assertContentEquals(intArrayOf(0,1,3,0,4), nums1.copyOfRange(0, k) )
    }


    class Solution {
        fun removeElement(nums: IntArray, `val`: Int): Int {
            var k = 0
            for (i in nums.indices) {
                if (nums[i] == `val`) {
                    k++
                } else {
                    nums[i-k] = nums[i]
                }
            }

            return nums.size - k
        }
    }
}

