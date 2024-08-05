class Solution {
    fun Char.isDigLe() = isDigit() || isLetter() || this == '.' || this == '-'
  fun simplifyPath(path: String): String {
    val arr = path.toCharArray()
    var newPath = ""
    var i = 1
    val tokenQueue = ArrayDeque<String>()
    tokenQueue.addLast("/")
    while(i < arr.size){

        val cr = arr[i]

        if(cr.isDigLe()){
            val digStart = i
            while(i < arr.size && arr[i] != '/'){
                i++
            }
            i--
            val digEnd = i
            val newToken = path.substring(digStart,digEnd+1)
            if(newToken == "."){
                if(tokenQueue.size > 1){
                    tokenQueue.removeLast()
                }
            }
            else if(newToken == ".."){
                if(tokenQueue.size > 2){
                    tokenQueue.removeLast()
                    tokenQueue.removeLast()
                    //Not home so remove extra slash
                    if(tokenQueue.size > 1){
                        tokenQueue.removeLast()
                    }
                }
            }
            else {
                tokenQueue.addLast(newToken)
            }
        }
        else if(cr == '/'){
            while(i < arr.size && arr[i] == '/'){
                i++
            }
            if(tokenQueue.last() != "/"){
                tokenQueue.addLast("/")
            }
            i--
        }
        i++
    }

    if(tokenQueue.last() == "/" && tokenQueue.size>1){
        tokenQueue.removeLast()
    }
    for(i in 1..tokenQueue.size){
        newPath = newPath+tokenQueue.removeFirst()
    }
    return newPath
}
}