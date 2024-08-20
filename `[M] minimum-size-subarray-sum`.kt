class Solution {
fun minSubArrayLen(target: Int, nums: IntArray): Int {

    val leftSum = IntArray(nums.size)

    for(i in 0 until nums.size){
        leftSum[i] = (if(i == 0) 0 else leftSum[i-1]) + nums[i]
    }

    fun sumBetween(x : Int, y : Int) : Int{
        val startSum = if(x == 0) 0 else leftSum[x-1]

        return leftSum[y] - startSum
    }
    var minR = Int.MAX_VALUE
    var prevEnd = -1
    for(i in 0..nums.size-1){

        val startFrom = if(prevEnd == -1){
            i
        }
        else {
            prevEnd
        }

        for(j in startFrom..nums.size-1){
            
            if(sumBetween(i,j) == target){
                minR = min(minR,j-i+1)
                prevEnd = j+1
                break
            }
            else if(sumBetween(i,j) > target){
                minR = min(minR,j-i+1)
                prevEnd = j
                break
            }
        }
    }


    if(minR == Int.MAX_VALUE){
        return 0
    }
    return minR
}
}