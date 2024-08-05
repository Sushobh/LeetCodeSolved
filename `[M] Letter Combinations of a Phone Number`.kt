class Solution {
   val letterMap : HashMap<Char,CharArray> = hashMapOf('2' to
        charArrayOf('a','b','c'),
       '3' to charArrayOf('d','e','f'),
    '4' to charArrayOf('g','h','i'),
    '5' to charArrayOf('j','k','l'),
    '6' to charArrayOf('m','n','o'),
    '7' to charArrayOf('p','q','r','s'),
    '8' to charArrayOf('v','t','u'),
    '9' to charArrayOf('w','x','y','z'),

    )


fun letterCombinations(digits: String): List<String> {
    val answerList = ArrayList<String>()

    letterCombinations(digits,"",0,answerList)
    return answerList
}

fun letterCombinations(digits: String,currentString : String,nextIndex : Int,answerList : ArrayList<String>) {
    if(digits.length == 0){
        return
    }
    val charsAtDigit = letterMap[digits[nextIndex]]!!
    if(nextIndex == digits.length-1){
        for(i in charsAtDigit){
            answerList.add(currentString + i)
        }
    }
    else {
        for(c in charsAtDigit){
            val newString = currentString + c
            letterCombinations(digits,newString,nextIndex+1,answerList)
        }
    }

}
}