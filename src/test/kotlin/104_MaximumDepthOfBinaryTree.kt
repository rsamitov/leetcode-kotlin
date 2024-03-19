import kotlin.math.max

class `104_MaximumDepthOfBinaryTree` {

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
        fun maxDepth(root: TreeNode?): Int {
            if (root == null) return 0
            else return 1 + max(
                maxDepth(root.left),
                maxDepth(root.right)
            )
        }

    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}

