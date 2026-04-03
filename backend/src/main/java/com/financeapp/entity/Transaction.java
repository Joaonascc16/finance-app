package com.financeapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Tipo de transação é obrigatório")
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    
    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    private BigDecimal amount;
    
    @NotBlank(message = "Descrição é obrigatória")
    @Column(length = 255)
    private String description;
    
    @NotNull(message = "Categoria é obrigatória")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @NotNull(message = "Data é obrigatória")
    private LocalDateTime date;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

enum TransactionType {
    INCOME("Receita"),
    EXPENSE("Despesa");
    
    private final String label;
    
    TransactionType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
}
