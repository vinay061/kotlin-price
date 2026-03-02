package coffee

private var waterSolution: Int = 400
private var lait: Int = 540
private var cafe: Int = 120
private var container: Int = 9
private var argent: Int = 550

fun startTest() {
    while(true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val inputAction = readln()
        when (inputAction) {
            "buy" -> buyCoffee()
            "fill" -> fillSupply()
            "take" -> takeCash(argent)
            "remaining" -> {
                displayStock(waterSolution, lait, cafe, container, argent)
            }
            "exit" -> return
        }
    }
}

fun buyCoffee() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val input = readln()
    when (input) {
        "1" -> makeCafe(250, 0, 16, 4)
        "2" -> makeCafe(350, 75, 20, 7)
        "3" -> makeCafe(200, 100, 12, 6)
        "back" -> return
    }
}

fun makeCafe(waterStock: Int, milkStock: Int, beanStock: Int, cost:Int) {
    when {
        waterSolution < waterStock -> {
            println("Sorry, not enough water!")
            return
        }
        lait < milkStock -> {
            println("Sorry, not enough milk!")
            return
        }
        cafe < beanStock -> {
            println("Sorry, not enough coffee beans!")
            return
        }
        container < 1 -> {
            println("Sorry, not enough cups!")
            return
        }
    }

    println("I have enough resources, making you a coffee!")
    waterSolution -= waterStock
    lait -= milkStock
    cafe -= beanStock
    container -= 1
    argent += cost
}

fun fillSupply() {
    println("Write how many ml of water you want to add:")
    val waterAddition = readln().toInt()
    println("Write how many ml of milk you want to add: ")
    val milkAddition = readln().toInt()
    println("Write how many grams of coffee beans you want to add: ")
    val beansAddition = readln().toInt()
    println("Write how many disposable cups you want to add: ")
    val cupsAddition = readln().toInt()
    supplyAddition(waterAddition, milkAddition, beansAddition, cupsAddition)
}

private fun supplyAddition(x: Int, y: Int, z: Int, a: Int) {
    waterSolution += x
    lait += y
    cafe += z
    container += a
}

private fun displayStock(waterStock: Int, milkStock: Int, beanStock: Int, cupsStock: Int, cashStock: Int) {
    println("The coffee machine has:")
    println("$waterStock ml of water\n" +
            "$milkStock ml of milk\n" +
            "$beanStock g of coffee beans\n" +
            "$cupsStock disposable cups\n" +
            "\$$cashStock of money\n")
}

fun takeCash(balance: Int) {
    argent = 0
    println("I gave you $$balance\n")
}