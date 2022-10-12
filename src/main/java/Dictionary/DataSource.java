package Dictionary;

import com.google.gson.*;

import java.io.*;
import java.util.HashMap;

public class DataSource {
    private HashMap<String, String> dictionary = new HashMap<>();
    private final File file;
    private static final GsonBuilder builder = new GsonBuilder();
    private static final Gson gson = builder.create();
    private Validator validator;

    public DataSource(File file, Validator validator) {
        this.file = file;
        this.validator = validator;
    }

    private boolean checkWordType(String string) {
        switch (validator.getWordType()) {
            case EnglishWithNums -> {
                string.matches("[a-zA-Z0-9]");
                return true;
            }
            case EnglishNoNums -> {
                string.matches("[a-zA-Z]");
                return true;
            }
            case OnlyNums -> {
                string.matches("[0-9]");
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public void addIssue(String key, String value) {
        try (FileWriter fw = new FileWriter(file.getName())) {
            if (key.length() <= validator.getWordCount() && checkWordType(key) && checkWordType(value) && !dictionary.containsKey(key)) {
                dictionary.put(key, value);
                fw.write(gson.toJson(dictionary));
            } else
                throw new UnsupportedOperationException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteIssue(String key) {
        try (FileWriter fw = new FileWriter(file.getName())) {
            if (dictionary.containsKey(key)) {
                dictionary.remove(key);
                fw.write(gson.toJson(dictionary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAllFromFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getName()));
            dictionary = gson.fromJson(br, HashMap.class);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readCoupleFromFile(String key) {
        try {
            this.readAllFromFile();
            if (dictionary.containsKey(key)) {
                HashMap<String, String> tempMap = new HashMap<>();
                tempMap.put(key, dictionary.get(key));
                return gson.toJson(tempMap);
            }
            else
                throw new IOException();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public boolean findByKey(String key) {
        this.readAllFromFile();
        return dictionary.containsKey(key);
    }
}
