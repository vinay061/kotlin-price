package coffee

import kotlin.math.min


fun Coffee() {
    //numberOfCoffees()
    supplyData()
}

fun welcome() {
    val text = "Starting to make a coffee\n" +
            "Grinding coffee beans\n" +
            "Boiling water\n" +
            "Mixing boiled water with crushed coffee beans\n" +
            "Pouring coffee into the cup\n" +
            "Pouring some milk into the cup\n" +
            "Coffee is ready!"

    println(text)
}

fun numberOfCoffees() {
    println("Write how many cups of coffee you will need:")
    val count = readln().toInt()
    println("For $count cups of coffee you will need:")
    println("${count * 200} ml of water")
    println("${count * 50} ml of milk")
    println("${count * 15} g of coffee beans")
}


/* Problem decomposition
The program needs to understand the following:
Water - how much is available ?
Milk - how much is available ?
Coffee beans - how much is available ?

Also, mention the cups of coffe required ?

Based on this 3 scenario's needs to be given

1> For enough supplies - Yes, I can make it
2> If more supplies are available - Yes, I can make and mention the N cup of coffes that can be made
3> No supplies - No, I don't have sufficient supplies

1 cup of coffee
water - 200 ml
milk - 50 ml
coffee beans - 15 g

n cup of coffee
water - 200 * n   = wTimes
milk  = 50 * n = mTimes
coffe beans = 15 * n = cTimes

water >= wTimes && milk >= mTimes && coffeeBeans >= cTimes,
Yes I can make it.

even if more water is available, if there are 0 cups of milk, no coffe can be made.
hence take the minimum of the supplies minOf(water, milk, coffeBeans)
compare it with required amount
if (maxCups == requiredCups) - Yes, I can make that amount of coffee"
if (maxCups > requiredCups) - Yes, I can make that amount of coffee (and even N more than that)
if (maxCups < requiredCups) - No, I can make only N cups of coffee

 */

fun supplyData() {
    println("Write how many ml of water the coffee machine has:")
    val water = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milk = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeBeans = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val coffeeCupsCount = readln().toInt()
    val waterSupply: Int = water / 200
    val milkSupply: Int = milk / 50
    val coffeeBeansSupply: Int = coffeeBeans / 15
    val maximumCups = minOf(waterSupply, milkSupply, coffeeBeansSupply)

    when {
        maximumCups == coffeeCupsCount -> println("Yes, I can make that amount of coffee")
        maximumCups > coffeeCupsCount -> {
            val extraCups = maximumCups - coffeeCupsCount
            println("Yes, I can make that amount of coffee " +
                    "(and even $extraCups more than that)")
        }
        maximumCups < coffeeCupsCount -> println("No, I can make only $maximumCups cups of coffee")
    }
}