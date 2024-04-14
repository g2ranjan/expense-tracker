package com.expense_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense_tracker.entity.Expense;
import com.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> findAll(){
		return expenseRepository.findAll();
	}

	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense findById(Integer id) {
		if(expenseRepository.findById(id).isPresent())
			return expenseRepository.findById(id).get();
		return null;
	}
	
	public void delete(Integer id) {
		Expense expense = findById(id);
		expenseRepository.delete(expense);
	}
}
