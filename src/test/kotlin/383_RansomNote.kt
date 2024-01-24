import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `383_RansomNote` {

    @Test
    fun case1() {
        val ransomNote = "a"
        val magazine = "b"
        assertFalse(Solution().canConstruct(ransomNote, magazine))
    }

    @Test
    fun case2() {
        val ransomNote = "aa"
        val magazine = "ab"
        assertFalse(Solution().canConstruct(ransomNote, magazine))
    }

    @Test
    fun case3() {
        val ransomNote = "aa"
        val magazine = "aab"
        assertTrue(Solution().canConstruct(ransomNote, magazine))
    }


    class Solution {
        fun canConstruct(ransomNote: String, magazine: String): Boolean {
            val magazineMap = HashMap<Char, Int>()

            for (c in magazine) {
                magazineMap[c] = magazineMap.getOrDefault(c, 0) + 1
            }

            for (c in ransomNote) {
                val count = magazineMap.getOrDefault(c, 0)
                if (count == 0) {
                    return false
                } else {
                    magazineMap[c] = count - 1
                }

            }
            return true
        }
    }
}


