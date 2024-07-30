//https://leetcode.com/problems/remove-element/description/
class Solution {
    fun removeElement(nums: IntArray, tar: Int): Int {
    var start = 0
    var end = nums.size-1
    while(true){
        while(start < nums.size && nums[start] != tar){
            start++
        }
        if(start == nums.size){
            break
        }
        while(end >= 0 && nums[end] == tar){
             end--
        }
        if(end < 0){
            break
        }
        if(end <= start){
            break
        }
        val temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
    }
    var count = 0
    var i = 0
    while(i < nums.size && nums[i] != tar){
        count++
        i++
    }
    return count
}


}