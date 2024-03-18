import kotlin.test.Test
import kotlin.test.assertNotNull

class `108_ConvertSortedArrayToBinarySearchTree` {

    @Test
    fun case1() {
        val nums = intArrayOf(-10, -3, 0, 5, 9)
        assertNotNull(Solution().sortedArrayToBST(nums))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 3)
        assertNotNull(Solution().sortedArrayToBST(nums))
    }


    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    class Solution {
        fun sortedArrayToBST(nums: IntArray): TreeNode? {
            if (nums.size == 1) {
                return TreeNode(nums[0])
            } else if (nums.isEmpty()) {
                return null
            } else {
                val i = nums.size / 2
                return TreeNode(nums[i]).apply {
                    left = sortedArrayToBST(nums.copyOfRange(0, i))
                    right = sortedArrayToBST(nums.copyOfRange(i + 1, nums.size))
                }
            }
        }
    }
}

