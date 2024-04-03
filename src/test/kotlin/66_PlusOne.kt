import java.util.LinkedList

class `66_PlusOne` {

    class Solution {
        fun plusOne(digits: IntArray): IntArray {
            for(i in digits.size-1 downTo 0) {
                if(digits[i] < 9) {
                    digits[i]++
                    return digits
                } else {
                    digits[i] = 0
                }
            }
            val ans = IntArray(1 + digits.size)
            ans[0]=1
            return ans
        }
    }}

