


//https://leetcode.com/problems/plus-one/



class Solution {
  
fun plusOne(digits: IntArray): IntArray {
     var endIndex = digits.size-1
     val resArr = IntArray(digits.size+1)
     var carry = 1

     while(endIndex >= 0){
         val currNumber = digits[endIndex]
         val sum = currNumber + carry
         if(sum < 10){
             resArr[endIndex+1] = sum
             digits[endIndex] = sum
             return digits
         }
         else {
             resArr[endIndex+1] = 0
             digits[endIndex] = 0
             carry = 1
         }
         endIndex--
     }

     resArr[0] = 1

     return resArr
}

}