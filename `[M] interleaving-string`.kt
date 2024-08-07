class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        return isInterleave2(s1,s2,s3,hashMapOf())
    }

    fun isInterleave2(s1: String, s2: String, s3: String,answerMap : HashMap<String,Boolean>): Boolean {



    fun createHash() : String {
        return s1+"_"+s2+"_"+s3
    }

    if(answerMap.contains(createHash())){
        //println("Returning hash value")
        return answerMap[createHash()]!!
    }

    if((s1.isNotEmpty()  && s1[0] != s3[0]) && (s2.isNotEmpty() && s2[0] != s3[0])){
        answerMap[createHash()] = false
        return false
    }
    else {
        var isPos1 = false
        var isPos2 = false
        if(s1.isNotEmpty() && s1[0] == s3[0]){
            if(s3.length == 1){
                val result = s1.length == 1 && s2.isEmpty()
                answerMap[createHash()] = result
                return result
            }
            isPos1 = isInterleave2(s1.substring(1,s1.length),s2,s3.substring(1,s3.length),answerMap)
            if(isPos1){
                return true
            }
        }
        if(s2.isNotEmpty() && s2[0] == s3[0]){
            if(s3.length == 1){
                val result = s2.length == 1 && s1.isEmpty()
                answerMap[createHash()] = result
                return result
            }
            if(isPos2){
                return true
            }
            isPos2 = isInterleave2(s1,s2.substring(1,s2.length),s3.substring(1,s3.length),answerMap)
        }
        val result =  isPos1 || isPos2 || (s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
        answerMap[createHash()] = result
        return result
    }

}

}