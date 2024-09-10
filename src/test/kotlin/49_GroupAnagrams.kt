import org.junit.jupiter.api.Test
import kotlin.test.*

class `49_GroupAnagrams` {


    @Test
    fun case1() {
        assertContentEquals(
            listOf(
                listOf("bat"),
                listOf("nat","tan"),
                listOf("ate","eat","tea")
            ),
            Solution().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
        )
    }


    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {

            val map = HashMap<Int, MutableList<String>>()

            for (str in strs) {
                val array = IntArray(26){0}
                for (c in str) {
                    array[c.code-97]+=1
                }
                val key = array.contentHashCode()
                if (map.contains(key)) {
                    map[key]!!.add(str)
                } else {
                    map[key] = mutableListOf(str)
                }
            }

            return map.values.toList()
        }
    }


}

