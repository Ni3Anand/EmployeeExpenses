package com.application.domain;

public class ExpenseItem {
    private Integer id;
    private Integer claimId;
    private ExpenseType expenseType;
    private String description;
    private Double amount;

    public ExpenseItem(Integer id, Integer claimId, ExpenseType expenseType, String description, Double amount) {
        this.id = id;
        this.claimId = claimId;
        this.expenseType = expenseType;
        this.description = description;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }
}
