class `35_SearchInsertPosition` {


    class Solution {
        fun searchInsert(nums: IntArray, target: Int): Int {
            var b = 0
            var e = nums.size-1
            if (target <= nums[b]) return 0
            if (target > nums[e]) return e + 1

            while(true) {
                val m = (b+e)/2
                if (nums[m] == target) return m
                else if (target in nums[b]..<nums[m]) {
                    e = m
                } else {
                    b = m
                }
                if (e-b == 1) {
                    return e
                }
            }
        }
    }}

