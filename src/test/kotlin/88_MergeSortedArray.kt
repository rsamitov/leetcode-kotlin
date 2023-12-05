import kotlin.test.*

class `88_MergeSortedArray` {

    @Test
    fun case1() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(2, 5, 6)
        val n = 3
        Solution().merge(nums1, m, nums2, n)
        assertContentEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)
    }

    @Test
    fun case2() {
        val nums1 = intArrayOf(1)
        val m = 1
        val nums2 = intArrayOf()
        val n = 0
        Solution().merge(nums1, m, nums2, n)
        assertContentEquals(intArrayOf(1), nums1)
    }

    @Test
    fun case3() {
        val nums1 = intArrayOf(0)
        val m = 0
        val nums2 = intArrayOf(1)
        val n = 1
        Solution().merge(nums1, m, nums2, n)
        assertContentEquals(intArrayOf(1), nums1)
    }

    @Test
    fun case16() {
        val nums1 = intArrayOf(4, 5, 6, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(1, 2, 3)
        val n = 3
        Solution().merge(nums1, m, nums2, n)
        assertContentEquals(intArrayOf(1, 2, 3, 4, 5, 6), nums1)
    }

    class Solution {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

            if (n == 0) {
                return
            }
            var i = m - 1
            var j = n - 1
            var k = nums1.size - 1

            while (j >= 0) {
                if (i == -1 || nums1[i] < nums2[j]) {
                    nums1[k] = nums2[j]
                    j--
                } else {
                    nums1[k] = nums1[i]
                    nums1[i] = 0
                    i--
                }
                k--
            }
        }
    }
}

