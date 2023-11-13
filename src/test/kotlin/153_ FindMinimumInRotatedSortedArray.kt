import kotlin.test.*

class `153_ FindMinimumInRotatedSortedArray` {

    @Test
    fun case1() {
        val nums = intArrayOf(3, 4, 5, 1, 2)
        assertEquals(1, Solution().findMin(nums))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        assertEquals(0, Solution().findMin(nums))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(11, 13, 15, 17)
        assertEquals(11, Solution().findMin(nums))
    }

    @Test
    fun case5() {
        val nums = intArrayOf(2, 1)
        assertEquals(1, Solution().findMin(nums))
    }

    @Test
    fun case120() {
        val nums = intArrayOf(4, 5, 1, 2, 3)
        assertEquals(1, Solution().findMin(nums))
    }

    @Test
    fun case14() {
        val nums = intArrayOf(2,3,4,5,6,1)
        assertEquals(1, Solution().findMin(nums))
    }

    class Solution {
        fun findMin(nums: IntArray): Int {
            var start = 0
            var end = nums.size - 1

            while (nums[start] > nums[end]) {
                val mid = (start + end) / 2
                if (nums[start] > nums[mid]) {
                    start += 1
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return nums[start]
        }
    }
}

