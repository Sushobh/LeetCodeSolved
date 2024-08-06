class Solution {
    fun minimumPushes(word: String): Int {

    val countMap = HashMap<Char,Int>()
    for(i in word){
        val ch = i
        val existing=  countMap[ch]
        countMap[ch] = if(existing != null){
            existing+1
        }
        else {
            1
        }
    }
    val charList = ArrayList<Pair<Char,Int>>()
    for(k in countMap){
        charList.add(Pair(k.key,k.value))
    }
    charList.sortByDescending { it.second }
    var count = 0
    for(i in 0..charList.size-1){
        val iter = (i+1)/8
        if(iter > 0){
            if((i+1)%8 > 0){
                count = count + (charList[i].second)*(iter+1)
            }
            else {
                count = count + (charList[i].second)*(iter)
            }
        }
        else {
            count = count + charList[i].second
        }
    }

    return count
}
}