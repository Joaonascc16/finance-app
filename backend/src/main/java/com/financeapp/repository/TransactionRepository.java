package com.financeapp.repository;

import com.financeapp.entity.Transaction;
import com.financeapp.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    @Query("SELECT t FROM Transaction t WHERE YEAR(t.date) = :year AND MONTH(t.date) = :month ORDER BY t.date DESC")
    List<Transaction> findByMonth(@Param("year") int year, @Param("month") int month);
    
    @Query("SELECT t FROM Transaction t WHERE YEAR(t.date) = :year AND MONTH(t.date) = :month AND t.type = :type ORDER BY t.date DESC")
    List<Transaction> findByMonthAndType(@Param("year") int year, @Param("month") int month, @Param("type") TransactionType type);
    
    @Query("SELECT t FROM Transaction t WHERE t.date BETWEEN :startDate AND :endDate ORDER BY t.date DESC")
    List<Transaction> findByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT t FROM Transaction t WHERE t.category.id = :categoryId ORDER BY t.date DESC")
    List<Transaction> findByCategory(@Param("categoryId") Long categoryId);
}
