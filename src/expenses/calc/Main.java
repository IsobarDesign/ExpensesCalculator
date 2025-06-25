package expenses.calc;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {
    public static void main(final String[] args) {
        final ArrayList<Expense> expenses = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. Show expenses");
            System.out.println("3. Show total");
            System.out.println("4. Exit");
            int choice = readInt(scanner , "Choice: ");
            //readint instead of scanner.nextInt 

            
            if (choice == 1) {
                System.out.print("Enter name: ");
                final String name = scanner.nextLine();
                System.out.print("Enter amount: ");
                final double amount = readDouble(scanner , "Enter amount");
                // read double instead of nextDouble 
                Expense newExpense = new Expense(name, amount);
                expenses.add(newExpense);
                saveToFile(newExpense);
                System.out.println("Added!");

            } else if (choice == 2) {
                for (final Expense e : expenses) {
                    System.out.println(e);
                }

            } else if (choice == 3) {
                double total = 0;
                for (final Expense e : expenses) {
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


private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid amount.");
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
    }

private static void saveToFile( final Expense expense ){
    try(FileWriter writer = new FileWriter("expenses.txt", true)){
        writer.write(expense.toString()+System.lineSeparator());
    } catch(final IOException e) {
        System.out.println("Error saving to file : "+ e.getMessage());

    }
  
    }
}