package java_version;

import java.util.List;

public class Sort {
    Info info = new Info();
    Search search = new Search();

    void bubbleSort(List<Person> phoneBook, List<String> findList) {
        info.startSorting();
        for (int i = 0; i < phoneBook.size() - 1; i++) {
            for (int j = 0; j < phoneBook.size() - i - 1; j++) {
                if (info.currentSortingTime() > info.getLinearSearchTime() * 10) {
                    info.endSorting();
                    search.linearSearch(phoneBook, findList, false);
                    info.printLinearSearchAndBubbleSortTime();
                    return;
                }

                if (phoneBook.get(j).getName().compareTo(phoneBook.get(j + 1).getName()) > 0) {
                    Person tmp = phoneBook.get(j);
                    phoneBook.set(j, phoneBook.get(j + 1));
                    phoneBook.set(j + 1, tmp);
                }
            }
        }
        info.endSorting();
        search.jumpSearch(phoneBook, findList);
    }

    void startQuickSortAndBinarySearch(List<Person> phoneBook, List<String> findList, int low, int high) {
        info.startSorting();
        quickSort(phoneBook, low, high);
        info.endSorting();
        search.binarySearch(phoneBook, findList);
    }

    void quickSort(List<Person> phoneBook, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(phoneBook, low, high);
            quickSort(phoneBook, low, partitionIndex - 1);
            quickSort(phoneBook, partitionIndex + 1, high);
        }
    }

    private static int partition(List<Person> phoneBook, int low, int high) {
        String pivot = phoneBook.get(high).getName();
        int i = (low - 1);

        for (int j = low; j <= high; j++) {
            if (phoneBook.get(j).getName().compareTo(pivot) < 0) {
                i++;
                Person tmp = phoneBook.get(i);
                phoneBook.set(i, phoneBook.get(j));
                phoneBook.set(j, tmp);

            }
        }

        Person tmp = phoneBook.get(i + 1);
        phoneBook.set(i + 1, phoneBook.get(high));
        phoneBook.set(high, tmp);
        return i + 1;

    }
}
