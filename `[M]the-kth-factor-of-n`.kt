//https://leetcode.com/problems/the-kth-factor-of-n

class Solution {
 fun kthFactor(n: Int, k: Int): Int {
    if(n == 1){
        return 1
    } 
    val half = n/2
    val endFactors = arrayListOf<Int>()
    var startFactors = arrayListOf<Int>()
    val factorsFound = hashSetOf<Int>()
    var foundFactorsCount = 0
    for(i in 1..half){
        if(n%i == 0){
            if(factorsFound.contains(n/i)){
                break
            }

            startFactors.add(i)
            factorsFound.add(i)
            if(i != n/i){
                endFactors.add(n/i)
            }
            foundFactorsCount++
            if(foundFactorsCount == k){
                return startFactors.get(k-1)
            }
        }
    }

    if(k > startFactors.size + endFactors.size){
        return -1
    }

    if(k <= startFactors.size){
      return  startFactors.get(k-1)
    }
    val newK = k-startFactors.size-1
    return endFactors.get(endFactors.size-newK-1)
}
}