package java_version;
import java.util.HashMap;
import java.util.List;


public class Search {
    Info info = new Info();

    void linearSearch(List<Person> directoryList, List<String> findList, boolean printResult) {
        int count = 0;
        int namesCount = findList.size();

        info.startSearch();

        for (String findStr : findList) {
            for (Person person : directoryList) {
                if (person.getName().equals(findStr)) {
                    count++;
                    break;
                }
            }
        }


        info.endSearchTime();
        info.printFoundEntries(count, namesCount);
        if (printResult) {
            info.printLinearSearchTime();
        }
    }

    void jumpSearch(List<Person> phoneBook, List<String> findList) {
        int count = 0;

        info.startSearch();
        for (int i = 0; i < findList.size(); i++) {
            String element = findList.get(i);
            int blockSize = (int) Math.floor(Math.sqrt(phoneBook.size()));
            int currentLastIndex = blockSize - 1;
            while (currentLastIndex < phoneBook.size() && element.compareTo(phoneBook.get(currentLastIndex).getName()) > 0) {
                currentLastIndex += blockSize;
            }

            for (int currentSearchIndex = currentLastIndex - blockSize + 1;
                 currentSearchIndex <= currentLastIndex && currentSearchIndex < phoneBook.size();
                 currentSearchIndex++) {
                if (phoneBook.get(currentSearchIndex).getName().equals(element)) {
                    count++;
                    break;
                }
            }
        }
        info.endSearchTime();
        info.printFoundEntries(count, findList.size());
        info.printAllTime();

    }

    void binarySearch(List<Person> phoneBook, List<String> findList) {
        int count = 0;
        info.startSearch();

        for (int i = 0; i < findList.size(); i++) {
            String value = findList.get(i);
            int left = 0;
            int right = phoneBook.size() - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (phoneBook.get(middle).getName().compareTo(value) == 0) {
                    count++;
                    break;

                } else if (phoneBook.get(middle).getName().compareTo(value) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        info.endSearchTime();
        info.printFoundEntries(count, findList.size());
        info.printAllTime();

    }

    void addAndFindInHashMap(List<Person> phoneBook, List<String> findList) {
        int count = 0;

        info.startCreating();
        HashMap<String, String> phoneBookMap = new HashMap<>();

        for (Person p : phoneBook) {
            phoneBookMap.put(p.getName(), p.getNumber());
        }

        info.endCreating();
        info.startSearch();

        for (String findElement : findList) {
            if (phoneBookMap.containsKey(findElement)) {
                count++;
            }
        }

        info.endSearchTime();
        info.printFoundEntries(count, findList.size());
        info.printHashMapTime();

    }
}
