import kotlin.test.*

class `80_RemoveDuplicatesFromSortedArrayII` {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val k = Solution().removeDuplicates(nums)
        assertEquals(5, k)
        assertContentEquals(intArrayOf(1, 1, 2, 2, 3), nums.copyOfRange(0, k))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val k = Solution().removeDuplicates(nums)
        assertEquals(7, k)
        assertContentEquals(intArrayOf(0, 0, 1, 1, 2, 3, 3), nums.copyOfRange(0, k))
    }


    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            if (nums.size <= 2) {
                return nums.size
            }

            var k = 1
            for (i in 2 until nums.size) {
                nums[k + 1] = nums[i]

                if (nums[k - 1] != nums[k]
                    || nums[k] != nums[i]) {
                    k++
                }
            }
            return k + 1
        }
    }
}

