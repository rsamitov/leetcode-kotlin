import kotlin.test.Test
import kotlin.test.assertEquals

class `121_ BestTimeToBuyAndSellStock` {

    @Test
    fun case1() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        assertEquals(5, Solution().maxProfit(prices))
    }

    @Test
    fun case2() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        assertEquals(0, Solution().maxProfit(prices))
    }

    @Test
    fun case91() {
        val prices = intArrayOf(1, 4, 2)
        assertEquals(3, Solution().maxProfit(prices))
    }

    @Test
    fun case16() {
        val prices = intArrayOf(6, 1, 3, 2, 4, 7)
        assertEquals(6, Solution().maxProfit(prices))
    }

    @Test
    fun case156() {
        val prices = intArrayOf(2, 1, 4)
        assertEquals(3, Solution().maxProfit(prices))
    }

    @Test
    fun case192() {
        val prices = intArrayOf(2, 1, 2, 1, 0, 1, 2)
        assertEquals(2, Solution().maxProfit(prices))
    }

    class Solution {
        fun maxProfit(prices: IntArray): Int {

            var buy = 0
            var sell = 1
            var maxProfit = 0

            while (sell < prices.size) {
                val current = prices[sell] - prices[buy]
                maxProfit = maxOf(maxProfit, current)
                if (current < 0) {
                    buy = sell
                }

                sell ++
            }

            return maxProfit
        }
    }
}

