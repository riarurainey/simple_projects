package java_version;

import java.util.Arrays;
import java.util.Scanner;

public class UserInteraction {
    Scanner scanner = new Scanner(System.in);
    NumberProperties numberProperties = new NumberProperties();

    public void startProgram() throws NumberException {
        welcome();
        menu();
        while (true) {
            System.out.println("Enter a request:");
            String input = scanner.nextLine();
            String[] stringsNumber = input.split(" ");

            long number;
            long numberLength;

            if ("0".equals(input)) {
                System.out.println("Goodbye!");
                break;
            } else if (input.isEmpty()) {
                menu();
            } else if (stringsNumber.length == 1) {
                number = Long.parseLong(input);
                if (number < 0) {
                    throw new NumberException("The first parameter should be a natural number or zero.");
                }
                numberProperties.getProperties(number);
            } else {
                number = Long.parseLong(stringsNumber[0]);
                numberLength = Long.parseLong(stringsNumber[1]);
                if (number < 0) {
                    throw new NumberException("The first parameter should be a natural number or zero.");

                } else if (numberLength <= 0) {
                    throw new NumberException("The second parameter should be a natural number.");

                } else if (stringsNumber.length == 2) {
                    for (int i = 0; i < numberLength; i++) {
                        System.out.println(numberProperties.getPropToString(number++));

                    }
                } else {
                    String[] properties = Arrays.copyOfRange(stringsNumber, 2, stringsNumber.length);
                    numberProperties.showProp(number, numberLength, properties);

                }
            }
        }
    }

    void welcome() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    void menu() {
        System.out.println("Supported requests:");
        System.out.println(" - enter a natural number to know its properties;");
        System.out.println(" - enter two natural numbers to obtain the properties of the list:");
        System.out.println("   * the first parameter represents a starting number;");
        System.out.println("   * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println(" - two natural numbers and two properties to search for;");
        System.out.println(" - a property preceded by minus must not be present in numbers;");
        System.out.println(" - separate the parameters with one space;");
        System.out.println(" - enter 0 to exit.");
    }
}
