package Main;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class TaskListClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            TaskList taskList = (TaskList) registry.lookup("TaskList");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("----------------Available Methods---------------------");
                System.out.println("1. Add Task");
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. Get Task List");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        taskList.addTask(task);
                        break;
                    case 2:
                        System.out.print("Enter index of task to remove: ");
                        int index = scanner.nextInt();
                        taskList.removeTask(index);
                        break;
                    case 3:
                        List<String> taskListResult = taskList.getTaskList();
                        System.out.println("Task List:");
                        for (int i = 0; i < taskListResult.size(); i++) {
                            System.out.println(i + ". " + taskListResult.get(i));
                        }
                        break;
                    case 4:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
