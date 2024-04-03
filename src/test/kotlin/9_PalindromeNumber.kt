class `9_PalindromeNumber` {

    class Solution {
        fun isPalindrome(x: Int): Boolean {
            val str = x.toString()

            val length = str.length
            val lastIndex = length - 1
            for (i in 0..length / 2) {
                if (str[i] != str[lastIndex - i]) return false
            }
            return true
        }
    }
}

