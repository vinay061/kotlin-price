fun main() {
    val coffee = CoffeeMachine(400, 540, 120, 9, 550)
    coffee.printItems(
        coffee.water,
        coffee.milk,
        coffee.beans,
        coffee.cups,
        coffee.cash
    )
    coffee.options()
}