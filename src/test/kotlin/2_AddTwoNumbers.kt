import kotlin.test.*

class `2_AddTwoNumbers` {


    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var carry = 0
            val dummy = ListNode(-1)
            var digit1 = l1
            var digit2 = l2
            var previousSumDigit = dummy
            while (carry > 0 || digit1 != null || digit2 != null) {
                val sum = carry + (digit1?.`val` ?: 0) + (digit2?.`val` ?: 0)
                carry = sum / 10
                val digit = ListNode(sum % 10)
                previousSumDigit.next = digit
                previousSumDigit = digit
                digit1 = digit1?.next
                digit2 = digit2?.next

            }
            return dummy.next
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

