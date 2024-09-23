import org.junit.jupiter.api.Test
import kotlin.test.*

class `56_MergeIntervals` {


    class Solution {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            if (intervals.isEmpty()) return intervals

            intervals.sortWith { x, y -> x[0].compareTo(y[0]) }

            val result = mutableListOf<IntArray>()
            var curr = intervals.first()
            for (interval in intervals) {
                // current end > interval start
                // merge
                if (curr[1] >= interval[0]) {
                    curr[1] = maxOf(curr[1], interval[1])
                }
                //create new
                else {
                    result.add(curr)
                    curr = interval
                }
            }
            result.add(curr)
            return result.toTypedArray()
        }
    }
}

