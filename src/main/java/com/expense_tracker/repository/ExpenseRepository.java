package com.expense_tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense_tracker.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense , Integer> {

	List<Expense> findAll();
	
	Expense save(Expense expense);
	
	Optional<Expense> findById(Integer id);
	
	void delete(Expense expense);
}
