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
 


 fun kthSmallest(root: TreeNode?, k: Int): Int {

    return kthSmallest2(root,k, ArrayDeque())
}

fun kthSmallest2(root: TreeNode?, k: Int,queue : ArrayDeque<Int>) : Int{
    if(root == null){
         return 0
    }
    else {
        if(root.left != null){
             kthSmallest2(root.left,k,queue)
             if(queue.size == k){
                 return queue.last()
             }
             queue.addLast(root.`val`)
             if(queue.size == k){
                return queue.last()
             }
             if(root.right != null){
                 kthSmallest2(root.right,k,queue)
                 if(queue.size == k){
                     return queue.last()
                 }
             }
        }
        else {
            queue.addLast(root.`val`)
            if(queue.size == k){
                return queue.last()
            }
            if(root.right != null){
                kthSmallest2(root.right,k,queue)
                if(queue.size == k){
                    return queue.last()
                }
            }
        }
    }

    return 0
}


}