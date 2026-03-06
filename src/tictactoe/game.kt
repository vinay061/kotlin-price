package tictactoe

import kotlin.math.abs

fun userInput() {
    val input = readln()
    val normalized = input.replace('_', ' ')
    val chars = normalized.toList()
    displayGrid(chars)
    val result = checkResult(chars)
    if(result == "Impossible") {
        println("Impossible")
    } else if( result != null) {
        println(result)
    } else if(spaceCellChecker(chars)) {
        println("Game not finished")
    } else {
        println("Draw")
    }
}

private fun displayGrid(newChar: List<Char>) {
    println("---------")
    for (i in newChar.indices step 3) {
        println("| ${newChar[i]} ${newChar[i + 1]} ${newChar[i + 2]} |")
    }
    println("---------")
}

fun checkResult(chars: List<Char>): String? {
    val lines = listOf(
        listOf(0,1,2), listOf(3,4,5), listOf(6,7,8),
        listOf(0,3,6), listOf(1,4,7), listOf(2,5,8),
        listOf(0,4,8), listOf(2,4,6)
    )
    val xCount = chars.count { it == 'X' }
    val oCount = chars.count { it == 'O' }
    val diff = abs(xCount - oCount)
    var xWins = false
    var oWins = false

    for (line in lines) {
        val values = line.map { chars[it] }
        if(values.all { it == 'X' }) xWins = true
        if(values.all { it == 'O' }) oWins = true
    }

    return when {
        xWins && oWins -> "Impossible"
        xWins -> "X wins"
        oWins -> "O wins"
        diff >= 2 -> "Impossible"
        else -> null
    }
}

fun spaceCellChecker(char: List<Char>): Boolean {
    return char.contains(' ')
}