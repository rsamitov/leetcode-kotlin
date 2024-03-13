import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `290_WordPattern` {

    @Test
    fun case1() {
        val pattern = "abba"
        val s = "dog cat cat dog"
        assertTrue(Solution().wordPattern(pattern, s))
    }

    @Test
    fun case2() {
        val pattern = "abba"
        val s = "dog cat cat fish"
        assertFalse(Solution().wordPattern(pattern, s))
    }

    @Test
    fun case3() {
        val pattern = "aaaa"
        val s = "dog cat cat dog"
        assertFalse(Solution().wordPattern(pattern, s))
    }


    class Solution {
        fun wordPattern(pattern: String, s: String): Boolean {
            val words = s.split(' ')

            if (pattern.length != words.size) {
                return false
            }

            val patternToWord = hashMapOf<Char, String>()
            val wordToPattern = hashMapOf<String, Char>()
            for ((i, word) in words.withIndex()) {

                if (!patternToWord.contains(pattern[i]) &&
                    !wordToPattern.contains(word)) {
                    patternToWord[pattern[i]] = word
                    wordToPattern[word] = pattern[i]
                } else if (patternToWord[pattern[i]] != word ||
                    wordToPattern[word] != pattern[i]) {
                    return false
                }
            }
            return true
        }
    }
}

