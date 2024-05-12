import java.io.*;
import java.nio.file.*;

public class TextFileProcessor {

    public static void convertTextFileToUpperCase(Path inputFile, Path outputFile) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(inputFile);
             BufferedWriter writer = Files.newBufferedWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String upperCaseLine = line.toUpperCase() + System.lineSeparator();
                writer.write(upperCaseLine);
            }
        }
    }
}