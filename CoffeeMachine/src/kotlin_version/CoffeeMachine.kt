package kotlin_version

class CoffeeMachine(
    var dollars: Int = 550,
    var water: Int = 400,
    var milk: Int = 540,
    var beans: Int = 120,
    var cups: Int = 9,
    var isWorking: Boolean = true
) {

    fun start() {
        while (isWorking) {
            printMenu()
        }
    }

    private fun printMenu() {
        println("Write action (buy, fill, take, remaining, exit): ")

        when (Status.valueOf(readln().uppercase())) {
            Status.BUY -> buy()
            Status.FILL -> fill()
            Status.TAKE -> take()
            Status.REMAINING -> remaining()
            Status.EXIT -> isWorking = false
            else -> println("No such command")
        }

    }


    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val choice = readln()
        if (checkResource(choice))
            when (choice) {
                "1" -> buyEspresso()
                "2" -> buyLatte()
                "3" -> buyCappuccino()
                "buy" -> printMenu()

            }
    }

    private fun checkResource(choice: String): Boolean {
        when (choice) {
            "1" -> {
                if (water < 250 || beans < 16 || cups < 1) {
                    println("Sorry, not enough resources!")
                    return false
                }
            }

            "2" -> {
                if (water < 350 || beans < 20 || cups < 1 || milk < 75) {
                    println("Sorry, not enough resources!")
                    return false
                }
            }

            "3" -> {
                if (water < 200 || beans < 12 || cups < 1 || milk < 100) {
                    println("Sorry, not enough resources!")
                    return false
                }
            }

            else -> {
                println("Invalid choice!")
                return true
            }
        }
        println("I have enough resources, making you a coffee!")
        return true
    }

    private fun buyCappuccino() {
        water -= 200
        milk -= 100
        beans -= 12
        dollars += 6
        cups -= 1
    }

    private fun buyLatte() {
        water -= 350
        milk -= 75
        beans -= 20
        dollars += 7
        cups -= 1
    }

    private fun buyEspresso() {
        water -= 250
        beans -= 16
        dollars += 4
        cups -= 1
    }


    private fun fill() {
        println("Write how many ml of water you want to add: ")
        water += readln().toInt()
        println("Write how many ml of milk you want to add: ")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add: ")
        beans += readln().toInt();
        println("Write how many disposable cups you want to add: ")
        cups += readln().toInt()

    }

    private fun remaining() {
        println("\nThe coffee machine has: ")
        println("$water  ml of water")
        println("$milk ml of milk")
        println("$beans g of coffee beans")
        println("$cups disposable cups")
        println("$$dollars of money\n")
    }


    private fun take() {
        println("I gave you $$dollars")
        dollars = 0
    }

}