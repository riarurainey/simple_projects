package java_version;

import java.util.Scanner;

/*Класс для вспомогательных методов обслуживания*/
public class Util {

    //Внесение количество шагов
    void getStepsFromDay(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите месяц за который Вы хотите внести данные: ");
        String month = scanner.next();

        System.out.println("Введите день за который Вы хотите внести данные: ");
        int day = scanner.nextInt();

        System.out.println("Введите количество шагов: ");
        int steps = scanner.nextInt();

        while (steps < 0) {
            System.out.println("Нужно внести неотрицательное число: ");
            steps = scanner.nextInt();
        }
        stepTracker.saveSteps(month.toUpperCase(), day, steps);
    }

    //Получение статистики
    void getStatistics(Scanner scanner, StepTracker stepTracker) {
        stepTracker.printMenuStatistics();
        int command = scanner.nextInt();

        System.out.println("Введите месяц за который Вы хотите получить статистику: ");
        String months = scanner.next();

        switch (command) {
            case 1:
                stepTracker.printAllStatistics(months.toUpperCase());
                break;
            case 2:
                stepTracker.showAllDays(stepTracker.stepsInMonth.get(months.toUpperCase()));
                break;
            case 3:
                stepTracker.showStepsSum(stepTracker.stepsInMonth.get(months.toUpperCase()));
                break;
            case 4:
                stepTracker.maxSteps(stepTracker.stepsInMonth.get(months.toUpperCase()));
                break;
            case 5:
                stepTracker.avgSteps(stepTracker.stepsInMonth.get(months.toUpperCase()));
                break;
            case 6:
                stepTracker.showDistance(stepTracker.stepsInMonth.get(months.toUpperCase()));
                break;
            case 7:
                stepTracker.showFireKilocalories(stepTracker.stepsInMonth.get(months.toUpperCase()));
                break;
            case 8:
                stepTracker.bestDays(stepTracker.stepsInMonth.get(months.toUpperCase()));
                break;
            default:
                System.out.println("Такая команда не найдена");
        }
    }

    //Изменение целевого количества шагов
    void changeTargetSteps(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите целевое количество шагов: ");
        int newTargetSteps = scanner.nextInt();

        while (newTargetSteps < 0) {
            System.out.println("Нужно внести неотрицательное число: ");
            newTargetSteps = scanner.nextInt();
        }
        stepTracker.changeTargetSteps(newTargetSteps);
        System.out.println("Новая цель по количеству шагов: " + stepTracker.targetSteps);
    }
}