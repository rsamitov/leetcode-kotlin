import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `134_GasStation` {

    @Test
    fun case1() {
        assertEquals(
            3, Solution().canCompleteCircuit(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(3, 4, 5, 1, 2)
            )
        )
    }

    @Test
    fun case30() {
        assertEquals(
            0, Solution().canCompleteCircuit(
                intArrayOf(3,1,1),
                intArrayOf(1,2,2)
            )
        )
    }

    @Test
    fun case39() {
        assertEquals(
            0, Solution().canCompleteCircuit(
                intArrayOf(2,0,0),
                intArrayOf(0,1,0)
            )
        )
    }


    class Solution {
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            var sum = 0
            var indexOfMin = 0
            var min = Int.MAX_VALUE

            for (i in gas.indices) {
                sum += gas[i]
                sum -= cost[i]

                if (min >= sum) {
                    min = sum
                    indexOfMin = i
                }
            }

            if (sum < 0) {
                return -1
            } else {
                return ++ indexOfMin % gas.size
            }
        }
    }
}

