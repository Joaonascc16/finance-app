package com.financeapp.controller;

import com.financeapp.dto.TransactionDTO;
import com.financeapp.entity.TransactionType;
import com.financeapp.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class TransactionController {
    
    private final TransactionService transactionService;
    
    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@Valid @RequestBody TransactionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(dto));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }
    
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
    
    @GetMapping("/month/{year}/{month}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByMonth(
            @PathVariable int year,
            @PathVariable int month) {
        return ResponseEntity.ok(transactionService.getTransactionsByMonth(year, month));
    }
    
    @GetMapping("/month/{year}/{month}/type/{type}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByMonthAndType(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable TransactionType type) {
        return ResponseEntity.ok(transactionService.getTransactionsByMonthAndType(year, month, type));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(
            @PathVariable Long id,
            @Valid @RequestBody TransactionDTO dto) {
        return ResponseEntity.ok(transactionService.updateTransaction(id, dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
