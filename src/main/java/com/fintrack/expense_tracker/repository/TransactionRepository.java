package com.fintrack.expense_tracker.repository;

import com.fintrack.expense_tracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}