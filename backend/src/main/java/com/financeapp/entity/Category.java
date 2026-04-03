package com.financeapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome da categoria é obrigatório")
    @Column(unique = true, nullable = false)
    private String name;
    
    @NotBlank(message = "Ícone é obrigatório")
    private String icon;
    
    @NotNull(message = "Tipo é obrigatório")
    @Enumerated(EnumType.STRING)
    private CategoryType type;
    
    @NotBlank(message = "Cor é obrigatória")
    private String color;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}

enum CategoryType {
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
