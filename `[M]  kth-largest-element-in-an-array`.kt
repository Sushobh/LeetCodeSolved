//https://leetcode.com/problems/kth-largest-element-in-an-array/description/

fun findKthLargest(nums: IntArray, k: Int): Int {
    val queue = PriorityQueue<Int>(Collections.reverseOrder())
    for(i in nums){
        queue.add(i)
    }
    var currNum = queue.poll()
    for(i in 1..k-1){
        currNum = queue.poll()
    }

    return currNum
}