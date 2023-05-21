package java_version;

import java.util.Scanner;

public class CoffeeMachine {
    private int dollars;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private boolean isWorking = true;

    public CoffeeMachine(int dollars, int water, int milk, int coffeeBeans, int disposableCups) {
        this.dollars = dollars;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
    }


    public void printMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

    public void choiceAction(String action, Scanner scanner) {

        switch (CoffeeMachineStatus.valueOf(action.toUpperCase())) {
            case BUY -> buy(scanner);
            case FILL -> fill(scanner);
            case TAKE -> take();
            case REMAINING -> remaining();
            case EXIT -> coffeeMachineIsOff();
            default -> System.out.println("No such command");
        }
    }

    public boolean isWorking() {
        return isWorking;
    }

    private void coffeeMachineIsOff() {
        System.out.println("Coffee Machine is off!");
        isWorking = false;
    }

    private void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                "back - to main menu: ");
        String choice = scanner.nextLine();
        if ("back".equalsIgnoreCase(choice)) {
            printMenu();
        } else {
            int choiceNumber = Integer.parseInt(choice);
            boolean isHasResource = checkResources(choiceNumber);
            if (isHasResource) {
                switch (choiceNumber) {
                    case 1 -> {
                        water -= 250;
                        coffeeBeans -= 16;
                        dollars += 4;
                        disposableCups -= 1;
                    }
                    case 2 -> {
                        water -= 350;
                        milk -= 75;
                        coffeeBeans -= 20;
                        dollars += 7;
                        disposableCups -= 1;
                    }
                    case 3 -> {
                        water -= 200;
                        milk -= 100;
                        coffeeBeans -= 12;
                        dollars += 6;
                        disposableCups -= 1;
                    }
                }
            }
        }

    }

    private boolean checkResources(int choice) {
        boolean hasResources = true;
        switch (choice) {
            case 1:
                if (water < 250 & coffeeBeans < 16 & disposableCups < 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    hasResources = false;
                } else if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                    hasResources = false;
                } else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    hasResources = false;
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    hasResources = false;
                }

                break;
            case 2:
                if (water < 350 & coffeeBeans < 20 &
                        disposableCups < 1 & milk < 75) {
                    System.out.println("I have enough resources, making you a coffee!");
                    hasResources = false;
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    hasResources = false;
                } else if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    hasResources = false;
                } else if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                    hasResources = false;
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    hasResources = false;
                }
                break;
            case 3:
                if (water < 200 & coffeeBeans < 12 &
                        disposableCups < 1 & milk < 100) {
                    System.out.println("I have enough resources, making you a coffee!");
                    hasResources = false;
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    hasResources = false;
                } else if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    hasResources = false;
                } else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                    hasResources = false;
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    hasResources = false;
                }
                break;


        }
        return hasResources;
    }

    private void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        int waterToAdd = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milkToAdd = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int coffeeBeansToAdd = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int disposableCupsToAdd = scanner.nextInt();

        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        disposableCups += disposableCupsToAdd;

    }

    private void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + dollars + " of money");
    }


    private void take() {
        System.out.println("I gave you $" + dollars);
        dollars = 0;

    }

}