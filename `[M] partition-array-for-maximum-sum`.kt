class Solution {
  fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val dataMap = hashMapOf<Int,Int>()
    val ans  =  maxSummy1(arr,0,k,dataMap)
    return ans
}


fun maxSummy1(arr : IntArray, fromIndex : Int, k : Int,maxMap : HashMap<Int,Int>) : Int{


    if(maxMap.containsKey(fromIndex)){
        return maxMap[fromIndex]!!
    }

    if(fromIndex == arr.size-1){
        maxMap[fromIndex] = arr[fromIndex]
        return arr[fromIndex]
    }

    var maxSoFar = -1
    var sumSoFar: Int
    var maxCombinedSum = 0
    for(i in fromIndex..min(arr.size-1,fromIndex+k-1)){
        maxSoFar = max(arr[i],maxSoFar)
        sumSoFar = (i-fromIndex+1)*maxSoFar
        val calcValue = if(i+1 > arr.size-1){
            0
        }
        else {
            maxSummy1(arr,i+1,k, maxMap)
        }
        maxCombinedSum = max(sumSoFar + calcValue , maxCombinedSum)
    }
    maxMap.put(fromIndex,maxCombinedSum)
    return maxCombinedSum
}
}