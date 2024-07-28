


//From https://leetcode.com/problems/number-of-1-bits/description/

class Solution {
    fun hammingWeight(n: Int): Int {
        if(n == Int.MAX_VALUE){
            return 31
        }
        var index = 0
        while(true){
            val newVal = Math.pow(2.0,index.toDouble()).toInt()
            val nextVal = Math.pow(2.0,index.toDouble()+1).toInt()
            if(newVal == n){
                return 1
            }
            else if(nextVal > n) {
                return 1 + hammingWeight(n-newVal)
            }
            index++
        }
    }
}