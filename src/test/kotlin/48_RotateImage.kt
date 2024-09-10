import java.util.LinkedList
import kotlin.test.*

class `48_RotateImage` {

    @Test
    fun case1() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        matrix.forEach { println(it.contentToString()) }

        println()
        Solution().rotate(matrix)
        matrix.forEach { println(it.contentToString()) }

        assertTrue(
            arrayOf(
                intArrayOf(13, 9, 5, 1),
                intArrayOf(14, 10, 6, 2),
                intArrayOf(15, 11, 7, 3),
                intArrayOf(16, 12, 8, 4)
            )
           .contentDeepEquals(matrix)
        )
    }

    class Solution {
        fun rotate(matrix: Array<IntArray>): Unit {
            for (first in 0 until matrix.size / 2) {
                val last = matrix.lastIndex - first
                for (i in first until last) {
                    val j = matrix.lastIndex - i
                    val a = matrix[first][i]
                    matrix[first][i] = matrix[j][first]
                    matrix[j][first] = matrix[last][j]
                    matrix[last][j] = matrix[i][last]
                    matrix[i][last] = a
                }
            }
        }
    }
}

