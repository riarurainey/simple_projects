package java_version;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Person> phoneBook = new ArrayList<>();
        List<String> findList = new ArrayList<>();

        Converter converter = new Converter();
        converter.convertDirectoryFromString(phoneBook);
        converter.convertFindListFromString(findList);

        Search search = new Search();
        System.out.println("Start searching (linear search)...");
        search.linearSearch(phoneBook, findList, true);

        Sort sort = new Sort();
        System.out.println("Start searching (bubble sort + jump search)...");
        sort.bubbleSort(phoneBook, findList);

        System.out.println("Start searching (quick sort + binary search)...");
        sort.startQuickSortAndBinarySearch(phoneBook, findList, 0, phoneBook.size() - 1);

        System.out.println("Start searching (hash map)...");
        search.addAndFindInHashMap(phoneBook, findList);

    }
}