
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
   fun lengthOfLongestSubstring(s: String): Int {
     val currentSet = HashSet<Char>()
     var maxSoFar = 0
     
     for(i in s.indices){
        currentSet.add(s[i])
        for(x in (i+1)..<s.length){
            if(currentSet.contains(s[x])){
                maxSoFar = Math.max(maxSoFar,currentSet.size)
                currentSet.clear()
                break
            }
            else {
                currentSet.add(s[x])
            }
        }
     }
    return Math.max(maxSoFar,currentSet.size)
}
}