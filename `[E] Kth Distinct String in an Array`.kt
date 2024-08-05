class Solution {
   fun kthDistinct(arr: Array<String>, k: Int): String {

    val stringMap = HashMap<String,Int>()
    for( i in 0..arr.size-1){
        if(stringMap.containsKey(arr[i])){
            stringMap.put(arr[i],stringMap[arr[i]]!!+1)
        }
        else {
            stringMap.put(arr[i],1)
        }
    }
    var count = k
    for(i in 0..arr.size-1){
        val strCount = stringMap[arr[i]]!!
        if(strCount == 1){
            count--
            if(count == 0){
                return arr[i]
            }
        }
    }
    return ""
}



}