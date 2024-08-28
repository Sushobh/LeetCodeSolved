class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

    val leftProds = IntArray(nums.size)
    val rightProds = IntArray(nums.size)

    for(i in 0 until nums.size){
        if(i == 0){
            leftProds[i] = nums[i]
        }
        else {
            leftProds[i] = leftProds[i-1]*nums[i]
        }
    }

    for(i in nums.size-1 downTo 0){
        if(i == nums.size-1){
            rightProds[i] = nums[i]
        }
        else {
            rightProds[i] = rightProds[i+1]*nums[i]
        }
    }

    val ansArr = IntArray(nums.size)


    for(i in 0..nums.size-1){

        if(i == 0){
            ansArr[i] = rightProds[i+1]
        }
        else if(i == nums.size-1){
            ansArr[i] = leftProds[i-1]
        }
        else {
            ansArr[i] = leftProds[i-1]*rightProds[i+1]
        }

    }


    return ansArr
}
}