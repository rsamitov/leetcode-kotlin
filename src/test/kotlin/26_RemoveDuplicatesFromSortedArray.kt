import kotlin.test.*

class `26_RemoveDuplicatesFromSortedArray` {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 1, 2)
        val k = Solution().removeDuplicates(nums)
        assertEquals(2, k)
        assertContentEquals(intArrayOf(1, 2), nums.copyOfRange(0, k))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        val k = Solution().removeDuplicates(nums)
        assertEquals(5, k)
        assertContentEquals(intArrayOf(0,1,2,3,4), nums.copyOfRange(0, k))
    }


    class Solution {

        fun removeDuplicates(nums: IntArray): Int {
            var k = 0
            for (i in 1 until nums.size) {

                if (nums[k] != nums[i]) {
                    k++
                    nums[k] = nums[i]
                }
            }
            return k + 1
        }
    }
}

