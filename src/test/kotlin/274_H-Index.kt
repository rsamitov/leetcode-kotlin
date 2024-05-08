import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `274_H-Index` {

    @Test
    fun case1() {
        assertEquals(3, Solution().hIndex(intArrayOf(3, 0, 6, 1, 5)))
    }

    @Test
    fun case2() {
        assertEquals(1, Solution().hIndex(intArrayOf(1, 3, 1)))
    }

    class Solution {
        fun hIndex(citations: IntArray): Int {
            citations.sort()
            println(citations.asList())
            println(citations.indices.toList())

            var h = 0
            for (i in citations.indices) {
                val tmp = minOf(citations[i], citations.size - i)
                if(tmp < h) {
                    return h
                } else {
                    h = tmp
                }
            }
            return h
        }
    }
}

