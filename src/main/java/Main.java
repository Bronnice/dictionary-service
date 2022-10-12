import Dictionary.*;

public class Main {
    public static void main(String[] args){
        Validator validator1 = new Validator(6, WordType.EnglishWithNums);
        Dictionary dictionary = new Dictionary("C:\\Users\\Константин\\Documents\\Учёба\\Java\\dictionary-service", "dic", validator1);

        dictionary.dataSource.addIssue("Word1", "value1");
        dictionary.dataSource.addIssue("Word1", "value1");
        dictionary.dataSource.addIssue("WordABC1", "value1");
        dictionary.dataSource.addIssue("Word2", "value2");
        dictionary.dataSource.addIssue("Word3", "value3");
        dictionary.dataSource.addIssue("Word4", "value4");

        System.out.println("\nВывод пар добавленных ключей в формате json:\n" + dictionary.dataSource.readCoupleFromFile("Word1"));
        System.out.println(dictionary.dataSource.readCoupleFromFile("Word2"));
        System.out.println(dictionary.dataSource.readCoupleFromFile("Word3"));
        System.out.println(dictionary.dataSource.readCoupleFromFile("Word4"));

        System.out.println("\nПоиск по существующему ключу Word3: " + dictionary.dataSource.findByKey("Word3"));
        System.out.println("Поиск по несуществующему ключу Word5: " + dictionary.dataSource.findByKey("Word5"));

        dictionary.dataSource.deleteIssue("Word2");
        System.out.println("Поиск по удалённому ключу Word2: " + dictionary.dataSource.findByKey("Word2"));
        System.out.println("Поиск по удалённому ключу Word2 в формате json: " + dictionary.dataSource.readCoupleFromFile("Word2"));
    }
}
