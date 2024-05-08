import org.junit.jupiter.api.Test
import java.io.File
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class `380_InsertDeleteGetRandomOof1` {

    @Test
    fun case4() {
        val set = RandomizedSet()
        assertFalse(set.remove(0))
        assertFalse(set.remove(0))
        assertTrue(set.insert(0))
        assertEquals(0, set.getRandom())
        assertTrue(set.remove(0))
        assertTrue(set.insert(0))
    }

    @Test
    fun case16() {

        var actions = mutableListOf<String>()
        var args = mutableListOf<Int>()
        File("src/test/resources/actions.txt").forEachLine { actions.add(it) }
        File("src/test/resources/args.txt").forEachLine { args.add(it.toInt()) }
        val set = RandomizedSet()
        for ((i, action) in actions.withIndex()) {
            when (action) {
                "insert" -> set.insert(args[i])
                "remove" -> set.remove(args[i])
                "getRandom" -> set.getRandom()
            }
        }
    }

    class RandomizedSet() {

        val random = Random(System.currentTimeMillis())
        val address = mutableMapOf<Int, Int>()
        val list = mutableListOf<Int>()

        fun insert(`val`: Int): Boolean {
            if (address.containsKey(`val`)) {
                return false
            }
            address[`val`] = list.size
            return list.add(`val`)
        }

        fun remove(`val`: Int): Boolean {
            if (address.containsKey(`val`)) {
                val index = address.remove(`val`)!!
                if (address.isNotEmpty() && index < list.lastIndex) {
                    val last = list.last()
                    address[last] = index
                    list[index] = last
                }
                list.removeLast()
                return true
            }
            return false
        }

        fun getRandom(): Int {
            return list[random.nextInt(list.size)]
        }

    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * var obj = RandomizedSet()
     * var param_1 = obj.insert(`val`)
     * var param_2 = obj.remove(`val`)
     * var param_3 = obj.getRandom()
     */
}

