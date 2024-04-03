import org.junit.jupiter.api.Test
import kotlin.math.sqrt
import kotlin.test.assertEquals

class `69_SqrtX` {

    @Test
    fun case2() {
        assertEquals(2, Solution().mySqrt(8))
    }

    @Test
    fun case1015() {
        assertEquals(46340, Solution().mySqrt(2147395600))
    }

    class Solution {

        fun mySqrt(x: Int): Int {
            if (x == 0) return 0

            var l = 0L
            var r = x.toLong()

            while (l <= r ) {
                val m = (l + r) / 2

                val sq = m * m
                println("$l<$m<$r $sq <> $x")

                if (sq < x) {
                    l = m+1
                } else if (sq > x) {
                    r = m-1
                } else return m.toInt()

            }
            return r.toInt()
        }

    }
}

