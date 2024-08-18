class Solution {
  fun longestCommonPrefix(strs: Array<String>): String {

    var currentQueue = ArrayDeque<Char>()
    for(i in strs[0]){
        currentQueue.add(i)
    }
    for(i in 1..strs.size-1){
        val currString = strs[i]

        val iterTill = min(currString.length,currentQueue.size)
        var count = 1
        val newQueue = ArrayDeque<Char>()
        while(count <= iterTill){
            if(currentQueue[count-1] == currString[count-1]){
                newQueue.addLast(currString[count-1])
            }
            else {
                break
            }
            count++
        }
        currentQueue = newQueue
    }

    var toReturn = ""
    for(i in 0 until currentQueue.size){
        toReturn = toReturn + currentQueue[i]
    }

    return toReturn
}
}