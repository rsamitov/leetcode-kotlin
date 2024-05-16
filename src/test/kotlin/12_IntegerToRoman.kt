import kotlin.test.Test
import kotlin.test.assertEquals

class `12_IntegerToRoman` {

    @Test
    fun case1() {
        assertEquals("MMMDCCXLIX", Solution().intToRoman(3749))
    }


    class Solution {
        val map = linkedMapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )

        fun intToRoman(num: Int): String {
            if (num == 0) return ""

            if (map.containsKey(num)) return map[num]!!

            for ((k, v) in map) {
                val i = num / k
                if (i > 0) {
                    map.remove(k)
                    return v.repeat(i) + intToRoman(num - k*i)
                }
            }
            throw IllegalStateException("cant reach this")
        }
    }
}

