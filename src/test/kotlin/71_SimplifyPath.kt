import org.junit.jupiter.api.Test
import java.util.Stack
import kotlin.math.max
import kotlin.test.*

class `71_SimplifyPath` {


    class Solution {
        fun simplifyPath(path: String): String {

            val stack = ArrayDeque<String>()
            for (str in path.split("/")) {
                when {
                    str == "." || str.isEmpty() -> {}
                    str == ".." -> if (!stack.isEmpty()) stack.removeLast()
                    else -> stack.addLast(str)
                }
            }

            return stack.joinToString(separator = "/", prefix = "/")
        }
    }
}

