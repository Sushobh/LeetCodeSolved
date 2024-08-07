class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var firstEnd = l1
    var secondEnd = l2
    var carry = 0
    var currNode : ListNode? = null
    var headNode : ListNode? = null
    while(firstEnd != null || secondEnd != null){
        var indexSum : Int = 0
        indexSum = indexSum + (firstEnd?.`val` ?: 0) + (secondEnd?.`val` ?: 0) + carry
        val currNumber = if(indexSum < 10){
            carry = 0
            indexSum
        }
        else {
            carry = 1
            indexSum-10
        }
        val prevNode = currNode
        currNode = ListNode(currNumber)
        if(prevNode != null){
            prevNode.next = currNode
        }
        else {
            headNode = currNode
        }
        firstEnd = firstEnd?.next
        secondEnd = secondEnd?.next
    }
    if(carry == 1){
        val endNode = ListNode(1)
        currNode!!.next = endNode
    }
    return headNode
}
}