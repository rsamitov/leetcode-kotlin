import kotlin.test.*

class `169_MajorityElement` {

    @Test
    fun case1() {
        val nums = intArrayOf(3, 2, 3)
        assertEquals(3, Solution().majorityElement(nums))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(2,2,1,1,1,2,2)
        assertEquals(2, Solution().majorityElement(nums))
    }


    class Solution {
        fun majorityElement(nums: IntArray): Int {
            val map = mutableMapOf<Int, Int>()
            val majority = nums.size / 2
            for (n in nums) {
                var count = map.getOrDefault(n, 0)
                count ++
                if (count > majority ) {
                    return n
                }
                map[n] = count
            }
            throw IllegalStateException("This never happens")
        }
    }
}

