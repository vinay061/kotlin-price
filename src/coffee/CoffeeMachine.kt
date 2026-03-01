package coffee

class CoffeeMachine(
    var water: Int,
    var milk: Int,
    var beans: Int,
    var cups: Int,
    var cash: Int
) {
    fun printItems(waterStock: Int, milkStock: Int, beanStock: Int, cupsStock: Int, cashStock: Int) {
        println("The coffee machine has:")
        println("$waterStock ml of water\n" +
                "$milkStock ml of milk\n" +
                "$beanStock g of coffee beans\n" +
                "$cupsStock disposable cups\n" +
                "\$$cashStock of money")
    }

    fun options() {
        println("\nWrite action (buy, fill, take):")
        val inputAction = readln()
        when(inputAction) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
                val coffeeType = readln().toInt()
                calculateItems(coffeeType)
            }
            "fill" -> {
                fillItems()
            }
            "take" -> {
                withdrawCash(money)
            }
        }
    }

    fun calculateItems(coffeeType: Int) {
        when (coffeeType) {
            1 -> {
                water -= 250
                milk -= 0
                beans -= 16
                cups -= 1
                cash += 4
                printSupplies(water, milk, beans, cups, cash)
            }
            2 -> {
                water -= 350
                milk -= 75
                beans -= 20
                cups -= 1
                cash += 7
                printSupplies(water, milk, beans, cups, cash)
            }
            3 -> {
                water -= 200
                milk -= 100
                beans -= 12
                cups -= 1
                cash += 6
                printSupplies(water, milk, beans, cups, cash)
            }
        }
    }

    fun fillItems() {
        println("Write how many ml of water you want to add:")
        val water = readln().toInt()
        println("Write how many ml of milk you want to add: ")
        val milk = readln().toInt()
        println("Write how many grams of coffee beans you want to add: ")
        val coffeeBeans = readln().toInt()
        println("Write how many disposable cups you want to add: ")
        val disposableCups = readln().toInt()
        addItems(water, milk, coffeeBeans, disposableCups)
    }

    fun addItems(x: Int, y: Int, z: Int, a: Int) {
        water += x
        milk += y
        beans += z
        cups += a
        printItems(water, milk, coffeeBeans, cups, cash)
    }

    fun withdrawCash(balance: Int) {
        val debit = money - balance
        println("I gave you $$balance")
        printItems(water, milk, beans, cups, debit)
    }
}