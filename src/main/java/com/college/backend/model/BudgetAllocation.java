package com.college.backend.model;

public record BudgetAllocation (
        int budgetid,
        int eventid,
        String item,
        double amount
) {}
