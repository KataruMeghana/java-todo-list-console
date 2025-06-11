import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addTask();
                case 2 -> displayTasks();
                case 3 -> removeTask();
                case 4 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void showMenu() {
        System.out.println("\n=== TO-DO LIST MENU ===");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }

        System.out.print("Remove by (1) Index or (2) Name? Enter 1 or 2: ");
        String option = scanner.nextLine();

        if (option.equals("1")) {
            displayTasks();
            System.out.print("Enter task number to remove: ");
            int index = Integer.parseInt(scanner.nextLine());
            if (index > 0 && index <= tasks.size()) {
                String removed = tasks.remove(index - 1);
                System.out.println("Removed: " + removed);
            } else {
                System.out.println("Invalid index.");
            }
        } else if (option.equals("2")) {
            System.out.print("Enter task name to remove: ");
            String name = scanner.nextLine();
            if (tasks.remove(name)) {
                System.out.println("Removed: " + name);
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
