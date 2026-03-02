import coffee.CoffeeMachineB
import coffee.CoffeeMaker
import coffee.FilterCoffee
import coffee.startTestB

fun main() {
    val filterCoffee = FilterCoffee()

    while (true) {
        if(filterCoffee.isWaitingAction()) {
            println("Write action (buy, fill, take, remaining, exit):")
        }
        val input = readln()
        if(input == "exit") return
        filterCoffee.process(input)
    }
}