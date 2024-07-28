

//https://leetcode.com/problems/rotate-array/description/

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
    val rotation = k%nums.size
    val numsPos = Array(nums.size, {0})
    val copy = nums.copyOf()
    for(i in 0 until nums.size){
        numsPos[i] = (i+rotation)%nums.size
    }
    for(i in 0 until numsPos.size){
        nums[numsPos[i]] = copy[i]
    }
}
}