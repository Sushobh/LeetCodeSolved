
https://leetcode.com/problems/count-number-of-teams
class Solution {
   fun numTeams(rating: IntArray): Int {
    val numCount1 : HashMap<Int,Pair<ArrayList<Int>,ArrayList<Int>>> = hashMapOf()
    var teamCount = 0
    for(i in 0 until rating.size){
        val currentNum = rating[i]
        numCount1[currentNum] = Pair(arrayListOf(), arrayListOf())
        for(j in i+1 until rating.size){
            val secondNum = rating[j]
            if(secondNum < currentNum){
                numCount1[currentNum]!!.first.add(secondNum)
            }
            else {
                numCount1[currentNum]!!.second.add(secondNum)
            }
        }
    }
    for(i in 0 until rating.size){
        val mins = numCount1[rating[i]]!!.first
        val maxes = numCount1[rating[i]]!!.second
        mins.forEach {
            val mins1 = numCount1[it]!!.first.size
            teamCount = teamCount + mins1
        }
        maxes.forEach {
            val maxes1 = numCount1[it]!!.second.size
            teamCount = teamCount + maxes1
        }
    }
    return teamCount
}
}