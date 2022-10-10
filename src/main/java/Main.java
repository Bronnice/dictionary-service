import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dic = new Dictionary();

        dic.addIssue("Word1", "value1");
        dic.addIssue("Word2", "value2");
        dic.addIssue("Word3", "value3");
        dic.addIssue("Word4", "value4");

        System.out.println(dic.readFromFile());
        System.out.println(dic.getDictionary());

        dic.deleteIssue("Word2");
        dic.deleteIssue("Word5");

        System.out.println(dic.readFromFile());
        System.out.println(dic.getDictionary());

        System.out.println(dic.findByKey("Word1"));
        System.out.println(dic.findByKey("Word2"));
    }
}
