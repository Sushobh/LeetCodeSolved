//https://leetcode.com/problems/generate-parentheses/submissions/1336376881/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]



class Solution {
   fun generateParenthesis(n: Int): List<String> {
    return generateParenthesis(n, hashMapOf(), hashSetOf())
}

//For n = 1, simply add arrayListOf("()")
//If lets say n = 7, then 
//First add all the combinations of n = 6 inside "()"
//Then generate other combinations by mixing strings from 6 up till 1.
// So combine 6 with 1, 4 with 2, 3 with 3, 2 with 4, 1 with 6
// Add these combinations to the list. 


// For example for n = 2, we have (()) and ()()
// When the problem is for n = 3 , we combine 2 with 1, and then 1 with 2. 
 // (()) with () and () with ()(). This may get REPEATED,so maintain a set 
// to remove duplicates.

// Similarly for n = 4, we combine 3 with 1, 2 with 2, 1 with 3


fun generateParenthesis(n: Int,data : HashMap<Int,List<String>>,allSet : HashSet<String>): List<String> {
    if(data.contains(n)){
        return data[n]!!
    }
    val list = arrayListOf<String>()
    if(n == 1){
        data.put(n,arrayListOf("()"))
        return data[n]!!
    }
    else {
        val older = generateParenthesis(n-1,data,allSet)
        older.forEach {
            list.add("(${it})")
        }
        var start = 1
        while(start <= n-1){
            val firstList = generateParenthesis(start,data,allSet)
            val secondList = generateParenthesis(n-start,data,allSet)
            for(x in firstList){
                for(y in secondList){
                    if(!allSet.contains(x+y)){
                        list.add(x+y)
                        allSet.add(x+y)
                    }
                }
            }
            start++
        }
    }
    data.put(n,list)
    return list
}

}





