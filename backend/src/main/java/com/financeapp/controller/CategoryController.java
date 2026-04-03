package com.financeapp.controller;

import com.financeapp.dto.CategoryDTO;
import com.financeapp.entity.CategoryType;
import com.financeapp.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class CategoryController {
    
    private final CategoryService categoryService;
    
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(dto));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
    
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    
    @GetMapping("/type/{type}")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByType(@PathVariable CategoryType type) {
        return ResponseEntity.ok(categoryService.getCategoriesByType(type));
    }
    
    @PostMapping("/initialize")
    public ResponseEntity<Void> initializeDefaultCategories() {
        categoryService.initializeDefaultCategories();
        return ResponseEntity.ok().build();
    }
}
