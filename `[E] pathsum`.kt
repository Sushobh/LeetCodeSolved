

//https://leetcode.com/problems/path-sum/submissions/1334079696/

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if(root == null){
        return false
    }
     val left = root?.left
     val right = root?.right
     val isLeaf = left == null && right == null
     if(isLeaf){
         //println("Leaf value is ${root.`val`} and target sum is ${targetSum}")
         return targetSum == root.`val`
     }
     var hasSum = false
     left?.let {
         
         hasSum = hasPathSum(it,targetSum-root.`val`)
     }
     right?.let {
         hasSum = hasPathSum(it,targetSum-root.`val`) || hasSum
     }
     return hasSum
}
}