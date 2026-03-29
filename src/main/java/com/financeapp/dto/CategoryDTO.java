package com.financeapp.dto;

import com.financeapp.entity.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    
    @NotBlank(message = "Ícone é obrigatório")
    private String icon;
    
    @NotNull(message = "Tipo é obrigatório")
    private CategoryType type;
    
    @NotBlank(message = "Cor é obrigatória")
    private String color;
}
