//https://leetcode.com/problems/zigzag-conversion/description/


class Solution {
   fun convert(s: String, numRows: Int): String {
     val queues = Array(numRows) { ArrayDeque<Char>() }
     generateQueue(queues,s,numRows)
     val builder = StringBuilder()
     for(i in 0 until queues.size) {
         val q = queues[i]
         repeat(q.size){
             builder.append(q.removeFirst())
         }
     }
     return builder.toString()
}


fun generateQueue(queues: Array<ArrayDeque<Char>>, s: String, numRows: Int) {
    var count = 0
    while(true){
        for(i in 0 until numRows){
            for(j in 0 until numRows){
                queues[j].addLast(s[count++])
                if(count == s.length){
                    return
                }
            }
            var fromDown = numRows-2
            while(fromDown > 0){
                queues[fromDown].addLast(s[count++])
                if(count == s.length){
                     return
                }
                fromDown--
            }
        }
    }
}
}