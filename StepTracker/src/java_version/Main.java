package java_version;

import java.util.Scanner;

/* Класс для считывания команд и показа меню*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Util util = new Util();

        stepTracker.putMonth();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    util.getStepsFromDay(scanner, stepTracker);
                    break;
                case 2:
                    util.getStatistics(scanner, stepTracker);
                    break;
                case 3:
                    util.changeTargetSteps(scanner, stepTracker);
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    System.exit(0);
                default:
                    System.out.println("Такая команда не найдена");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}