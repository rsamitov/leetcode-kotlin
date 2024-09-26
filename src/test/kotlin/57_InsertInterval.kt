import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.*

class `57_InsertInterval` {


    class Solution {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val result = mutableListOf<IntArray>()
            var add = true
            for (interval in intervals) {
                // interval doesn't overlap
                if (interval[0] > newInterval[1]) {
                    if (add) {
                        result.add(newInterval)
                        add = false
                    }
                    result.add(interval)
                } else if (interval[1] < newInterval[0]) {
                    result.add(interval)
                } else {
                    if (add) {
                        result.add(newInterval)
                        add = false
                    }
                    newInterval[0] = minOf(newInterval[0], interval[0])
                    newInterval[1] = maxOf(newInterval[1], interval[1])
                }
            }
            if (add) {
                result.add(newInterval)
            }
            return result.toTypedArray()
        }
    }
}

