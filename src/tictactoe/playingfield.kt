package tictactoe

import kotlin.math.abs

fun playingField() {
    println("X O X")
    println("O X O")
    println("X X O")
}

var flag = false
var inputFlag = false
var xFlag = false
var oFlag = false

fun inputString() {
    val input = readln()
    val normalized = input.replace('_', ' ')
    val chars = normalized.toMutableList()
    val countX = chars.count { it == 'X' }
    val countO = chars.count { it == 'O' }
    printGrid(chars)
    if(abs(countX - countO) >= 2) {
        inputFlag = true
        println("Impossible")
    }
    if(!inputFlag) {
        if(emptyCells(chars)) {
            flag = true
            println("Game not finished")
        }
        checkWinner(chars)
        if(!flag) {
            println("Draw")
        }
    }

}

private fun printGrid(newChar: MutableList<Char>) {
    println("---------")
    for (i in newChar.indices step 3) {
        println("| ${newChar[i]} ${newChar[i + 1]} ${newChar[i + 2]} |")
    }
    println("---------")
}

fun checkWinner(chars: MutableList<Char>) {
    var winner: Char? = null
    val list1 = mutableListOf(chars[0], chars[1], chars[2])
    val list2 = mutableListOf(chars[3], chars[4], chars[5])
    val list3 = mutableListOf(chars[6], chars[7], chars[8])
    val list4 = mutableListOf(chars[0], chars[3], chars[6])
    val list5 = mutableListOf(chars[1], chars[4], chars[7])
    val list6 = mutableListOf(chars[2], chars[5], chars[8])
    val list7 = mutableListOf(chars[0], chars[4], chars[8])
    val list8 = mutableListOf(chars[2], chars[4], chars[6])

    if(
        list1.all { it == 'X' } || list2.all { it == 'X' } || list3.all { it == 'X' } ||
        list4.all { it == 'X' } || list5.all { it == 'X' } || list6.all { it == 'X' } ||
        list7.all { it == 'X' } || list8.all { it == 'X' }
    ) {
        winner = 'X'
        xFlag = true
    }
    if(
        list1.all { it == 'O' } || list2.all { it == 'O' } || list3.all { it == 'O' } ||
        list4.all { it == 'O' } || list5.all { it == 'O' } || list6.all { it == 'O' } ||
        list7.all { it == 'O' } || list8.all { it == 'O' }
    ) {
        winner = 'O'
        oFlag = true

    }
    if(oFlag && xFlag) {
        println("Impossible")
        flag = true
    }
    if( winner != null && !(xFlag && oFlag)) {
        flag = true
        println("$winner wins")
    }
}

fun emptyCells(chars: MutableList<Char>): Boolean {
    return chars.contains(' ')
}