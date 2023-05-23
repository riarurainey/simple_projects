package java_version;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Converter {
    File directory = new File("small_directory.txt");
    File find = new File("small_find.txt");

    void convertDirectoryFromString(List<Person> phoneBook) {
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String number = scanner.next();
                String name = scanner.nextLine();
                phoneBook.add(new Person(name.trim(), number));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void convertFindListFromString(List<String> findList) {
        try (Scanner scanner = new Scanner(find)) {
            while (scanner.hasNext()) {
                String dir = scanner.nextLine();
                findList.add(dir);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
