class Solution {
   
fun isIsomorphic(s: String, t: String): Boolean {

    val replaceMap = HashMap<Char,Char>()
    val secondMap = HashMap<Char,Char>()
    for(i in 0 until s.length){
        if(replaceMap.containsKey(s[i]) || secondMap.containsKey(t[i])){
            if(replaceMap[s[i]] != t[i] || secondMap[t[i]] != s[i]){
                return false
            }
        }
        else {
            replaceMap.put(s[i],t[i])
            secondMap.put(t[i],s[i])
        }
    }


    return true
}


}