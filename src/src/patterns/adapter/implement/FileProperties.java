package patterns.adapter.implement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class FileProperties implements FileIO {
    Properties properties = new Properties();

    public FileProperties() {

    }
    @Override
    public void readFromFile(String fileName) throws IOException {
        properties.load(new FileReader(fileName));
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        properties.store(new FileWriter(fileName), "written by FileProperties");
    }


    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key, "");
    }
}
