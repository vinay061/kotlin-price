
fun ProductsList() {
    val products = mapOf(
        "Bubblegum" to "$0.2",
        "Toffee" to "$0.3",
        "Ice cream" to "$5",
        "Milk chocolate" to "$4",
        "Dooghnut" to "$2.5",
        "Pancake" to "$3.2",
    )
    println("Prices")
    for((key, value) in products) {
        println("$key: $value")
    }
}