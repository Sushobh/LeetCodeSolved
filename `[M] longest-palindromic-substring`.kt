//https://leetcode.com/problems/longest-palindromic-substring/

//For each pair of indices check if the string is a palindrome.
// Also before embarking on the isPalindrome function check if the current palindrome string 
// is larger than the range about to be checked. If its bigger skip the current iteration.
// This will save some time.
class Solution {
   fun longestPalindrome(s: String): String {
    if(s.length == 1){
        return s
    }
    var currentPalindrome = ""
    for(i in 0..s.length-2){
        for(j in i+1..s.length-1){
            if(!(currentPalindrome.length >= ((j+1)-i))){
                if(isPalindrome(s,i,j)){
                    if(currentPalindrome.length < (j+1-i)){
                        currentPalindrome = s.substring(i,j+1)
                    }
                }
            }
        }
    }
    if(currentPalindrome == ""){
        return s.substring(0,1)
    }
    return currentPalindrome
}

fun isPalindrome(s : String,start : Int,end : Int) : Boolean {
    var st = start
    var et = end
    while(s[st] == s[et]){
        st++
        et--
        if(et <= st){
            return true
        }
    }
    return false
}

}