
fun revenue() {
    val products = mapOf(
        "Bubblegum" to "$202",
        "Toffee" to "$118",
        "Ice cream" to "$2250",
        "Milk chocolate" to "$1680",
        "Doughnut" to "$1075",
        "Pancake" to "$80",
    )
    println("Earned amount:")
    for((item, income) in products) {
        println("$item: $income")
    }
    val totalIncome = products.values.sumOf {
        it.removePrefix("$").toInt()
    }
    println("Income: $${totalIncome}")
    println("Staff Expenses:")
    val inputStaffExpenseData = readln().toInt()
    println("Other Expenses:")
    val inputOtherExpenseData = readln().toInt()
    val expense = inputStaffExpenseData + inputOtherExpenseData
    val netExpense = totalIncome - expense
    println("Net Income: $$netExpense")
}