import kotlin.test.*

class `167_TwoSumII` {

    @Test
    fun case1() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        assertContentEquals(Solution().twoSum(nums, target), intArrayOf(1, 2))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(2, 3, 4)
        val target = 6
        assertContentEquals(Solution().twoSum(nums, target), intArrayOf(1, 3))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(-1, 0)
        val target = -1
        assertContentEquals(Solution().twoSum(nums, target), intArrayOf(1, 2))
    }

    class Solution {
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            var left = 0
            var right = numbers.size - 1
            while (left < right) {
                val sum = numbers[left] + numbers[right]
                if (sum == target) {
                    return intArrayOf(left + 1, right + 1)
                } else if (sum > target) {
                    right--
                } else {
                    left++
                }
            }
            throw IllegalArgumentException("this never happens")
        }
    }
}

