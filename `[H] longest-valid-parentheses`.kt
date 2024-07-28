//https://leetcode.com/problems/longest-valid-parentheses/description/


class Solution {
    fun longestValidParentheses(s: String): Int {

    val stack = Stack<Array<Any>>()
    val lengths = IntArray(s.length)
    for (i in s.indices) {
        val c = s[i]
        if (c == ')' && stack.size > 0 && stack.peek()[0] == '(') {
            val elementRemoved = stack.pop()
            val length = (i - (elementRemoved[1]) as Int) + 1
            lengths[i] = length
            continue
        }
        stack.push(arrayOf(c,i))
    }
    var maxSoFar = 0
    var currentMax = 0
    var x = lengths.size - 1
    while (x >= 0) {
        val len = lengths[x]
        if (len == 0) {
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax
            }
            currentMax = 0
        } else {
            currentMax = currentMax + len
            x = x - len
            continue
        }
        x--
    }
    return Math.max(currentMax, maxSoFar)
}
}