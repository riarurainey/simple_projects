package java_version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* Класс с основной логикой приложения: сохранение и изменение количество шагов,
подсчет и вывод статистики.*/
public class StepTracker {
    int targetSteps = 10_000;
    HashMap<String, List<Integer>> stepsInMonth = new HashMap<>(12);
    List<Integer> stepsInDay = new ArrayList<>(Collections.nCopies(30, 0));
    Converter converter = new Converter();

    //Заполнение hashmap месяцами и листами с днями
    void putMonth() {
        stepsInMonth.put("ЯНВАРЬ", stepsInDay);
        stepsInMonth.put("ФЕВРАЛЬ", stepsInDay);
        stepsInMonth.put("МАРТ", stepsInDay);
        stepsInMonth.put("АПРЕЛЬ", stepsInDay);
        stepsInMonth.put("МАЙ", stepsInDay);
        stepsInMonth.put("ИЮНЬ", stepsInDay);
        stepsInMonth.put("ИЮЛЬ", stepsInDay);
        stepsInMonth.put("АВГУСТ", stepsInDay);
        stepsInMonth.put("СЕНТЯБРЬ", stepsInDay);
        stepsInMonth.put("ОКТЯБРЬ", stepsInDay);
        stepsInMonth.put("НОЯБРЬ", stepsInDay);
        stepsInMonth.put("ДЕКАБРЬ", stepsInDay);

    }

    //Сохранить количество шагов
    void saveSteps(String month, int day, int steps) {
        stepsInDay.set(day - 1, steps);
        stepsInMonth.put(month, stepsInDay);
        System.out.println(stepsInDay);
        System.out.println(stepsInMonth);

    }

    //Поменять целевое количество шагов
    int changeTargetSteps(int newTargetSteps) {
        return targetSteps = newTargetSteps;
    }

    //Напечатать меню статистики
    void printMenuStatistics() {
        System.out.println("Какую статистику Вы хотите получить?");
        System.out.println("1 - Вывести полную статистику");
        System.out.println("2 - Вывести список дней месяца с количеством шагов");
        System.out.println("3 - Вывести общее количество шагов за месяц");
        System.out.println("4 - Вывести максимальное пройденное количество шагов в месяце");
        System.out.println("5 - Узнать среднее количество шагов");
        System.out.println("6 - Узнать пройденную дистанцию за месяц (в км)");
        System.out.println("7 - Узнать количество соженных килокалорий");
        System.out.println("8 - Узнать лучшую серию дней за месяц");

    }

    //Напечатать всю статистику
    void printAllStatistics(String month) {
        List<Integer> currentList = stepsInMonth.get(month);
        showAllDays(currentList);
        showStepsSum(currentList);
        maxSteps(currentList);
        avgSteps(currentList);
        showDistance(currentList);
        showFireKilocalories(currentList);
        bestDays(currentList);
    }

    //Показать список дней месяца с количеством шагов по каждому дню
    void showAllDays(List<Integer> currentList) {
        if (currentList != null) {
            for (int i = 1; i <= currentList.size(); i++) {
                System.out.println("День " + i + " : " + currentList.get(i - 1));
            }
        }
    }

    //Показать общее количество шагов за месяц
    void showStepsSum(List<Integer> currentList) {
        int count = 0;

        for (Integer integer : currentList) {
            count += integer;
        }

        System.out.println("Общее количество шагов за месяц: " + count);
    }

    //Показать максимальное пройденное количество шагов в месяце
    void maxSteps(List<Integer> currentList) {
        System.out.println("Максимальное пройденное количество шагов в месяце: "
                + Collections.max(currentList));
    }

    //Показать среднее количество шагов за месяц
    void avgSteps(List<Integer> currentList) {
        int count = 0;

        for (Integer integer : currentList) {
            count += integer;
        }

        System.out.println("Среднее количество шагов: " + count / currentList.size());
    }

    //Показать пройденную дистанцию за месяц в км
    void showDistance(List<Integer> currentList) {
        int count = 0;

        for (Integer integer : currentList) {
            count += integer;
        }

        System.out.println("Пройденная дистанция (в км): " + converter.convertDistance(count));
    }

    //Показать количество соженных килокалорий за месяц
    void showFireKilocalories(List<Integer> currentList) {
        int count = 0;

        for (Integer integer : currentList) {
            count += integer;
        }

        System.out.println("Количество сожжённых килокалорий: " + converter.calculateBurnCalories(count));
    }

    //Показать серию лучших дней за месяц
    void bestDays(List<Integer> currentList) {
        int countOfBestDays = 0;
        int currentLength = 0;

        for (Integer integer : currentList) {
            if (integer > targetSteps) {
                currentLength++;
            }
            if (integer <= targetSteps) {
                if (currentLength > countOfBestDays) {
                    countOfBestDays = currentLength;
                }
                currentLength = 0;
            }
        }

        System.out.println("Лучшая серия: " + countOfBestDays);
    }
}