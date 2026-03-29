package com.financeapp.dto;

import com.financeapp.entity.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {
    
    private Long id;
    
    @NotNull(message = "Tipo é obrigatório")
    private TransactionType type;
    
    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    private BigDecimal amount;
    
    @NotBlank(message = "Descrição é obrigatória")
    private String description;
    
    @NotNull(message = "Categoria é obrigatória")
    private Long categoryId;
    
    private String categoryName;
    private String categoryIcon;
    
    @NotNull(message = "Data é obrigatória")
    private LocalDateTime date;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
