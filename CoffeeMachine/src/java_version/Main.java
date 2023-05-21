package java_version;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeemachine = new CoffeeMachine(550, 400, 540, 120, 9);
        Scanner scanner = new Scanner(System.in);

        while (coffeemachine.isWorking()) {
            coffeemachine.printMenu();
            try {
                String action = scanner.nextLine();
                coffeemachine.choiceAction(action, scanner);
            } catch (IllegalArgumentException e) {
                System.out.println("No such command");
            }
        }
    }
}