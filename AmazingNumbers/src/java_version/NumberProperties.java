package java_version;
import java.util.HashSet;
import java.util.Set;

public class NumberProperties {
    void showProp(long number, long length, String[] properties) {
        boolean bool = true;
        int count = 0;
        boolean correct = true;
        String str1 = null;
        String str2 = null;
        String propWithoutMinus = null;


        if (findMinusDublProp(properties)) {
            correct = false;
        }

        if (checkExclusiveProperties(properties)) {
            correct = false;
        }

        if (checkDublicationProperties(properties)) {
            correct = false;
        }

        for (int i = 0; i < properties.length; i++) {
            if (checkWrongProperties(properties[i]) && str1 != null) {
                str2 = properties[i];
            } else if (checkWrongProperties(properties[i]) && str1 == null) {
                str1 = properties[i];
            }
        }

        if (checkWrongTwoProperties(str1, str2)) {
            correct = false;
        }

        if (correct) {
            while (count < length) {
                String numberProperties = getPropToString(number);
                for (String property : properties) {
                    if (property.contains("-")) {
                        propWithoutMinus = property.substring(1).strip().toLowerCase();
                        if (numberProperties.contains(propWithoutMinus)) {
                            bool = false;
                            break;
                        } else {
                            bool = true;
                        }
                    } else if (!property.contains("-") && !numberProperties.contains(property.toLowerCase())) {
                        bool = false;
                        break;
                    } else {
                        bool = true;
                    }
                }
                number++;
                if (bool) {
                    System.out.println(numberProperties);
                    count++;
                }

            }
        }
    }

    String getPropToString(long number) {
        StringBuilder stringBuilder = new StringBuilder(number + " is ");

        if (isBuzzNumber(number)) {
            stringBuilder.append("buzz,");
        }
        if (isDuckNumber(number)) {
            stringBuilder.append("duck,");
        }
        if (isPalindromic(number)) {
            stringBuilder.append("palindromic,");
        }

        if (isGapful(number)) {
            stringBuilder.append("gapful,");
        }
        if (isSpy(number)) {
            stringBuilder.append("spy,");
        }
        if (isSquareNumber(number)) {
            stringBuilder.append("square, ");
        }
        if (isSunnyNumber(number)) {
            stringBuilder.append("sunny, ");
        }
        if (isJumpingNumber(number)) {
            stringBuilder.append("jumping, ");
        }
        if (isHappyNumber(number)) {
            stringBuilder.append("happy, ");
        }
        if (isSadNumber(number)) {
            stringBuilder.append("sad, ");
        }
        if (isEven(number)) {
            stringBuilder.append("even,");
        }
        if (isOdd(number)) {
            stringBuilder.append("odd,");
        }

        return stringBuilder.toString();
    }

    void getProperties(long number) {
        System.out.println("Properties of " + number);
        System.out.println("        buzz: " + isBuzzNumber(number));
        System.out.println("        duck: " + isDuckNumber(number));
        System.out.println(" palindromic: " + isPalindromic(number));
        System.out.println("      gapful: " + isGapful(number));
        System.out.println("         spy: " + isSpy(number));
        System.out.println("       square: " + isSquareNumber(number));
        System.out.println("       sunny: " + isSunnyNumber(number));
        System.out.println("     jumping: " + isJumpingNumber(number));
        System.out.println("       happy:" + isHappyNumber(number));
        System.out.println("        sad: " + isSadNumber(number));
        System.out.println("        even: " + isEven(number));
        System.out.println("         odd: " + isOdd(number));

    }

    private boolean checkWrongTwoProperties(String property1, String property2) {
        if (property2 != null && property1 != null) {
            if (checkWrongProperties(property1) && checkWrongProperties(property2)) {
                System.out.println("The properties " + property1 + "," + property2 + " are wrong.");
                System.out.println("Available properties:");
                System.out.println("[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, " +
                        "GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                return true;
            } else if (checkWrongProperties(property2)) {
                System.out.println("The property " + property2 + " is wrong.");
                System.out.println("Available properties:");
                System.out.println("[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, " +
                        "GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                return true;
            } else if (checkWrongProperties(property1)) {
                System.out.println("The property " + property1 + " is wrong.");
                System.out.println("Available properties:");
                System.out.println("[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, " +
                        "GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                return true;
            }

        } else if (property1 != null && checkWrongProperties(property1)) {
            System.out.println("The property " + property1 + " is wrong.");
            System.out.println("Available properties:");
            System.out.println("[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, " +
                    "GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return true;
        }
        return false;
    }

    private boolean checkWrongProperties(String property) {
        switch (property.toUpperCase()) {
            case "BUZZ":
            case "DUCK":
            case "SPY":
            case "EVEN":
            case "ODD":
            case "SUNNY":
            case "SQUARE":
            case "GAPFUL":
            case "PALINDROMIC":
            case "JUMPING":
            case "HAPPY":
            case "SAD":
            case "-BUZZ":
            case "-DUCK":
            case "-SPY":
            case "-EVEN":
            case "-ODD":
            case "-SUNNY":
            case "-SQUARE":
            case "-GAPFUL":
            case "-PALINDROMIC":
            case "-JUMPING":
            case "-HAPPY":
            case "-SAD":
                return false;
            default:
                return true;
        }
    }


    private boolean findMinusDublProp(String[] prop) {
        String[] properties = prop.clone();

        boolean isMinusDubl = false;
        for (int i = 0; i < properties.length; i++) {

            for (int j = i + 1; j < properties.length; j++) {

                if (properties[i].contains("-") && !properties[j].contains("-")) {
                    properties[i] = properties[i].replace("-", "");
                    if (properties[i].equalsIgnoreCase(properties[j])) {
                        isMinusDubl = true;
                        System.out.println("The request contains mutually exclusive properties: " +
                                "[" + prop[i].toUpperCase() + "]" +
                                " " + "[" + prop[j].toUpperCase() + "]");
                        System.out.println("There are no numbers with these properties.");
                        break;

                    }
                } else if (properties[j].contains("-") && !properties[i].contains("-")) {
                    properties[j] = properties[j].replace("-", "");
                    if (properties[j].equalsIgnoreCase(properties[i])) {
                        isMinusDubl = true;
                        System.out.println("The request contains mutually exclusive properties: " +
                                "[" + prop[i].toUpperCase() + "]" + " " + "[" +
                                prop[j].toUpperCase() + "]");
                        System.out.println("There are no numbers with these properties.");
                        break;

                    }

                } else if (!checkDublicationProperties(prop)) {
                    if (properties[i].equalsIgnoreCase(properties[j])) {
                        isMinusDubl = true;
                        System.out.println("The request contains mutually exclusive properties: " +
                                "[" + prop[i].toUpperCase() + "]" + " " + "[" +
                                prop[j].toUpperCase() + "]");
                        System.out.println("There are no numbers with these properties.");
                        break;
                    }

                }
            }
        }
        return isMinusDubl;
    }

    private boolean checkDublicationProperties(String[] properties) {
        for (int i = 0; i < properties.length; i++) {
            String e1 = properties[i];

            for (int j = 0; j < properties.length; j++) {
                if (i == j) continue;
                String e2 = properties[j];
                if (e1.equals(e2)) {

                    return true;

                }
            }
        }
        return false;
    }


    private boolean checkExclusiveProperties(String[] properties) {
        boolean isExclusiveProperties = false;
        String str1 = String.join(",", properties);
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : properties) {
            if (!string.contains("-")) {
                stringBuilder.append(string);
                stringBuilder.append(" ");
            }
        }
        String str = stringBuilder.toString();
        if (str.contains("even") && str.contains("odd") || (str1.contains("-even") && str1.contains("-odd"))) {
            System.out.println("The request contains mutually exclusive properties: [EVEN], [ODD]");
            System.out.println("There are no numbers with these properties.");

            isExclusiveProperties = true;
        }

        if (str.contains("duck") && str.contains("spy") ||
                (str1.contains("-duck") && str1.contains("-spy"))) {
            System.out.println("The request contains mutually exclusive properties: [DUCK], [SPY]");
            System.out.println("There are no numbers with these properties.");

            isExclusiveProperties = true;
        }

        if (str.contains("sunny") && str.contains("square") || (str1.contains("-sunny") && str1.contains("-square"))) {
            System.out.println("The request contains mutually exclusive properties: [SUNNY], [SQUARE]");
            System.out.println("There are no numbers with these properties.");
            isExclusiveProperties = true;
        }

        if (str.contains("happy") && str.contains("sad") || (str1.contains("-happy") && str1.contains("-sad"))) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY], [SAD]");
            System.out.println("There are no numbers with these properties.");
            isExclusiveProperties = true;
        }
        return isExclusiveProperties;
    }


    private boolean isHappyNumber(long number) {
        int sum = 0;
        Set<Long> numbers = new HashSet<Long>();
        while (numbers.add(number)) {
            sum = 0;
            while (number > 0) {
                sum += (number % 10) * (number % 10);
                number /= 10;
            }
            number = sum;
        }

        return sum == 1;
    }

    private boolean isSadNumber(long number) {
        int sum = 0;
        Set<Long> numbers = new HashSet<Long>();
        while (numbers.add(number)) {
            sum = 0;
            while (number > 0) {
                sum += (number % 10) * (number % 10);
                number /= 10;
            }
            number = sum;
        }
        return sum != 1;
    }

    private boolean isJumpingNumber(long number) {
        boolean flag = true;
        while (number != 0) {
            long digit1 = number % 10;
            number = number / 10;
            if (number != 0) {
                long digit2 = number % 10;
                if (Math.abs(digit1 - digit2) != 1) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    private boolean isSunnyNumber(long number) {
        number++;
        return Math.sqrt(number) == (long) (Math.sqrt(number));
    }

    private boolean isSquareNumber(long number) {
        return Math.sqrt(number) == (long) (Math.sqrt(number));
    }

    private boolean isSpy(long number) {
        String strNumber = Long.toString(number);
        int numberSum = 0;
        int numberApply = 1;
        for (int i = 0; i < strNumber.length(); i++) {
            numberSum += Character.getNumericValue(strNumber.charAt(i));
            numberApply *= Character.getNumericValue(strNumber.charAt(i));
        }
        return numberSum == numberApply;
    }

    private boolean isGapful(long number) {
        return number >= 100
                && (number % ((int) (number / (Math.pow(10,
                (int) Math.log10(number)))) * 10 + number % 10) == 0);
    }

    private boolean isPalindromic(long number) {
        String palindromicNumber = Long.toString(number);
        StringBuilder reverseNumber = new StringBuilder(palindromicNumber);
        reverseNumber.reverse();
        return palindromicNumber.equals(reverseNumber.toString());
    }

    private boolean isDuckNumber(long number) {
        String duckNumber = Long.toString(number);
        return duckNumber.contains("0");
    }

    private boolean isEven(long number) {
        return number % 2 == 0;
    }

    private boolean isOdd(long number) {
        return number % 2 != 0;
    }

    private boolean isBuzzNumber(long number) {
        if (number % 7 == 0 && number % 10 == 7) {
            return true;
        } else if (number % 7 == 0 && number % 10 != 7) {
            return true;
        } else return number % 7 != 0 && number % 10 == 7;
    }
}