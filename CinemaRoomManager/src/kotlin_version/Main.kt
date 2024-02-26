package kotlin_version

val seatsInHall = createHall()
var rows = 0;
var seats = 0
var currentIncome = 0

const val menu = """
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
"""

fun main() {
    showMenu()

}

fun showMenu() {

    while (true) {
        println(menu)
        when (readln().toInt()) {
            1 -> showTheSeats()
            2 -> buyTicket()
            3 -> printStatistics()
            0 -> return
        }
    }

}

fun createHall(): MutableList<MutableList<String>> {
    println("Enter the number of rows:");
    rows = readln().toInt();
    println("Enter the number of seats in each row:");
    seats = readln().toInt();
    return MutableList(rows) { MutableList(seats) { "S" } }
}

fun showTheSeats() {
    print("\nCinema:\n  ")
    for (i in 1..seatsInHall[0].size) {
        print("$i ")
    }
    for (i in seatsInHall.indices) {
        print("\n${i + 1} ${seatsInHall[i].joinToString(" ")}")
    }
    println("\n")
}

private fun buyTicket() {
    while (true) {
        println("Enter a row number:");
        val rowNumber = readln().toInt()
        println("Enter a seat number in that row:");
        val seatNumber = readln().toInt()

        if (rowNumber <= seatsInHall.size && seatNumber <= seatsInHall.size) {
            if (seatsInHall[rowNumber - 1][seatNumber - 1] == "B") {
                println("That ticket has already been purchased!")
            } else {
                seatsInHall[rowNumber - 1][seatNumber - 1] = "B"
                countPrice(rowNumber)
                break
            }
        } else {
            println("Wrong input!")
        }
    }
}

private fun getTotalIncome(): Int {
    val allSeats = rows * seats
    val totalIncome = if (allSeats <= 60) {
        allSeats * 10
    } else {
        val frontHalf = rows / 2;
        val backHalf = rows / 2 + 1;

        if (rows <= frontHalf) {
            frontHalf * seats * 10 + backHalf * seats * 8;
        } else {
            frontHalf * seats * 10 + backHalf * seats * 8;
        }
    }
    return totalIncome;
}

private fun countPrice(rowNumber: Int) {
    val allSeats = rows * seats

    val cost = if (allSeats <= 60) {
        currentIncome += 10
        10
    } else if (rowNumber > rows / 2) {
        currentIncome += 8
        8
    } else {
        currentIncome += 10
        10
    }
    println("Ticket price: $$cost")
}

fun getPercentage(): Double {
    val sum = rows * seats
    return countOfSoldOnTickets() / sum.toDouble() * 100
}

fun printStatistics() {
    println("Number of purchased tickets: " + countOfSoldOnTickets());
    println("Percentage: %.2f%%".format(getPercentage()))
    println("Current income: $$currentIncome")
    println("Total income: $${getTotalIncome()}")

}

fun countOfSoldOnTickets(): Long {
    return seatsInHall.flatten().stream().filter { str -> str == "B" }.count()
}
