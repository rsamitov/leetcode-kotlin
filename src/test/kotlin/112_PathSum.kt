class `112_PathSum` {
    class Solution {
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {

            if (root == null) return false

            val newTargetSum = targetSum - root.`val`

            if (newTargetSum == 0
                && root.left == null
                && root.right == null) return true

            return hasPathSum(root.left, newTargetSum)
                    || hasPathSum(root.right, newTargetSum)

        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

