import kotlin.test.*

class `36_ValidSudoku` {

    @Test
    fun case1() {
        val board = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        assertTrue(Solution().isValidSudoku(board))
    }

    @Test
    fun case2() {
        val board = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        assertFalse(Solution().isValidSudoku(board))
    }

    class Solution {
        fun isValidSudoku(board: Array<CharArray>): Boolean {

            val rows = Array(9) { hashSetOf<Char>() }
            val cols = Array(9) { hashSetOf<Char>() }
            val subs = Array(9) { hashSetOf<Char>() }
            for (row in 0 .. 8) {
                for (col in 0 .. 8){
                    val num = board[row][col]
                    if( num != '.' && (! rows[row].add(num)
                        || ! cols[col].add(num)
                        || ! subs[row/3+3*(col/3)].add(num))){
                        return false
                    }
                }
            }
            return true
        }
    }
}

