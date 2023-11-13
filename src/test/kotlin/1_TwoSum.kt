import kotlin.test.*

class `1_TwoSum` {

    @Test
    fun case1() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        assertContentEquals(Solution().twoSum(nums, target), intArrayOf(0, 1))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        assertContentEquals(Solution().twoSum(nums, target), intArrayOf(1, 2))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(3, 3)
        val target = 6
        assertContentEquals(Solution().twoSum(nums, target), intArrayOf(0, 1))
    }

    @Test
    fun case36() {
        val nums = intArrayOf(0, 4, 3, 0)
        val target = 0
        assertContentEquals(Solution().twoSum(nums, target), intArrayOf(0, 3))
    }

    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val map = hashMapOf<Int, Int>()
            for ((indexOfSecond, num) in nums.asIterable().withIndex()) {
                val indexOfFirst: Int? = map[target - num]
                if (indexOfFirst == null) {
                    map[num] = indexOfSecond
                } else {
                    return intArrayOf(indexOfFirst, indexOfSecond)
                }
            }
            return intArrayOf()
        }
    }
}

