package Dictionary;

import java.io.*;

public class Dictionary{

    public DataSource dataSource;

    public Dictionary(String path, String fileName){
        final File file = new File(path, (fileName + ".json"));
        this.dataSource = new DataSource(file);
    }
}