package Dictionary;

import java.io.*;

public class Dictionary{

    public DataSource dataSource;

    public Dictionary(String path, String fileName, Validator validator){
        final File file = new File(path, (fileName + ".json"));
        this.dataSource = new DataSource(file, validator);
    }
}