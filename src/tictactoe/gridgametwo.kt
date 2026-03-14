package tictactoe


fun gridGameTwo() {
    val charGrid = mutableListOf(
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' ')
    )
    gameGridDisplayTwo(charGrid)
    var currentPlayer = 'X'
    while(true) {
        getCoordinatesTwo(charGrid, currentPlayer)
        gameGridDisplayTwo(charGrid)
        if(checkGridWin(charGrid,currentPlayer)) {
            println("$currentPlayer wins")
            break
        }
        if(isDraw(charGrid)) {
            println("Draw")
            break
        }
        currentPlayer = if(currentPlayer == 'X') 'O' else 'X'
    }
}

private fun gameGridDisplayTwo(newChar: MutableList<MutableList<Char>>) {
    println("---------")
    for (row in newChar) {
        println("| ${row[0]} ${row[1]} ${row[2]} |")
    }
    println("---------")
}

private fun getCoordinatesTwo(newChar: MutableList<MutableList<Char>>, player: Char) {
    while (true) {
        val inputCell = readln()
        val listCell = inputCell.split(' ')
        if(listCell.size != 2) {
            println("You should enter numbers!")
            continue
        }
        if(!listCell[0].all { it.isDigit() } || !listCell[1].all { it.isDigit() }) {
            println("You should enter numbers!")
            continue
        }
        val row = listCell[0].toInt() - 1
        val col = listCell[1].toInt() - 1
        if( row !in 0..2 || col !in 0..2) {
            println("Coordinates should be from 1 to 3!")
            continue
        }
        if(newChar[row][col] != ' ') {
            println("This cell is occupied! Choose another one!")
            continue
        }
        newChar[row][col] = player
        break
    }
}

private fun checkGridWin(grid: MutableList<MutableList<Char>>, player: Char): Boolean {
    for(i in 0..2) {
        if(grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) return true
        if(grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) return true
    }
    if(grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) return true
    if(grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) return true
    return false
}

private fun isDraw(grid: MutableList<MutableList<Char>>): Boolean {
    for (row in grid) {
        if(' ' in row)
            return false
    }
    return true
}