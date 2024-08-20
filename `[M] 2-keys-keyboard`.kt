class Solution {
    fun minSteps(n: Int): Int {
        return minSteps(n,0,0,1)
    }

    fun minSteps(n: Int, clip: Int, stepsTaken: Int, currentLength: Int): Int {


    if (currentLength == n) {
        return stepsTaken
    } else {

        if(clip == 0){
            return minSteps(n, 1 ,stepsTaken+1,currentLength)
        }
        else {
            if(clip == currentLength){
                if(clip + currentLength > n){
                    return Int.MAX_VALUE
                }
                return minSteps(n,clip,stepsTaken+1,currentLength+clip)
            }
            else {

                if(clip + currentLength == n){
                    return stepsTaken+1
                }

                if(clip + currentLength > n){
                    //Cant paste, so copy only
                    return minSteps(n,currentLength,stepsTaken+1,currentLength)
                }

                if(clip + currentLength < n){
                    return min(minSteps(n,currentLength,stepsTaken+1,currentLength),
                        minSteps(n,clip,stepsTaken+1,currentLength+clip))
                }

            }

        }

       return 0
    }
}

}