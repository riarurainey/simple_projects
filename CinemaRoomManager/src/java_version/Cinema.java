package java_version;

import java.util.Scanner;

public class Cinema {
    private static int currentIncome = 0;
    private static String[][] twoDimArray;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] twoDimArray = createField(scanner);
        choiceAction(scanner, twoDimArray);

    }

    private static void choiceAction(Scanner scanner, String[][] twoDimArray) {
        while (true) {
            menu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTheSeats(twoDimArray);
                    break;
                case 2:
                    buyTicket(scanner, twoDimArray);
                    break;
                case 3:
                    printStatistics(twoDimArray);
                    break;
                case 0:
                    return;

            }
        }
    }

    private static void buyTicket(Scanner scanner, String[][] twoDimArray) {
        while (true) {
            int rowNumber = inputRowNumber(scanner);
            int seatsInThatRow = inputSeatsInThatRow(scanner);

            if (rowNumber > twoDimArray.length - 1 || seatsInThatRow > twoDimArray[0].length - 1) {
                System.out.println("Wrong input!");
            } else if ("B".equals(twoDimArray[rowNumber][seatsInThatRow])) {
                System.out.println("That ticket has already been purchased!");
            } else {
                twoDimArray[rowNumber][seatsInThatRow] = "B";
                countPrice(rowNumber, twoDimArray);
                break;
            }
        }
    }

    private static int inputRowNumber(Scanner scanner) {
        System.out.println("Enter a row number:");
        return scanner.nextInt();
    }

    private static int inputSeatsInThatRow(Scanner scanner) {
        System.out.println("Enter a seat number in that row:");
        return scanner.nextInt();
    }

    private static void sumCurrentIncome(int income) {
        currentIncome = currentIncome + income;
    }

    private static int getCurrentIncome() {
        return currentIncome;
    }

    private static void countPrice(int rowNumber, String[][] twoDimArray) {
        int rows = twoDimArray.length - 1;
        int seats = twoDimArray[0].length - 1;
        int allSeats = rows * seats;
        int frontHalf = 0;

        if (allSeats < 60) {
            System.out.println("Ticket price: " + "$" + 10);
            sumCurrentIncome(10);
        } else {
            frontHalf = rows / 2;

            if (rowNumber <= frontHalf) {
                System.out.println("Ticket price: " + "$" + 10);
                sumCurrentIncome(10);
            } else {
                System.out.println("Ticket price: " + "$" + 8);
                sumCurrentIncome(8);
            }
        }
    }

    private static String[][] createField(Scanner scanner) {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        String[][] twoDimArray = new String[rows + 1][seats + 1];
        String[] array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                if (i == 0 & j == 0) {
                    twoDimArray[i][j] = " ";
                } else if (i == 0) {
                    twoDimArray[i][j] = array[j];

                } else if (j == 0) {
                    twoDimArray[i][j] = array[i];
                } else {
                    twoDimArray[i][j] = "S";
                }
            }
        }
        return twoDimArray;
    }

    private static void showTheSeats(String[][] twoDimArray) {
        System.out.println("Cinema:");

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static double getPercentage(String[][] twoDimArray) {
        double sum = (twoDimArray.length - 1) * (twoDimArray[0].length - 1);
        double count = countOfSoldOnTickets(twoDimArray);
        return count / sum * 100;

    }

    private static int countOfSoldOnTickets(String[][] twoDimArray) {
        int count = 0;

        for (String[] strings : twoDimArray) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                if ("B".equals(strings[j])) {
                    count++;
                }
            }
        }
        return count;
    }


    private static int getTotalIncome(String[][] twoDimArray) {
        int rows = twoDimArray.length - 1;
        int seats = twoDimArray[0].length - 1;
        int allSeats = rows * seats;
        int frontHalf = 0;
        int backHalf = 0;
        int total = 0;

        if (allSeats < 60) {
            total = allSeats * 10;
        } else {
            frontHalf = rows / 2;
            backHalf = rows / 2 + 1;

            if (rows <= frontHalf) {
                total = frontHalf * seats * 10 + backHalf * seats * 8;
            } else {
                total = frontHalf * seats * 10 + backHalf * seats * 8;
            }
        }
        return total;
    }

    private static void printStatistics(String[][] twoDimArray) {
        System.out.println("Number of purchased tickets: " + countOfSoldOnTickets(twoDimArray));
        System.out.printf("Percentage:% .2f%% \n", getPercentage(twoDimArray));
        System.out.println("Current income: " + "$" + getCurrentIncome());
        System.out.println("Total income: " + "$" + getTotalIncome(twoDimArray));

    }

    private static void menu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

    }
}
