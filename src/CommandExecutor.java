import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class CommandExecutor {

    public void createFolder(String pathStr) throws IOException {
        Path path = Paths.get(pathStr);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
            System.out.println("Папка создана: " + path);
        } else {
            System.out.println("Папка уже существует: " + path);
        }
    }

    public void checkExistence(String pathStr) {
        Path path = Paths.get(pathStr);
        if (Files.exists(path)) {
            System.out.println("Существует: " + path);
        } else {
            System.out.println("Не существует: " + path);
        }
    }

    public void writeFile(String pathStr, String content) throws IOException {
        Path path = Paths.get(pathStr);
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        System.out.println("Файл записан: " + path);
    }

    public void readFile(String pathStr) throws IOException {
        Path path = Paths.get(pathStr);
        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        System.out.println("Содержимое файла: " + content);
    }

    public void delete(String pathStr) throws IOException {
        Path path = Paths.get(pathStr);
        Files.deleteIfExists(path);
        System.out.println("Удален: " + path);
    }
    public void help() throws IOException {
        System.out.println("Примеры команд:\n" +
                "\n" +
                "create folder C:\\myfolder - создает новую папку myfolder в директории C:\\.\n" +
                "\n" +
                "check existence C:\\myfolder - проверяет существование папки или файла myfolder по указанному пути.\n" +
                "\n" +
                "write file C:\\myfile.txt This is the content - создает новый текстовый файл myfile.txt и записывает в него текст \"This is the content\".\n" +
                "\n" +
                "read file C:\\myfile.txt - считывает содержимое текстового файла myfile.txt и выводит его на экран.\n" +
                "\n" +
                "delete C:\\myfile.txt - удаляет файл myfile.txt по указанному пути.\n" +
                "\n" +
                "exit - выход");
    }
}
