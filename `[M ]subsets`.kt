

//https://leetcode.com/problems/subsets/
class Solution {
 fun subsets(nums: IntArray): List<List<Int>> {
    val dataList = mutableListOf<MutableList<Int>>()
    subsets(nums,0, mutableListOf(),dataList)
    dataList.add(mutableListOf())
    return dataList
}


fun subsets(nums : IntArray,start : Int, currentList : MutableList<Int>,allList : MutableList<MutableList<Int>> ) {

    if(start == nums.size-1){
        currentList.add(nums[start])
        val newList = mutableListOf<Int>().apply {
            addAll(currentList)
        }
    
        allList.add(newList)
        return
    }
    for(i in start..nums.size-1){
        val newCurrentList = mutableListOf<Int>().apply {
            addAll(currentList)
            add(nums[i])
        }

        allList.add(newCurrentList)
        subsets(nums,i+1,mutableListOf<Int>().apply {
            addAll(newCurrentList)
        },allList)
    }
}
}