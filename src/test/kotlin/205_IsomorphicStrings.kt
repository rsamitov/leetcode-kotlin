import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `205_IsomorphicStrings` {

    @Test
    fun case1() {
        val s = "egg"
        val t = "add"
        assertTrue(Solution().isIsomorphic(s, t))
    }

    @Test
    fun case2() {
        val s = "foo"
        val t = "bar"
        assertFalse(Solution().isIsomorphic(s, t))
    }

    @Test
    fun case3() {
        val s = "paper"
        val t = "title"
        assertTrue(Solution().isIsomorphic(s, t))
    }


    class Solution {
        fun isIsomorphic(s: String, t: String): Boolean {

            if (s.length != t.length) {
                return false
            }

            val sToT = hashMapOf<Char, Char>()
            val tToS = hashMapOf<Char, Char>()

            for (i in s.indices) {

                val previousT = sToT.put(s[i], t[i])
                val previousS = tToS.put(t[i], s[i])

                if(previousS == null && previousT == null)
                    continue
                else if (previousT != t[i] || previousS != s[i])
                    return false
            }
            return true
        }
    }
}

