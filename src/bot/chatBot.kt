package bot

fun chatBot() {
    greet("Aid", "2023")
    remindName()
    guessAge()
    count()
    test()
    end()
}

fun greet(name: String, year: String) {
    println("Hello! My name is $name.")
    println("I was created in $year")
}

fun remindName() {
    println("Please, remind me your name.")
    val yourName = readln()
    println("What a great name you have, $yourName!")
}

fun guessAge() {
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")
    val x = readln().toInt()
    val y = readln().toInt()
    val z = readln().toInt()
    val age = (x * 70 + y * 21 + z * 15) % 105
    println("Your age is $age; that's a good time to start programming!")
}

fun count() {
    println("Now I will prove to you that I can count to any number you want.")
    val number = readln().toInt()
    for (i in 0..number) {
        println("$i!")
    }
}

fun test() {
    println("Let's test your programming knowledge.")
    println("Why do we use methods?")
    println("1. To repeat a statement multiple times.\n" +
            "2. To decompose a program into several small subroutines.\n" +
            "3. To determine the execution time of a program.\n" +
            "4. To interrupt the execution of a program.")
    while(true) {
        val inputOption = readln().toInt()
        if(inputOption == 2) {
            break
        } else {
            println("Please, try again.")
            continue
        }
    }
}

fun end() {
    println("Congratulations, have a nice day!")
}