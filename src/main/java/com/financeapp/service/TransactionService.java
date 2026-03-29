package com.financeapp.service;

import com.financeapp.dto.TransactionDTO;
import com.financeapp.entity.Category;
import com.financeapp.entity.Transaction;
import com.financeapp.entity.TransactionType;
import com.financeapp.repository.CategoryRepository;
import com.financeapp.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    
    @Transactional
    public TransactionDTO createTransaction(TransactionDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        
        Transaction transaction = Transaction.builder()
            .type(dto.getType())
            .amount(dto.getAmount())
            .description(dto.getDescription())
            .category(category)
            .date(dto.getDate())
            .build();
        
        Transaction saved = transactionRepository.save(transaction);
        return mapToDTO(saved);
    }
    
    @Transactional
    public TransactionDTO updateTransaction(Long id, TransactionDTO dto) {
        Transaction transaction = transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
        
        Category category = categoryRepository.findById(dto.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        
        transaction.setType(dto.getType());
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setCategory(category);
        transaction.setDate(dto.getDate());
        
        Transaction updated = transactionRepository.save(transaction);
        return mapToDTO(updated);
    }
    
    @Transactional
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
    
    @Transactional(readOnly = true)
    public TransactionDTO getTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
        return mapToDTO(transaction);
    }
    
    @Transactional(readOnly = true)
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public List<TransactionDTO> getTransactionsByMonth(int year, int month) {
        return transactionRepository.findByMonth(year, month).stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public List<TransactionDTO> getTransactionsByMonthAndType(int year, int month, TransactionType type) {
        return transactionRepository.findByMonthAndType(year, month, type).stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }
    
    private TransactionDTO mapToDTO(Transaction transaction) {
        return TransactionDTO.builder()
            .id(transaction.getId())
            .type(transaction.getType())
            .amount(transaction.getAmount())
            .description(transaction.getDescription())
            .categoryId(transaction.getCategory().getId())
            .categoryName(transaction.getCategory().getName())
            .categoryIcon(transaction.getCategory().getIcon())
            .date(transaction.getDate())
            .createdAt(transaction.getCreatedAt())
            .updatedAt(transaction.getUpdatedAt())
            .build();
    }
}
