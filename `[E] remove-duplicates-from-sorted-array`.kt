
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1174878797/

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var currentNumber : Int? = null
        var numbersFound = 0
        nums.forEachIndexed { index, num ->
            if(currentNumber == null){
                currentNumber = num
            }
            else {
                 if(num > currentNumber!!) {
                     nums[++numbersFound] = num
                 }
                 currentNumber = num
            }
        }
        return numbersFound+1
    }
}