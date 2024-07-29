

//https://leetcode.com/problems/subsets/



//In case of an array like [1,2,3,4]
//For each number at index I, add the number in a response list, pass the copy of the list to the next numbers i.e. from I+1 to N-1
// For each of these numbers add the number to the received list, and perform the same process from I+2 to N-1
// When the passed index I is equal to N-1 (i.e. the number at the last index), add the number to the copy of the list received and return.



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