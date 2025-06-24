
import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String name;
    double amount;

    Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + ": " + amount;
    }

}
public class Main {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. Show expenses");
            System.out.println("3. Show total");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                expenses.add(new Expense(name, amount));
                System.out.println("Added!");

            } else if (choice == 2) {
                for (Expense e : expenses) {
                    System.out.println(e);
                }

            } else if (choice == 3) {
                double total = 0;
                for (Expense e : expenses) {
                    total += e.amount;
                }
                System.out.println("Total: " + total);

            } else if (choice == 4) {
                System.out.println("Exit");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

