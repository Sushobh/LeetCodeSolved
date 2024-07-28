package com.sushobh.solidtext.twopointers


// From https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var maxContainer = 0
    var numbersSoFar = PriorityQueue<Int>()


    // For everynumber start both from left and right, calculate max water from left and right.
    // However when starting from left, check if a height higher or equal has already been calculated, so
    // That you dont waste calculating the iteration. In order to save this historic data, use a priority queue so that numbers are ordered.
    // For example, in [8,4,8], there is no need to loop for 4 because 8 has already been calculated.
    // Also from the right, if you find a height which is taller or equal or greater than the left height, you can quit that loop there.
    // Because that will be the max value for the current for loop.
    for(i in 0 until height.size-1){
        var j = height.size-1
        if(numbersSoFar.size > 0 && numbersSoFar.peek() >= height[i]){
            continue
        }
        while(j > i){
            val newWater = min(height[j],height[i])*(j-i)
            if(newWater > maxContainer){
                maxContainer = max(maxContainer,(j-i)*min(height[j],height[i]))
            }
            //End because the left to right has been maxed out.
            if(height[j] >= height[i]){
                break
            }
            j--
        }
        numbersSoFar.add(height[i])
    }
    return maxContainer
}