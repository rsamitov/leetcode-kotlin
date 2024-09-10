import org.junit.jupiter.api.Test
import kotlin.test.*

class `289_GameOfLife` {


    @Test
    fun case1() {
        val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        )

        Solution().gameOfLife(board)

        assertEquals(
            arrayOf(
                intArrayOf(0,0,0),
                intArrayOf(1,0,1),
                intArrayOf(0,1,1),
                intArrayOf(0,1,0),
            ),
            board)
    }



    class Solution {
        fun gameOfLife(board: Array<IntArray>): Unit {
            val visited = HashSet<Pair<Int, Int>> ()
            compute(board, 0, 0, visited)
        }

        private fun compute(board: Array<IntArray>, row: Int, col: Int, visited: HashSet<Pair<Int, Int>>): Unit {
            // add itself
            val self = row to col
            if(visited.contains(self)) {
                return
            } else {
                visited.add(self)
            }

            val rows = range(row, board.lastIndex)
            val cols = range(col, board[0].lastIndex)

            val neighbours = HashSet<Pair<Int, Int>>()
            var live = 0
            // apply rule
            for (i in rows) {
                for (j in cols) {
                    if(i != row || j != col) {
                        val element = i to j
                        if (!visited.contains(element)) {
                            neighbours.add(i to j)
                        }
                        if (board[i][j] == 1) {
                            live++
                        }
                    }
                }
            }

            val next = when (board[row][col]) {
                0 -> when (live) {
                    3 -> 1
                    else -> 0
                }
                else -> when(live) {
                    2, 3 -> 1
                    else -> 0
                }
            }

            // do each neighbour
            for (pair in neighbours) {
                compute(board, pair.first, pair.second, visited)
            }

            board[row][col] = next
        }

        private fun range(i: Int, max: Int): IntRange {
            return maxOf(0, i - 1) .. minOf(max, i + 1)
        }

    }
}

