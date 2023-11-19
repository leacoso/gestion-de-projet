import java.io.*;
import java.util.HashMap;
/*import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;*/

public class DatabaseUtils {

    /*public static void saveToCSV(List<?> objects, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Object obj : objects) {
                if (obj instanceof Student) {
                    writer.write(((Student) obj).toCSVFormat() + "\n");
                }
                // Répétez pour d'autres types d'objets (Lecture, Education, etc.)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /*public static List<Student> loadStudentsFromCSV(String fileName) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromCSVFormat(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }*/

/*private static Gson gson = new Gson();

    public static void saveObjectToFile(Object data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T loadObjectFromFile(String fileName, Class<T> classOfT) {
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, classOfT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/

}


