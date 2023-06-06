package encryptdecrypt.file;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public static void messageToFile(String text, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
        }
    }

    public static String messageFromFile(String in) {
        String message = null;

        try {
            message = Files.readString(Paths.get(in));
        } catch (IOException e) {
            System.out.println("Error");

        }
        return message;
    }
}