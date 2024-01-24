import java.util.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `101_SymmetricTree` {

    @Test
    fun case1() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left!!.left = TreeNode(3)
        root.left!!.right = TreeNode(4)
        root.right!!.left = TreeNode(4)
        root.right!!.right = TreeNode(3)
        assertTrue(Solution().isSymmetric(root))
    }


    @Test
    fun case2() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left!!.right = TreeNode(3)
        root.right!!.right = TreeNode(3)
        assertFalse(Solution().isSymmetric(root))
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
    class Solution {
        fun isSymmetric(root: TreeNode?): Boolean {
            if (root == null) {
                return true
            }

            val left: Queue<TreeNode> = LinkedList()
            val right: Queue<TreeNode> = LinkedList()

            left.add(root.left)
            right.add(root.right)

            while (left.isNotEmpty() || right.isNotEmpty()) {
                if (left.size != right.size) {
                    return false
                }

                val currentLeft = left.remove()
                val currentRight = right.remove()
                if (currentLeft != null) {
                    left.add(currentLeft.left)
                    left.add(currentLeft.right)
                }
                if (currentRight != null) {
                    right.add(currentRight.right)
                    right.add(currentRight.left)
                }

                if (currentRight?.`val` != currentLeft?.`val`) {
                    return false
                }
            }
            return true
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

