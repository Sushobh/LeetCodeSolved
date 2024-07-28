
//https://leetcode.com/problems/swap-nodes-in-pairs/description/
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
fun swapPairs(head: ListNode?): ListNode? {
    if(head == null){
        return null
    }
    var currentHead = head
    val newHead = head?.next ?: head
    val adjNode = currentHead?.next
    val adjNext = adjNode?.next
    adjNode?.next = currentHead
    currentHead?.next = swapPairs(adjNext)
    return newHead
}
}