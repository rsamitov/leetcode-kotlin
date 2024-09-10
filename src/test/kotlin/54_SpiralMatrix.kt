import java.util.LinkedList
import kotlin.test.*

class `54_SpiralMatrix` {

    @Test
    fun case1() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        assertContentEquals(
            listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
            Solution().spiralOrder(matrix)
        )
    }

    class Solution {
        fun spiralOrder(matrix: Array<IntArray>): List<Int> {

            var topRow = 0
            var leftColumn = 0
            var rightColumn = matrix[topRow].lastIndex
            var bottomRow = matrix.lastIndex

            val res = LinkedList<Int>()

            while (true) {
                //move left to right
                for (i in leftColumn..rightColumn) {
                    res.add(matrix[topRow][i])
                }
                topRow++
                if (topRow > bottomRow) break

                //move top to bottom
                for (i in topRow..bottomRow) {
                    res.add(matrix[i][rightColumn])
                }
                rightColumn--
                if (leftColumn > rightColumn) break

                //move right to left
                for (i in rightColumn downTo leftColumn) {
                    res.add(matrix[bottomRow][i])
                }
                bottomRow--
                if (topRow > bottomRow) break
                //move bottom to up
                for (i in bottomRow downTo topRow) {
                    res.add(matrix[i][leftColumn])
                }
                leftColumn++
                if (leftColumn > rightColumn) break
            }
            return res
        }
    }
}

