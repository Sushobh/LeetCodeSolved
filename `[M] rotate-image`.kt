class Solution {
   fun rotate(matrix: Array<IntArray>): Unit {


    fun calcNextPos(row: Int, col: Int, startRow : Int, startCol : Int,dimen: Int, matrix: Array<IntArray>, origValue: Int,bound : Int) {
        var newRow = 0
        var newCol = 0
        val endIndex = bound + dimen - 1
        if (row == bound) {
            newCol = endIndex
            newRow = col
        } else if (col == endIndex) {
            newRow = endIndex
            newCol = endIndex - row + bound
        } else if (row == endIndex) {
            newCol = bound
            newRow = col
        } else if (col == bound) {
            newRow = bound
            newCol = endIndex - row + bound
        }
        val oldVal = matrix[newRow][newCol]
        matrix[newRow][newCol] = origValue

        if(!(newRow == startRow && newCol == startCol)){
            calcNextPos(newRow,newCol,startRow,startCol,dimen,matrix,oldVal,bound)
        }
        else {
           println("Done")
        }
    }

    for (i in 0..(matrix.size - 1) / 2) {
        val newEnd = matrix.size-1-i
        for(j in i..(newEnd-1)){
            calcNextPos(i,j,i,j,(matrix.size)-i*2,matrix,matrix[i][j],i)
        }
    }
}

}