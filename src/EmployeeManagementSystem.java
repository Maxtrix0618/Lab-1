import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private final ArrayList<Employee> list = new ArrayList<>();

    public EmployeeManagementSystem() {}

    public void launch() {
        System.out.println(HINT);
        Scanner input = new Scanner(System.in);

        String command = input.nextLine();
        while (!String.valueOf(command).equals("exit")) {
            execute(command);
            command = input.nextLine();
        }
        input.close();
    }

    private void execute(String command) {
        String[] words = command.split(" ");
        switch (words[0]) {
            case "add" -> addEmployee(words);
            case "delete" -> deleteEmployee(words);
            case "print-all" -> printAll();
            default -> System.out.println("Invalid input!");
        }
    }

    private void addEmployee(String[] words) {
        if (words.length < 3) {
            System.out.println("Invalid input!");
            return;
        }
        for (Employee e : list)
            if (e.getName().equals(words[1])) {
                System.out.println("Name existed. Try another.");
                return;
            }
        list.add(new Employee(words[1], Integer.parseInt(words[2])));
        System.out.println("Successfully add a new employee.");
    }

    private void deleteEmployee(String[] words) {
        if (words.length < 2) {
            System.out.println("Invalid input!");
            return;
        }
        for (Employee e : list)
            if (e.getName().equals(words[1])) {
                list.remove(e);
                System.out.println("Successfully delete the employee.");
                return;
            }
        System.out.println("This employee was not found.");
    }

    private void printAll() {
        Collections.sort(list);
        System.out.println("Order | Name | Age");
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i+1) + " | ");
            System.out.println(list.get(i));
        }
    }

    private static final String HINT = """
            'add <name> <age>' : add a new employee,
            'delete <name> : delete the employee,
            'print-all' : print the info of all employees,
            'exit' : exit from the system.
            """;


    public static void main(String[] args) {
        EmployeeManagementSystem EMS = new EmployeeManagementSystem();
        EMS.launch();
    }
}
