import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private static final String FILE_LOGGER_NAME = "fileOutput.txt";

    static {

        File fileLogger = new File(FILE_LOGGER_NAME);

        try {
            if (fileLogger.exists()) {
                fileLogger.delete();
                fileLogger.createNewFile();
            } else {
                fileLogger.createNewFile();
            }
        } catch (IOException e) {
            System.out.printf("%n");
        }
    }

    @Override
    public void log(String message) {

        try {

            FileWriter writeToFile = new FileWriter(FILE_LOGGER_NAME, true);
            writeToFile.write(message);
            writeToFile.write("\n");
            writeToFile.close();

        } catch (IOException ex) {
            System.out.printf("%n");
        }
    }
}
