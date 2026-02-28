package coffee

import kotlin.math.min

var water: Int = 400
var milk: Int = 540
var coffeeBeans: Int = 120
var cups: Int = 9
var money: Int = 550

fun Coffee() {
    //numberOfCoffees()
    //supplyData()
    printSupplies(water, milk, coffeeBeans, cups, money)
    action()
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

/*
Part 1:
Current state :
Water - 400 ml
Milk - 540 ml
Coffe beans - 120 gms
Number of disposable cups - 9

Print the current state of the machine with the existing supplies.

Part 2:
Provide three options to the user: 1) Buy, 2) Fill, 3) Take
1) Buy
Provide 3 additional options - a) - espresso, b) - latte, c) - cappuccino:

Check if there are sufficient supplies to prepare coffee

a) Espresso
Water-  250 ml
Milk - 0 ml
Coffee beans - 16 g

b) Latte
Water - 350 ml
Milk - 75 ml
Coffee beans- 20 g

c) Cappuccino
Water - 200 ml
Milk - 100 ml
Coffee beans- 12 g

After choosing the option, print the state after consuming the supplies based on the coffee type

2) Fill
You need to take input from the user
Water ?
1000
Milk ?
500
Coffee beans ?
300
Disposable cups ?
10

Print the state after adding the given supplies

3) Take
Display and deduct the money that is available
Print the final state

Pattern / Trend

Part 1:
The state of supplies need to be printed for every transaction. The common supplies are:
Water, Milk, Coffee Beans, Disposable cups.

Part 2:
Buy
For every coffee option selected to Buy, the supplies needs to be calculated. The supplies are:
Water, Milk, Coffee Beans, Disposable cups.

Fill
For filling, you need to add the supplies. The supplies are:
Water, Milk, Coffee Beans, Disposable cups. Then you need to print this data including the balance money.

Take
For taking the money, you need to check for the current money balance.


Abstraction
Important details:
Supply stock
Water
Milk
Coffee beans
Disposable cups
Balance amount

Based on this, you can perform the following operations:
Buy, Fill, Take

Algorithm:
Write a function which has input parameters:
Water, Milk, Coffee Beans, Disposable cups

This function should print the supplies based on the above data.
Print function

You need to take input from the users : Action (Buy, Fill, Take)
Buy
Again check with the user for the types to buy? (Espresso, Latte, Cappuccino)

Write a function which has input parameters:
Water, Milk, Coffee Beans, Disposable cups

This function should calculate the supplies based on the current supplies and the supplies
required based on user selection.

If Espresso is chosen, then calculate or measure the supplies and based on this process further.

Fill
You need to add supplies when Fill is selected

Take
You need to deduct money from the existing balance

*/

fun printSupplies(water: Int, milk: Int, coffeeBeans: Int, cups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water ml of water\n" +
            "$milk ml of milk\n" +
            "$coffeeBeans g of coffee beans\n" +
            "$cups disposable cups\n" +
            "\$$money of money")
}

fun action() {
    println("\nWrite action (buy, fill, take):")
    val inputAction = readln()
    when(inputAction) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
            val coffeeType = readln().toInt()
            calculateSupplies(coffeeType)
        }
        "fill" -> {
            fillSupplies()
        }
        "take" -> {
            withdrawMoney(money)
        }
    }
}

fun calculateSupplies(coffeeType: Int) {
    when (coffeeType) {
        1 -> {
            water -= 250
            milk -= 0
            coffeeBeans -= 16
            cups -= 1
            money += 4
            printSupplies(water, milk, coffeeBeans, cups, money)
        }
        2 -> {
            water -= 350
            milk -= 75
            coffeeBeans -= 20
            cups -= 1
            money += 7
            printSupplies(water, milk, coffeeBeans, cups, money)
        }
        3 -> {
            water -= 200
            milk -= 100
            coffeeBeans -= 12
            cups -= 1
            money += 6
            printSupplies(water, milk, coffeeBeans, cups, money)
        }
    }
}

fun fillSupplies() {
    println("Write how many ml of water you want to add:")
    val water = readln().toInt()
    println("Write how many ml of milk you want to add: ")
    val milk = readln().toInt()
    println("Write how many grams of coffee beans you want to add: ")
    val coffeeBeans = readln().toInt()
    println("Write how many disposable cups you want to add: ")
    val disposableCups = readln().toInt()
    addSupplies(water, milk, coffeeBeans, disposableCups)
}

fun addSupplies(x: Int, y: Int, z: Int, a: Int) {
    water += x
    milk += y
    coffeeBeans += z
    cups += a
    printSupplies(water, milk, coffeeBeans, cups, money)
}

fun withdrawMoney(balance: Int) {
    val debit = money - balance
    println("I gave you $$balance")
    printSupplies(water, milk, coffeeBeans, cups, debit)
}