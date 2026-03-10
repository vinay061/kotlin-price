package tictactoe

fun gridGame() {
    val input = readln()
    val normalized = input.replace('_', ' ')
    val chars = normalized.toMutableList()
    displayGameGrid(chars)
    val charGrid = mutableListOf(
        mutableListOf(chars[0], chars[1], chars[2]),
        mutableListOf(chars[3], chars[4], chars[5]),
        mutableListOf(chars[6], chars[7], chars[8])
    )
    getCoordinates(charGrid)
}

private fun displayGameGrid(newChar: MutableList<Char>) {
    println("---------")
    for (i in newChar.indices step 3) {
        println("| ${newChar[i]} ${newChar[i + 1]} ${newChar[i + 2]} |")
    }
    println("---------")
}

private fun gameGridDisplay(newChar: MutableList<MutableList<Char>>) {
    println("---------")
    for (row in newChar) {
        println("| ${row[0]} ${row[1]} ${row[2]} |")
    }
    println("---------")
}

private fun getCoordinates(newChar: MutableList<MutableList<Char>>) {

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
        newChar[row][col] = 'X'
        break
    }
    gameGridDisplay(newChar)
}