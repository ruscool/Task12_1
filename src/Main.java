import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        TaskNumber numberTask = new TaskNumber();

        taskOne(numberTask);

        taskTwo(numberTask);

    }

    static void taskOne(TaskNumber numberTask) {
        numberTask.printNumberTask("12.1.1");
        Path inputFile = Paths.get("files/input.txt"); // Замените на путь к вашему исходному файлу
        Path outputFile = Paths.get("files/output.txt"); // Замените на путь к файлу, в который будет записан результат

        try {
            TextFileProcessor.convertTextFileToUpperCase(inputFile, outputFile);
            System.out.println("Файл успешно обработан и записан в " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void taskTwo(TaskNumber numberTask) {
        numberTask.printNumberTask("12.1.2");
        FileCommanderApp taskTwo = new FileCommanderApp();
        taskTwo.startCommandLoop();

    }
}