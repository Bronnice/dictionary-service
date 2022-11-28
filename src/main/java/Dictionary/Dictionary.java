package Dictionary;

import java.io.*;

public class Dictionary{

    public DataSource dataSource;
    private Validator validator;

    public Dictionary(String path, String fileName, Validator validator){
        final File file = new File(path, (fileName + ".json"));
        this.validator = validator;
        this.dataSource = new DataSource(file, this);
    }

    public Validator getValidator() {
        return validator;
    }
}