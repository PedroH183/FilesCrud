package DBManager;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class FileManager {

    public static Path getDatabase(String urlPath, String fileName) {
        Path directory = Path.of(urlPath);

        if (!Files.exists(directory)) {
            try{
                Files.createDirectories(directory);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        String uriConnectToFile = urlPath + fileName;
        Path file = Path.of(uriConnectToFile);

        if (!Files.exists(file)) {
            try{
                Files.createFile(file);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    public static void recreateDatabase(String filePath, List<DataCompatibility> Data) {
        Path file = Path.of(filePath);
        try {
            Files.delete(file);
            Files.createFile(file);

            for (int index = 0; index < Data.size(); index++) {
                Files.writeString(file, Data.get(index).getRawData() + "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}