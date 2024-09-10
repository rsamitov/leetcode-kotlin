import kotlin.test.*

class `73_SetMatrixZeroes` {

    class Solution {
        fun setZeroes(matrix: Array<IntArray>): Unit {
            val col = mutableListOf<Int>()
            val row = mutableListOf<Int>()

            for (m in matrix.indices) {
                for (n in matrix[m].indices)
                {
                    if(matrix[m][n] == 0) {
                        row.add(m)
                        col.add(n)
                    }
                }
            }

            for (m in row) {
                for (n in matrix[m].indices) {
                    matrix[m][n] = 0
                }
            }

            for (n in col) {
                for (m in matrix.indices) {
                    matrix[m][n] = 0
                }
            }
        }
    }

}

