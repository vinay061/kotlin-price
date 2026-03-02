package coffee

class CoffeeMaker(
    private var water: Int,
    private var milk: Int,
    private var beans: Int,
    private var cups: Int,
    private var cash: Int
) {

    fun start() {
        while(true) {
            println("Write action (buy, fill, take, remaining, exit):")
            val inputAction = readln()
            when (inputAction) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take(cash)
                "remaining" -> {
                    displayStock(water, milk, beans, cups, cash)
                }
                "exit" -> return
            }
        }
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val input = readln()
        when (input) {
            "1" -> makeCoffee(250, 0, 16, 4)
            "2" -> makeCoffee(350, 75, 20, 7)
            "3" -> makeCoffee(200, 100, 12, 6)
            "back" -> return
        }
    }

    fun makeCoffee(waterStock: Int, milkStock: Int, beanStock: Int, cost:Int) {
        when {
            water < waterStock -> {
                println("Sorry, not enough water!")
                return
            }
            milk < milkStock -> {
                println("Sorry, not enough milk!")
                return
            }
            beans < beanStock -> {
                println("Sorry, not enough coffee beans!")
                return
            }
            cups < 1 -> {
                println("Sorry, not enough cups!")
                return
            }
        }

        println("I have enough resources, making you a coffee!")
        water -= waterStock
        milk -= milkStock
        beans -= beanStock
        cups -= 1
        cash += cost
    }

    fun fill() {
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
        water += x
        milk += y
        beans += z
        cups += a
    }

    private fun displayStock(waterStock: Int, milkStock: Int, beanStock: Int, cupsStock: Int, cashStock: Int) {
        println("The coffee machine has:")
        println("$waterStock ml of water\n" +
                "$milkStock ml of milk\n" +
                "$beanStock g of coffee beans\n" +
                "$cupsStock disposable cups\n" +
                "\$$cashStock of money\n")
    }

    fun take(balance: Int) {
        cash = 0
        println("I gave you $$balance\n")
    }
}