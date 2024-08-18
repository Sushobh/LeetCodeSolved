class Solution {
   fun countAndSay(n: Int): String {

    if(n == 1){
        return "1"
    }
    else {

        val cnOfPrev = countAndSay(n-1)

        var currChar = cnOfPrev[0]
        var currCount = 0
        var i = 0
        val fullString = StringBuilder()
        while(i < cnOfPrev.length){
            if(cnOfPrev[i] == currChar){
                currCount++
            }
            else {
                fullString.append(currCount)
                fullString.append(currChar)
                currChar = cnOfPrev[i]
                currCount = 1
            }
            i++
        }
        if(currCount >= 1){
            fullString.append(currCount)
            fullString.append(currChar)
        }

        return fullString.toString()
    }

}
}