class `136_SingleNumber` {


    class Solution {
        fun singleNumber(nums: IntArray): Int {
            var ans = 0

            for(n in nums) {
                ans = ans.xor(n)
            }
            return ans
        }
    }
}

