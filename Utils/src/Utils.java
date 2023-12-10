import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Utils {

    // a. Phương thức đọc nội dung từ file
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // b. Phương thức ghi nội dung vào file, xóa nội dung cũ
    public static void writeContentToFile(String path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // c. Phương thức ghi nội dung vào cuối file
    public static void appendContentToFile(String path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // d. Phương thức tìm file trong thư mục
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }
}
