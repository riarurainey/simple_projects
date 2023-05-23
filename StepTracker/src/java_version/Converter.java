package java_version;


/* В этом классе осуществляется преобразование шагов в километры и калории.*/
public class Converter {

    private final static int CENTIMETERS_IN_KILOMETERS = 100_000;
    private final static int CENTIMETERS_IN_STEP = 73;
    private final static int CALORIES_IN_KILOCALORIES = 1000;
    private final static int CALORIES_IN_STEP = 50;

    //Конвертирование шагов в километры
    int convertDistance(int steps) {
        return steps * CENTIMETERS_IN_STEP / CENTIMETERS_IN_KILOMETERS;
    }

    //Конвертирование шагов в килокалории
    int calculateBurnCalories(int steps) {
        return steps * CALORIES_IN_STEP / CALORIES_IN_KILOCALORIES;
    }
}