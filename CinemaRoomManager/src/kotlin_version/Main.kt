package kotlin_version

fun main() {
    val seatsInHall = createHall()
    showTheSeats(seatsInHall)
    buyTicket(seatsInHall)
    showTheSeats(seatsInHall)

}

fun createHall(): MutableList<MutableList<String>> {
    println("Enter the number of rows:");
    val rows = readln().toInt();
    println("Enter the number of seats in each row:");
    val seats = readln().toInt();
    return MutableList(rows) { MutableList(seats) { "S" } }
}

fun showTheSeats(seatsInHall: MutableList<MutableList<String>>) {
    print("\nCinema:\n  ")
    for (i in 1..seatsInHall[0].size) {
        print("$i ")
    }
    for (i in seatsInHall.indices) {
        print("\n${i + 1} ${seatsInHall[i].joinToString(" ")}")
    }
    println("\n")
}

private fun buyTicket(seatsInHall: MutableList<MutableList<String>>) {
    println("Enter a row number:");
    val rowNumber = readln().toInt()
    println("Enter a seat number in that row:");
    val seatsInThatRow = readln().toInt()
    while (true) {

        if (rowNumber > seatsInHall.size - 1 || seatsInThatRow > seatsInHall.size - 1) {
            println("Wrong input!")
        } else if ("B" == seatsInHall[rowNumber][seatsInThatRow]) {
            println("That ticket has already been purchased!")
        } else {
            seatsInHall[rowNumber - 1][seatsInThatRow - 1] = "B"
            countPrice(rowNumber, seatsInHall)
            break
        }
    }
}

private fun countPrice(rowNumber: Int, seatsInHall: MutableList<MutableList<String>>) {
    val rows = seatsInHall.size - 1
    val seats = seatsInHall[0].size - 1

    val cost = if (rows * seats <= 60) 10 else if (rowNumber > rows / 2) 8 else 10
    println("Ticket price: $$cost")
}
