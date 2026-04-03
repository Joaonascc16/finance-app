package com.financeapp.entity;

public enum CategoryType {
    INCOME("Receita"),
    EXPENSE("Despesa"),
    BOTH("Ambos");

    private final String label;

    CategoryType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
