package tests.homework_3.SelenideAndAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PrivateData {

    public String getPassword() {
        return getPrivateProperty("passwordRepository");
    }

    public String getToken() {
        return getPrivateProperty("authToken");
    }

    private String getPrivateProperty(String key) {
        FileInputStream fis = null;
        Properties property = new Properties();
        String data ="";
        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            property.load(fis);
            data = property.getProperty(key);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

}
