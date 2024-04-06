import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private String description;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private double amount;

    public Transaction(LocalDate date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return date + " - " + description + ": $" + amount;
    }
}
