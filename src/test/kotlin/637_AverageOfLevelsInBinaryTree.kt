import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.TreeMap
import kotlin.test.assertEquals

class `637_AverageOfLevelsInBinaryTree` {

    @Test
    fun case1() {
//        [3,9,20,null,null,15,7]

        val root = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }

        assertEquals(doubleArrayOf(3.0, 14.5, 11.0), Solution().averageOfLevels(root))
    }

    class Solution {
        fun averageOfLevels(root: TreeNode): DoubleArray {
            val queue = LinkedList<Pair<Int, TreeNode>>()
            val ans = LinkedList<Double>()
            queue.add(0 to root)

            var count = 0
            var sum : Long = 0
            var currentLevel = 0

            while(!queue.isEmpty()) {
                val pair = queue.remove()
                val level = pair.first
                val node = pair.second

                if(currentLevel == level) {
                    count++
                    sum += node.`val`
                } else {
                    ans.add(sum.toDouble().div(count))
                    sum = node.`val`.toLong()
                    count = 1
                    currentLevel = level
                }

                val left = node.left
                if(left != null) {
                    queue.add(level+1 to left)
                }

                val right = node.right
                if(right != null) {
                    queue.add(level+1 to right)
                }
            }

            ans.add(sum.toDouble().div(count))

            return ans.toDoubleArray()
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        override fun toString(): String {
            return "TreeNode(`val`=$`val`)"
        }


    }
}

