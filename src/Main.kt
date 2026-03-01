import coffee.Coffee
import coffee.CoffeeMachine

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //ProductsList()
    //revenue()
    //viewStatus()
    //status()
    //Coffee()
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