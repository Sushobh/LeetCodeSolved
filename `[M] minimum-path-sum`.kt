class Solution {
   
fun minPathSum(grid: Array<IntArray>): Int {
     return minPathSum(0,0,grid,Array(grid.size) {
         IntArray(grid[0].size) {
             -1
         }
     })
}


fun minPathSum(x : Int,y : Int, grid: Array<IntArray>, answers : Array<IntArray>) : Int {
    if(answers[x][y] != -1){
        return answers[x][y]
    }
    val currentValue = grid[x][y]
    var currMin = Int.MAX_VALUE
    
    //BottomRightEntered
    if(x + 1 == grid.size && y+1 ==grid[0].size){
        answers[x][y] = grid[x][y]
        return answers[x][y]
    }
    if(x+1 < grid.size){
        currMin = min(currMin, currentValue + minPathSum(x+1,y,grid,answers))
    }
    if(y+1 < grid[0].size){
        currMin = min(currMin,currentValue + minPathSum(x,y+1,grid,answers))
    }
    
    answers[x][y] = currMin
    return answers[x][y]
}
}