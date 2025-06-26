package JDBC_crude;

public class BudgetAllocation {
    private int budgetId;
    private int eventId;
    private String item;
    private double amount;

    public BudgetAllocation() {}

    public BudgetAllocation(int budgetId, int eventId, String item, double amount) {
        this.budgetId = budgetId;
        this.eventId = eventId;
        this.item = item;
        this.amount = amount;
    }

    // Getters and Setters
    public int getBudgetId() { return budgetId; }
    public void setBudgetId(int budgetId) { this.budgetId = budgetId; }

    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
