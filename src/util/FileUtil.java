package util;

import java.io.*;
import java.util.Map;
import model.Account;

public class FileUtil {

    @SuppressWarnings("unchecked")
    public static Map<String, Account> loadData(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Map<String, Account>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static void saveData(Map<String, Account> data, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
