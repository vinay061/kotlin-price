package coffee


enum class State {
    WAITING_ACTION,
    WAITING_COFFEE_CHOICE,
    FILL_WATER,
    FILL_MILK,
    FILL_BEANS,
    FILL_CUPS
}
class FilterCoffee(
    private var waterSolutionB: Int = 400,
    private var laitB: Int = 540,
    private var cafeB: Int = 120,
    private var containerB: Int = 9,
    private var argentB: Int = 550
) {

    private var state = State.WAITING_ACTION

    fun process(input: String) {
        when (state) {
            State.WAITING_ACTION -> {
                when(input) {
                    "buy" -> {
                        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                        state = State.WAITING_COFFEE_CHOICE
                    }
                    "fill" -> {
                        println("Write how many ml of water you want to add:")
                        state = State.FILL_WATER
                    }
                    "take" -> {
                        println("I gave you $$argentB")
                        argentB = 0
                    }
                    "remaining" -> itemDisplay()
                }
            }
            State.WAITING_COFFEE_CHOICE -> {
                when(input) {
                    "1" -> prepareCoffee(250, 0, 16, 4)
                    "2" -> prepareCoffee(350, 75, 20, 7)
                    "3" -> prepareCoffee(200, 100, 12, 6)
                    "back" -> { /* do nothing */}
                    else -> {
                        println("Invalid input")
                        return
                    }
                }
                state = State.WAITING_ACTION
            }
            State.FILL_WATER -> {
                waterSolutionB += input.toInt()
                println("Write how many ml of milk you want to add:")
                state = State.FILL_MILK
            }
            State.FILL_MILK -> {
                laitB += input.toInt()
                println("Write how many grams of coffee beans you want to add:")
                state = State.FILL_BEANS
            }
            State.FILL_BEANS -> {
                cafeB += input.toInt()
                println("Write how many disposable cups you want to add:")
                state = State.FILL_CUPS
            }
            State.FILL_CUPS -> {
                containerB += input.toInt()
                state = State.WAITING_ACTION
            }
        }
    }

    fun prepareCoffee(w: Int, m: Int, b: Int, balance: Int) {
        if(waterSolutionB < w || laitB < m || cafeB < b) {
            println("Sorry, not enough resources!")
            return
        }
        println("I have enough resources, making you a coffee!")
        waterSolutionB -= w
        laitB -= m
        cafeB -= b
        containerB--
        argentB += balance
    }

    fun itemDisplay() {
        println("The coffee machine has:")
        println("$waterSolutionB ml of water\n" +
                "$laitB ml of milk\n" +
                "$cafeB g of coffee beans\n" +
                "$containerB disposable cups\n" +
                "\$$argentB of money\n")
    }

    fun isWaitingAction(): Boolean {
        return state == State.WAITING_ACTION
    }
}