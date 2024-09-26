import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.*

class `452_MinimumNumberOfArrowsToBurstBalloons` {


    class Solution {
        fun findMinArrowShots(points: Array<IntArray>): Int {

            if (points.isEmpty()) return 0

            points.sortWith { x, y -> x[0].compareTo(y[0]) }
            var counter = 1
            var curr = points[0]
            for (i in 1 until points.size) {
                if (curr[1] < points[i][0]) {
                    counter++
                    curr = points[i]
                } else {
                    curr[0] = minOf(curr[0], points[i][0])
                    curr[1] = minOf(curr[1], points[i][1])
                }
            }

            return counter
        }
    }
}

