class Solution {
  fun longestSubarray(nums: IntArray): Int {


    var max = nums[0]
    var maxRange = 1
    var i = 0
    while(i<nums.size) {
        if (nums[i] >= max) {
            if(nums[i] > max){
                maxRange = 1
            }
            max = nums[i]
            var start = i
            while (i < nums.size && nums[i] == max) {
                maxRange = max(maxRange, i - start + 1)
                i++
            }
        } else {
            i++
        }
    }
    return maxRange
}

}






