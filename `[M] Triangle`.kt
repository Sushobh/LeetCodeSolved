//https://leetcode.com/problems/triangle/submissions/1331692515/

class Solution {
 fun minimumTotal(triangle: MutableList<MutableList<Int>>): Int {
    if(triangle.isEmpty()){
        return 0
    }
    for(i in (triangle.size-1).downTo(0)){
        if(i == triangle.size -1){
            continue
        }
        else {
            for(x in 0..<triangle[i].size){
                triangle[i][x] = (if(triangle[i + 1][x] < (triangle[i + 1][x + 1])) triangle[i + 1][x] else triangle[i + 1][x + 1]) + triangle[i][x]
            }
        }
    }
    return triangle[0][0]
}
}