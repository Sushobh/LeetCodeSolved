//https://leetcode.com/problems/group-anagrams/description/

class Solution {
    
fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val sortedStringMap = hashMapOf<String,ArrayList<String>>()
        for(s in strs){
            val sortedString = String(s.toCharArray().sortedArray())
            if(!sortedStringMap.containsKey(sortedString)){
                sortedStringMap.put(sortedString, arrayListOf())
            }
            sortedStringMap.get(sortedString)?.add(s)
        }

        val result = arrayListOf<List<String>>()
        for(list in sortedStringMap){
            result.add(list.value)
        }
        return result;
    }
}