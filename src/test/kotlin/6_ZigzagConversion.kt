import kotlin.test.*

class `6_ZigzagConversion` {

    @Test
    fun case1() {
        assertEquals("PAHNAPLSIIGYIR", Solution().convert("PAYPALISHIRING", 3))
    }

    @Test
    fun case2() {
        assertEquals("PINALSIGYAHRPI", Solution().convert("PAYPALISHIRING", 4))
    }

    @Test
    fun caseMine() {
        assertEquals("1524637", Solution().convert("1234567", 3))
    }


    class Solution {
        fun convert(s: String, numRows: Int): String {

            if(numRows == 1) return s

            val lines = Array(numRows) { StringBuilder() }

            var lineIndex = 0

            var isDown = true
            for (ch in s.toCharArray()) {
                lines[lineIndex].append(ch)

                if (isDown) {
                    lineIndex++
                } else {
                    lineIndex--
                }

                if(lineIndex == 0 || lineIndex == numRows-1) {
                    isDown = ! isDown
                }
            }

            return lines.joinToString(separator = "")
        }
    }
}

