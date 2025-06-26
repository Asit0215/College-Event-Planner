package JDBC_crude;

import java.util.List;

public interface BudgetAllocationDAO {
    void addBudgetItem(BudgetAllocation budget);
    BudgetAllocation getBudgetItemById(int id);
    List<BudgetAllocation> getBudgetItemsByEventId(int eventId);
    void updateBudgetItem(BudgetAllocation budget);
    void deleteBudgetItem(int id);
}
