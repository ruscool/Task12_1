import java.util.*;

public class FileCommanderApp {
    private CommandExecutor commandExecutor = new CommandExecutor();

    public void startCommandLoop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (help-помощь):");
            String commandLine = scanner.nextLine();

            if (commandLine.equalsIgnoreCase("exit")) {
                break;
            }

            handleCommand(commandLine);
        }
        scanner.close();
    }

    private void handleCommand(String commandLine) {
        String[] parts = commandLine.split(" ", 3);
        String command = parts[0].toLowerCase();

        try {
            switch (command) {
                case "create":
                    if ("folder".equals(parts[1])) {
                        commandExecutor.createFolder(parts[2]);
                    }
                    break;
                case "check":
                    if ("existence".equals(parts[1])) {
                        commandExecutor.checkExistence(parts[2]);
                    }
                    break;
                case "write":
                    if ("file".equals(parts[1])) {
                        String[] splitContent = parts[2].split(" ", 2);
                        commandExecutor.writeFile(splitContent[0], splitContent[1]);
                    }
                    break;
                case "read":
                    if ("file".equals(parts[1])) {
                        commandExecutor.readFile(parts[2]);
                    }
                    break;
                case "delete":
                    commandExecutor.delete(parts[1]);
                    break;
                case "help":
                    commandExecutor.help();
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
