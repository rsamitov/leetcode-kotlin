import kotlin.test.*

class `15_3Sum` {
    @Test
    fun case1() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        assertContentEquals(listOf(listOf(-1, -1, 2),
                listOf(-1, 0, 1)),
                Solution().threeSum(nums))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(0, 1, 1)
        assertContentEquals(listOf(),
                Solution().threeSum(nums))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(0, 0, 0)
        assertContentEquals(listOf(listOf(0, 0, 0)), Solution().threeSum(nums))
    }

    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            nums.sort()
            var first = 0

            while (first < nums.size - 2) {
                var second = first + 1
                var third = nums.size - 1
                val target = 0 - nums[first]
                while (second < third) {
                    val sum = nums[second] + nums[third]
                    if (sum == target) {
                        result.add(listOf(nums[first], nums[second], nums[third]))
                        second++
                        third = nums.size - 1
                        while (second < third && nums[second] == nums[second - 1]) {
                            second++
                        }
                    } else if (sum > target) {
                        third--
                    } else {
                        second++
                    }
                }
                first++
                while (first < nums.size -1 && nums[first] == nums[first - 1]) {
                    first++
                }
            }
            return result
        }
    }
}

