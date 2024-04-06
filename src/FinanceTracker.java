import java.time.LocalDate;
import java.util.*;


public class FinanceTracker {
    private static final List<Transaction> transactions = new ArrayList<>();
    private static final Map<String, Double> categories = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Enter the Income : ");


        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTransaction(scanner);
                    break;
                case 2:
                    editTransaction(scanner);
                    break;
                case 3:
                    categorizeTransactions(scanner);
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
    private static void displayMenu() {
        System.out.println("Personal Finance Tracker");
        System.out.println("1. Add a new transaction");
        System.out.println("2. Edit a transaction");
        System.out.println("3. Categorize transactions");
        System.out.println("4. Generate report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void addTransaction(Scanner scanner) {
        System.out.print("Enter transaction date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter transaction description: ");
        String description = scanner.nextLine();
        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Transaction transaction = new Transaction(date, description, amount);
        transactions.add(transaction);
        System.out.println("Transaction added successfully.");
    }
    private static void editTransaction(Scanner scanner) {
        System.out.print("Enter the index of the transaction to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < transactions.size()) {
            Transaction transaction = transactions.get(index);
            System.out.print("Enter new transaction date (yyyy-MM-dd): ");
            transaction.setDate(LocalDate.parse(scanner.nextLine()));
            System.out.print("Enter new transaction description: ");
            transaction.setDescription(scanner.nextLine());
            System.out.print("Enter new transaction amount: ");
            transaction.setAmount(scanner.nextDouble());
            scanner.nextLine();
            System.out.println("Transaction updated successfully.");
        } else {
            System.out.println("Invalid transaction index.");
        }
    }
    private static void categorizeTransactions(Scanner scanner) {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();
        System.out.print("Enter total amount for the category: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        categories.put(category, amount);
        System.out.println("Category added successfully.");
    }

    private static void generateReport() {
        double totalIncome = 0.0;
        double totalExpenses = 0.0;

        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
            if (transaction.getAmount() >= 0) {
                totalIncome += transaction.getAmount();
            } else {
                totalExpenses += -transaction.getAmount();
            }
        }

        System.out.println("\nCategories:");
        for (Map.Entry<String, Double> entry : categories.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        double netBalance = totalIncome - totalExpenses;
        System.out.println("\nSummary:");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Net Balance: $" + netBalance);
    }
}

