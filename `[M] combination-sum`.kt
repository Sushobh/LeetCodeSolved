class Solution {
   fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val answers = ArrayList<ArrayList<Int>>()
    combinationSum2(candidates,target, arrayListOf(),0,answers,0)
    return answers
}

fun combinationSum2(
    candidates: IntArray, target: Int, currentList: List<Int>, currentSum: Int,
    answers: ArrayList<ArrayList<Int>>,
    startIndex : Int
) {

    for (i in startIndex until candidates.size) {
        val newSum = currentSum + candidates[i]
        if (newSum < target) {
            val newList = ArrayList<Int>()
            newList.addAll(currentList)
            newList.add(candidates[i])
            combinationSum2(candidates, target, newList, currentSum + candidates[i], answers,i)
        } else if (newSum > target) {

        } else {
            val newList = ArrayList<Int>()
            newList.addAll(currentList)
            newList.add(candidates[i])
            answers.add(newList)
        }
    }

}
}