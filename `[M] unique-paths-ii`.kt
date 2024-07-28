//https://leetcode.com/problems/unique-paths-ii/description/

class Solution {
   fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    return uniquePathsWithObstacles(obstacleGrid, intArrayOf(0,0), hashMapOf())
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>,startPos : IntArray,pathsMap : HashMap<String,Int>): Int {
   val key = ""+startPos[0]+""+startPos[1]
   if(pathsMap.contains(key)){
       return pathsMap.get(key)!!
   }
   if(obstacleGrid[startPos[0]][startPos[1]] == 1) {
       pathsMap[key] = 0
       return 0
   }
   else if(startPos[0] == obstacleGrid.size-1 && startPos[1] == obstacleGrid[0].size-1){
       pathsMap[key] = 1
       return 1
   }
   else {
       val down = intArrayOf(startPos[0]+1,startPos[1])
       val right = intArrayOf(startPos[0],startPos[1]+1)
       var count = 0
       if(down[0] < obstacleGrid.size && down[1] < obstacleGrid[0].size ){
         count +=  uniquePathsWithObstacles(obstacleGrid,down, pathsMap)
       }
       if(right[0] < obstacleGrid.size && right[1] < obstacleGrid[0].size){
           count += uniquePathsWithObstacles(obstacleGrid,right, pathsMap)
       }
       pathsMap[key] = count
       return count
   }
}
}