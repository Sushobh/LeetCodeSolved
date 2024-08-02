class Solution {
   

fun search(nums: IntArray, target: Int): Int {
    return search(nums,target,0,nums.size-1)
}

fun search(nums: IntArray, target: Int,start : Int,end : Int): Int {

    if(start == end){
         if(nums[start] == target){
             return start
         }
        else {
            return -1
         }
    }
    val mid = start+(end-start)/2
    val s1 = start
    val e1 = mid
    val s2 = mid+1
    val e2 = end


    if(nums[s1] > nums[e1]){
        //pivot here

        if(target >= nums[s2] && target <= nums[e2]) {
            val index = nums.binarySearch(target,s2,e2+1)
            if(index >= 0){
                return index
            }
            else {
                return -1
            }
        }
        else {
            return search(nums,target,s1,e1)
        }
    }
    else if(nums[s2] > nums[e2]){
        //pivot here

        if(target >= nums[s1] && target <= nums[e1]) {
            val index =  nums.binarySearch(target,s1,e1+1)
            if(index >= 0){
                return index
            }
            else {
                return -1
            }
        }
        return search(nums,target,s2,e2)
    }

    //Both do not have pivots



    if(target >= nums[s1]  && target <= nums[e1]) {
        val index =  nums.binarySearch(target,s1,e1+1)
        if(index >= 0){
            return index
        }
        else {
            return -1
        }
    }
    else {
        val index = nums.binarySearch(target,s2,e2+1)
        if(index >= 0){
            return index
        }
        else {
            return -1
        }
    }

}




}