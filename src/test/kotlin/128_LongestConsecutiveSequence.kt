import org.junit.jupiter.api.Test
import kotlin.test.*

class `128_LongestConsecutiveSequence` {


    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            var result = 0
            val map = mutableMapOf<Int, Int>()

            for (num in nums) {

                if (!map.contains(num)) {
                    var count = map.getOrDefault(num + 1, 0) + 1
                    map[num] = count
                    result = maxOf(result, count)

                    var prev = num - 1
                    while (map.contains(prev)) {
                        count++
                        result = maxOf(result, count)
                        map[prev] = count
                        prev--
                    }
                }
            }

            return result
        }
    }

}

