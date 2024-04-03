class `530_MinimumAbsoluteDifferenceInBST` {


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
    class Solution {

        var current = -1
        var minDiff = Int.MAX_VALUE

        fun getMinimumDifference(root: TreeNode): Int {
            val left = root.left
            if (left != null) {
                minDiff = minOf(minDiff, getMinimumDifference(left))
            }
            if(minDiff == 1) return minDiff
            if (current != -1) {
                minDiff = minOf(minDiff, root.`val` - current)
            }
            if(minDiff == 1) return minDiff
            current = root.`val`

            val right = root.right
            if (right != null) {
                minDiff = minOf(minDiff, getMinimumDifference(right))
            }

            return minDiff
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

