import kotlin.test.Test
import kotlin.test.assertEquals

class `151_ReverseWordsInAString` {

    @Test
    fun case1() {
//        assertEquals("MMMDCCXLIX", Solution().intToRoman(3749))
    }


    class Solution {
        fun reverseWords(s: String): String {
            val trimmed = s.trim()

            if (trimmed.length < 3 || !trimmed.contains(" "))
                return trimmed

            var start = s.lastIndex
            var end = start

            val sb = StringBuilder()

            for(i in s.lastIndex downTo 0) {
                if (s[i] == ' ') {
                    sb.append(trimmed.substring(start, end))
                    start = i
                    end = i
                }
                else {
                    start = i
                }
            }
            return sb.toString()

//            return s.split(" ")
//                .filter { it.isNotEmpty() }
//                .reversed()
//                .joinToString(" ")
        }
    }
}

