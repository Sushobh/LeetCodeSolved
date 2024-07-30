//https://leetcode.com/problems/search-a-2d-matrix

class Solution {
   fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    val arrWithTarget = matrix[findIndexOfColumn(matrix,0,matrix.size-1,target)]

    val foundSearchIndex =  arrWithTarget.binarySearch(target) 
   
    return foundSearchIndex >= 0
}

fun findIndexOfColumn(matrix: Array<IntArray>,start : Int,end : Int,target : Int) : Int{
    var mid = (start+end)/2
    var m = matrix.size-1
    var n = matrix[0].size
    
    if(end-start == 0){
        return start
    }
    
    if(target == matrix[mid][n-1]){
        return mid
    }
    else if(target < matrix[mid][n-1]){
        return findIndexOfColumn(matrix,start,mid,target)
    }
    else {
        return findIndexOfColumn(matrix,mid+1,end,target)
    }
}
}