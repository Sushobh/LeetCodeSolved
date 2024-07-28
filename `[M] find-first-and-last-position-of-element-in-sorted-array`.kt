//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Solution {

    fun searchRange(nums : IntArray,target: Int) = searchRange(nums,target,0)


   fun searchRange(nums: IntArray, target: Int,offset : Int): IntArray {
     val middle = nums.size/2
     if(nums.size == 0){
         return intArrayOf(-1,-1)
     }
      if(nums.size == 1){
          return if( nums[0] != target){
              intArrayOf(-1,-1)
          }
          else {
              intArrayOf(offset,offset)
          }
      }
      if(target < nums[middle]){
          return searchRange(nums.sliceArray(IntRange(0,middle-1)),target,offset)
      }
      else if(target > nums[middle]){
          return searchRange(nums.sliceArray(IntRange(middle+1,nums.size-1)),target,offset+middle+1)
      }
      else {
          var start = middle
          var end = middle
          var i = middle-1
          var j = middle+1
          while(i>=0){
              if(nums[i] < target){
                  start = i+1
                  break
              }
              else {
                  start = i
              }
              i--
          }
          while(j < nums.size){
              if(nums[j] > target){
                  end = j-1
                  break
              }
              else {
                  end = j
              }
              j++
          }
          return intArrayOf(offset+start,offset+end)
      }
}
}