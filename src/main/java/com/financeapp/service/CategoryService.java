package com.financeapp.service;

import com.financeapp.dto.CategoryDTO;
import com.financeapp.entity.Category;
import com.financeapp.entity.CategoryType;
import com.financeapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;
    
    @Transactional
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = Category.builder()
            .name(dto.getName())
            .icon(dto.getIcon())
            .type(dto.getType())
            .color(dto.getColor())
            .build();
        
        Category saved = categoryRepository.save(category);
        return mapToDTO(saved);
    }
    
    @Transactional(readOnly = true)
    public CategoryDTO getCategory(Long id) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return mapToDTO(category);
    }
    
    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategoriesByType(CategoryType type) {
        return categoryRepository.findByType(type).stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional
    public void initializeDefaultCategories() {
        if (categoryRepository.count() == 0) {
            List<Category> defaultCategories = List.of(
                // Despesas
                Category.builder().name("Alimentação").icon("🍔").type(CategoryType.EXPENSE).color("#F97316").build(),
                Category.builder().name("Moradia").icon("🏠").type(CategoryType.EXPENSE).color("#8B5CF6").build(),
                Category.builder().name("Transporte").icon("🚗").type(CategoryType.EXPENSE).color("#3B82F6").build(),
                Category.builder().name("Saúde").icon("💊").type(CategoryType.EXPENSE).color("#EF4444").build(),
                Category.builder().name("Lazer").icon("🎮").type(CategoryType.EXPENSE).color("#EC4899").build(),
                Category.builder().name("Vestuário").icon("👗").type(CategoryType.EXPENSE).color("#F59E0B").build(),
                Category.builder().name("Educação").icon("📚").type(CategoryType.EXPENSE).color("#06B6D4").build(),
                Category.builder().name("Contas").icon("💡").type(CategoryType.EXPENSE).color("#84CC16").build(),
                Category.builder().name("Compras").icon("🛒").type(CategoryType.EXPENSE).color("#F43F5E").build(),
                Category.builder().name("Outros Gastos").icon("💸").type(CategoryType.EXPENSE).color("#94A3B8").build(),
                // Receitas
                Category.builder().name("Salário").icon("💼").type(CategoryType.INCOME).color("#22C55E").build(),
                Category.builder().name("Investimentos").icon("📈").type(CategoryType.INCOME).color("#10B981").build(),
                Category.builder().name("Presente").icon("🎁").type(CategoryType.INCOME).color("#A78BFA").build(),
                Category.builder().name("Freelance").icon("🔧").type(CategoryType.INCOME).color("#34D399").build(),
                Category.builder().name("Outras Receitas").icon("💰").type(CategoryType.INCOME).color("#6EE7B7").build()
            );
            categoryRepository.saveAll(defaultCategories);
        }
    }
    
    private CategoryDTO mapToDTO(Category category) {
        return CategoryDTO.builder()
            .id(category.getId())
            .name(category.getName())
            .icon(category.getIcon())
            .type(category.getType())
            .color(category.getColor())
            .build();
    }
}
