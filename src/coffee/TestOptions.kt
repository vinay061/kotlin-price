package coffee

class CoffeeMachineB(
    private var waterSolutionB: Int = 400,
    private var laitB: Int = 540,
    private var cafeB: Int = 120,
    private var containerB: Int = 9,
    private var argentB: Int = 550
) {

    private var state = "action"
    private var fillStep = 0

    fun process(input: String) {

        when (state) {

            "action" -> {
                println("Write action (buy, fill, take, remaining, exit):")

                when (input) {
                    "buy" -> {
                        state = "buy"
                        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                    }
                    "fill" -> {
                        state = "fill"
                        fillStep = 1
                        println("Write how many ml of water you want to add:")
                    }
                    "take" -> {
                        println("I gave you $$argentB")
                        argentB = 0
                    }
                    "remaining" -> displayStockB()
                    "exit" -> state = "exit"
                }
            }

            "buy" -> {
                when (input) {
                    "1" -> makeCafeB(250, 0, 16, 4)
                    "2" -> makeCafeB(350, 75, 20, 7)
                    "3" -> makeCafeB(200, 100, 12, 6)
                }
                state = "action"
            }

            "fill" -> {
                when (fillStep) {
                    1 -> {
                        waterSolutionB += input.toInt()
                        fillStep++
                        println("Write how many ml of milk you want to add:")
                    }
                    2 -> {
                        laitB += input.toInt()
                        fillStep++
                        println("Write how many grams of coffee beans you want to add:")
                    }
                    3 -> {
                        cafeB += input.toInt()
                        fillStep++
                        println("Write how many disposable cups you want to add:")
                    }
                    4 -> {
                        containerB += input.toInt()
                        state = "action"
                    }
                }
            }
        }
    }

    private fun makeCafeB(waterStock: Int, milkStock: Int, beanStock: Int, cost: Int) {

        when {
            waterSolutionB < waterStock -> println("Sorry, not enough water!")
            laitB < milkStock -> println("Sorry, not enough milk!")
            cafeB < beanStock -> println("Sorry, not enough coffee beans!")
            containerB < 1 -> println("Sorry, not enough cups!")
            else -> {
                println("I have enough resources, making you a coffee!")
                waterSolutionB -= waterStock
                laitB -= milkStock
                cafeB -= beanStock
                containerB -= 1
                argentB += cost
            }
        }
    }

    private fun displayStockB() {
        println("""
        The coffee machine has:
        $waterSolutionB ml of water
        $laitB ml of milk
        $cafeB g of coffee beans
        $containerB disposable cups
        $$argentB of money
        """.trimIndent())
    }

    fun isRunning(): Boolean = state != "exit"
}