//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
      val dataMap = HashMap<Int,Int>()
      var currentNum = nums[0]
      var currentCount = 1
      if(nums.size == 1){
          return 1
      }
      for(i in 1 until nums.size){
          if(nums[i] != currentNum){
              dataMap.put(currentNum,currentCount)
              currentNum = nums[i]
              currentCount = 1
          }
          else {
              currentCount++
          }
          if(i == nums.size-1){
              dataMap.put(nums[i],currentCount)
          }
      }
      var writingIndex = 0
      var i = 0
      while(i < nums.size){
          val number = nums[i]
          val count = Math.min(2,dataMap[nums[i]]!!)
          if(count == 1){
              nums[writingIndex] = number
              writingIndex++
          }
          else {
              nums[writingIndex] = number
              nums[writingIndex+1] = number
              writingIndex+=2
          }
          i = i+dataMap[nums[i]]!!
      }
     return writingIndex
}
}