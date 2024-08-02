//https://leetcode.com/problems/search-in-rotated-sorted-array-ii


class Solution {
fun search(nums: IntArray, target: Int): Boolean {
    return search(nums,target,0,nums.size-1)
}

fun search(nums: IntArray, target: Int,start : Int,end : Int): Boolean {

    if(start == end){
        return nums[start] == target
    }

    val mid = start+(end-start)/2
    val s1 = start
    val e1 = mid
    val s2 = mid+1
    val e2 = end

    if(nums[s1] == target || nums[e1] == target ||  nums[s2] == target|| nums[e2] == target) {
        return true
    }

    if(nums[s1] > nums[e1]){
        if(target >= nums[s2] && target <= nums[e2]) {
            return nums.binarySearch(target,s2,e2+1) >= 0
        }
        else {
            return search(nums,target,s1,e1)
        }
    }
    else if(nums[s2] > nums[e2]){
        //pivot here
        if(target >= nums[s1] && target <= nums[e1]) {
            return nums.binarySearch(target,s1,e1+1) >= 0
        }
        return search(nums,target,s2,e2)
    }

    if(nums[s1] < nums[e1] && nums[s2] < nums[e2]){
        return (nums.binarySearch(target,s1,e1+1) >= 0) || (nums.binarySearch(target,s2,e2+1) >= 0)
    }

    if(nums[s1] < nums[e1]) {
          return (nums.binarySearch(target,s1,e1+1) >= 0) || search(nums,target,s2,e2)
    }
    if(nums[s2] < nums[e2]){
        return (nums.binarySearch(target,s2,e2+1) >= 0) || search(nums,target,s1,e1)
    }


    return  search(nums,target,s1,e1) || search(nums,target,s2,e2)

}



}