import kotlin.test.*

class `11_ContainerWithMostWater` {

    @Test
    fun case1() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        assertEquals(49, Solution().maxArea(height))
    }

    @Test
    fun case2() {
        val height = intArrayOf(1, 1)
        assertEquals(1, Solution().maxArea(height))
    }


    class Solution {
        fun maxArea(height: IntArray): Int {
            var left = 0
            var right = height.size - 1
            var max = 0

            while (left < right) {
                val minHeight = minOf(height[left], height[right])
                val current = (right - left) * minHeight
                max = maxOf(max, current)
                if (height[left] == minHeight) {
                    left++
                } else {
                    height[right]--
                }
            }
            return max
        }
    }
}

