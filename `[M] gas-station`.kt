//https://leetcode.com/problems/gas-station/

class Solution {
   fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val resultMap = hashMapOf<Int,Boolean>()
    for(i in gas.indices){
        if(resultMap.contains(i)){
            if(resultMap.get(i) == false){
                continue
            }
        }
        val result = canCompleteCircuit(gas,cost,0,i,i,resultMap)
        if(result != -1){
            return result
        }
    }
    return -1
}

fun canCompleteCircuit(gasArray : IntArray,
                       costArray : IntArray,
                       storedGas : Int, startIndex : Int,
                       destination : Int,resultMap : HashMap<Int,Boolean>) : Int{
    val currentGas = gasArray[startIndex] + storedGas
    val cost = costArray[startIndex]
    if(currentGas >= cost){
        val remaining = currentGas-cost
        var newStartIndex = startIndex+1
        if(newStartIndex == destination){
            return destination
        }
        if(newStartIndex == gasArray.size){
            newStartIndex = 0
            if(newStartIndex == destination){
                return destination
            }
        }
        val result = canCompleteCircuit(gasArray,costArray,remaining,newStartIndex,destination,resultMap)
        resultMap.put(newStartIndex,result == destination)
        return result
    }
    else {
         return -1
    }
}



}