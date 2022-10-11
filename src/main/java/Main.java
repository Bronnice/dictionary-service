import Dictionary.Dictionary;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Dictionary dictionary = new Dictionary("C:\\Users\\Константин\\Documents\\Учёба\\Java\\dictionary-service", "dic");

        dictionary.dataSource.addIssue("Word1", "value1");
        dictionary.dataSource.addIssue("Word2", "value2");
        dictionary.dataSource.addIssue("Word3", "value3");
        dictionary.dataSource.addIssue("Word4", "value4");

        System.out.println(dictionary.dataSource.readFromFile("Word1"));
        System.out.println(dictionary.dataSource.readFromFile("Word2"));
        System.out.println(dictionary.dataSource.readFromFile("Word3"));
        System.out.println(dictionary.dataSource.readFromFile("Word4"));

        System.out.println(dictionary.dataSource.findByKey("Word3"));
        System.out.println(dictionary.dataSource.findByKey("Word5"));

        dictionary.dataSource.deleteIssue("Word2");
        System.out.println(dictionary.dataSource.findByKey("Word2"));
        System.out.println(dictionary.dataSource.readFromFile("Word2"));
    }
}
