package coffee

private var waterSolutionB: Int = 400
private var laitB: Int = 540
private var cafeB: Int = 120
private var containerB: Int = 9
private var argentB: Int = 550

fun startTestB() {
    while(true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val inputAction = readln()
        when (inputAction) {
            "buy" -> buyCoffeeB()
            "fill" -> fillSupplyB()
            "take" -> takeCashB(argentB)
            "remaining" -> {
                displayStockB(waterSolutionB, laitB, cafeB, containerB, argentB)
            }
            "exit" -> return
        }
    }
}

fun buyCoffeeB() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val input = readln()
    when (input) {
        "1" -> makeCafeB(250, 0, 16, 4)
        "2" -> makeCafeB(350, 75, 20, 7)
        "3" -> makeCafeB(200, 100, 12, 6)
        "back" -> return
    }
}

fun makeCafeB(waterStock: Int, milkStock: Int, beanStock: Int, cost:Int) {
    when {
        waterSolutionB < waterStock -> {
            println("Sorry, not enough water!")
            return
        }
        laitB < milkStock -> {
            println("Sorry, not enough milk!")
            return
        }
        cafeB < beanStock -> {
            println("Sorry, not enough coffee beans!")
            return
        }
        containerB < 1 -> {
            println("Sorry, not enough cups!")
            return
        }
    }

    println("I have enough resources, making you a coffee!")
    waterSolutionB -= waterStock
    laitB -= milkStock
    cafeB -= beanStock
    containerB -= 1
    argentB += cost
}

fun fillSupplyB() {
    println("Write how many ml of water you want to add:")
    val waterAddition = readln().toInt()
    println("Write how many ml of milk you want to add: ")
    val milkAddition = readln().toInt()
    println("Write how many grams of coffee beans you want to add: ")
    val beansAddition = readln().toInt()
    println("Write how many disposable cups you want to add: ")
    val cupsAddition = readln().toInt()
    supplyAdditionB(waterAddition, milkAddition, beansAddition, cupsAddition)
}

private fun supplyAdditionB(x: Int, y: Int, z: Int, a: Int) {
    waterSolutionB += x
    laitB += y
    cafeB += z
    containerB += a
}

private fun displayStockB(waterStock: Int, milkStock: Int, beanStock: Int, cupsStock: Int, cashStock: Int) {
    println("The coffee machine has:")
    println("$waterStock ml of water\n" +
            "$milkStock ml of milk\n" +
            "$beanStock g of coffee beans\n" +
            "$cupsStock disposable cups\n" +
            "\$$cashStock of money\n")
}

fun takeCashB(balance: Int) {
    argentB = 0
    println("I gave you $$balance\n")
}

