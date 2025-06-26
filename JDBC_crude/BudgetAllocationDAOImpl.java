package JDBC_crude;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetAllocationDAOImpl implements BudgetAllocationDAO {

    private Connection conn;

    public BudgetAllocationDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addBudgetItem(BudgetAllocation budget) {
        String sql = "INSERT INTO budget_allocations (event_id, item, amount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, budget.getEventId());
            stmt.setString(2, budget.getItem());
            stmt.setDouble(3, budget.getAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BudgetAllocation getBudgetItemById(int id) {
        String sql = "SELECT * FROM budget_allocations WHERE budget_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractBudget(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BudgetAllocation> getBudgetItemsByEventId(int eventId) {
        List<BudgetAllocation> list = new ArrayList<>();
        String sql = "SELECT * FROM budget_allocations WHERE event_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(extractBudget(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateBudgetItem(BudgetAllocation budget) {
        String sql = "UPDATE budget_allocations SET event_id = ?, item = ?, amount = ? WHERE budget_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, budget.getEventId());
            stmt.setString(2, budget.getItem());
            stmt.setDouble(3, budget.getAmount());
            stmt.setInt(4, budget.getBudgetId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBudgetItem(int id) {
        String sql = "DELETE FROM budget_allocations WHERE budget_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private BudgetAllocation extractBudget(ResultSet rs) throws SQLException {
        return new BudgetAllocation(
                rs.getInt("budget_id"),
                rs.getInt("event_id"),
                rs.getString("item"),
                rs.getDouble("amount")
        );
    }
}
