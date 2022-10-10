import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

    private final HashMap<String, String> dictionary = new HashMap<>();
    private final File file = new File("C://", "Dictionary");
    private final FileReader fileReader = new FileReader(file);
    private final Scanner scanner = new Scanner(fileReader);
    private final FileWriter fileWriter;

    public Dictionary() throws IOException {
        fileWriter = new FileWriter(file);
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }

    public String readFromFile() {
        while (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }

    public void addIssue(String key, String value) throws IOException {
        dictionary.put(key, value);
        fileWriter.write(dictionary.toString());
    }

    public void deleteIssue(String key) throws IOException {
        if (dictionary.containsKey(key)) {
            dictionary.remove(key);
            fileWriter.write(dictionary.toString());
        } else
            System.out.println("Ключ не найден");
    }

    public boolean findByKey(String key) {
        if (dictionary.containsKey(key)) {
            while (scanner.hasNextLine()) {
                if (scanner.hasNext(key))
                    return true;
                else
                    scanner.nextLine();
            }
            return true;
        } else
            System.out.println("Ключ не найден");
            return false;
    }
}