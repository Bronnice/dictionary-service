package Dictionary;

import com.google.gson.*;

import java.io.*;
import java.util.HashMap;

public class DataSource {
    private HashMap<String, String> dictionary = new HashMap<>();
    private final File file;
    private static final GsonBuilder builder = new GsonBuilder();
    private static final Gson gson = builder.create();


    public DataSource(File file) {
        this.file = file;
    }

    public void addIssue(String key, String value) {
        try (FileWriter fw = new FileWriter(file.getName())) {
            if (!dictionary.containsKey(key)) {
                dictionary.put(key, value);
                fw.write(gson.toJson(dictionary));
            } else
                return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteIssue(String key) {

        try (FileWriter fw = new FileWriter(file.getName())) {
            if (dictionary.containsKey(key)) {
                dictionary.remove(key);
                fw.write(gson.toJson(dictionary));
            } else
                return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String key) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getName()));
            dictionary = gson.fromJson(br, HashMap.class);
            br.close();
            if (dictionary.containsKey(key))
                return "\"" + key + "\"" + ":" + "\"" + dictionary.get(key) + "\"";
            else
                throw new IOException();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public boolean findByKey(String key) {
        readFromFile(key);
        return dictionary.containsKey(key);
    }
}
