class Solution {
   fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    if (numCourses == 0) return intArrayOf()

    // Convert graph presentation from edges to indegree of adjacent list.
    val indegree = IntArray(numCourses)
    val order = IntArray(numCourses)
    var index = 0
    for (i in 0 until prerequisites.size)  // Indegree - how many prerequisites are needed.
        indegree[prerequisites[i][0]]++

    val queue: Queue<Int> = LinkedList()
    for (i in 0 until numCourses) if (indegree[i] == 0) {
        // Add the course to the order because it has no prerequisites.
        order[index++] = i
        queue.offer(i)
    }


    // How many courses don't need prerequisites.
    while (!queue.isEmpty()) {
        val prerequisite = queue.poll() // Already finished this prerequisite course.
        for (i in 0 until prerequisites.size) {
            if (prerequisites[i][1] == prerequisite) {
                indegree[prerequisites[i][0]]--
                if (indegree[prerequisites[i][0]] == 0) {
                    // If indegree is zero, then add the course to the order.
                    order[index++] = prerequisites[i][0]
                    queue.offer(prerequisites[i][0])
                }
            }
        }
    }

    return if ((index == numCourses)) order else IntArray(0)
}
}