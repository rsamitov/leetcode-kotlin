import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `122_BestTimeToBuyAndSellStock2` {

    @Test
    fun case1() {
        assertEquals(7, Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    class Solution {
        fun maxProfit(prices: IntArray): Int {
            var ans = 0

            var buy = Int.MAX_VALUE

            for (i in prices.indices) {
                if (buy != Int.MAX_VALUE && prices[i - 1] > prices[i]) {
//                    println("sell ${prices[i - 1]}")
                    ans += prices[i - 1] - buy
                    buy = prices[i]
//                    println("buy ${prices[i]}")
                }
                if (buy > prices[i]) {
                    buy = prices[i]
//                    println("buy ${prices[i]}")
                }
            }
            if (prices[prices.lastIndex] > buy) {
                ans += prices[prices.lastIndex] - buy
            }
            return ans

        }
    }
}

