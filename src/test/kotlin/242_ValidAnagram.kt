import kotlin.test.*

class `242_ValidAnagram` {

    @Test
    fun case1() {
        val s = "anagram"
        val t = "nagaram"
        assertTrue(Solution().isAnagram(s, t))
    }

    @Test
    fun case2() {
        val s = "rat"
        val t = "car"
        assertFalse(Solution().isAnagram(s, t))
    }

    class Solution {
        fun isAnagram(s: String, t: String): Boolean {
            val map = hashMapOf<Char, Int>()
            t.forEach { c ->
                map[c] = map.getOrDefault(c, 0) + 1
            }

            s.forEach { c ->
                val count = map.computeIfPresent(c) { _, v -> v - 1 }

                if (count == null) {
                    return false
                } else if (count == 0){
                    map.remove(c)
                }
            }
            return map.isEmpty()
        }
    }
}

