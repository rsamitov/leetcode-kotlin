import java.util.*
import kotlin.test.Test
import kotlin.test.assertContentEquals

class `228_SummaryRanges` {

    @Test
    fun case1() {
        val nums = intArrayOf(0, 1, 2, 4, 5, 7)
        assertContentEquals(
            listOf("0->2", "4->5", "7"),
            Solution().summaryRanges(nums)
        )
    }

    @Test
    fun case2() {
        val nums = intArrayOf(0, 2, 3, 4, 6, 8, 9)
        assertContentEquals(
            listOf("0", "2->4", "6", "8->9"),
            Solution().summaryRanges(nums)
        )
    }


    @Test
    fun case31() {
        val nums = intArrayOf(-2147483648, -2147483647, 2147483647)
        assertContentEquals(
            listOf("-2147483648->-2147483647", "2147483647"),
            Solution().summaryRanges(nums)
        )
    }

    class Solution {
        fun summaryRanges(nums: IntArray): List<String> {
            val ans = LinkedList<String>()

            if (nums.isNotEmpty()) {
                var start = nums[0]
                var end = start

                val record = {
                    if (start == end) {
                        ans.add("$start")
                    } else {
                        ans.add("$start->$end")
                    }
                }

                for (num in nums) {
                    val expectedNext = end + 1
                    if (expectedNext == num) {
                        end = num
                    } else if (expectedNext < num) {
                        //record and start new
                        record()
                        start = num
                        end = num
                    }
                }
                record()
            }

            return ans
        }
    }
}


