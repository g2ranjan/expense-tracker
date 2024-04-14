package com.expense_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense_tracker.entity.Expense;
import com.expense_tracker.service.ExpenseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public ResponseEntity<List<Expense>> getExpenses(){		
		List<Expense> expenses = expenseService.findAll();
		return new ResponseEntity<List<Expense>>(expenses , HttpStatus.OK);
	}
	
	@PostMapping("/expenses")
	public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense){
		return new ResponseEntity<Expense>(expenseService.saveExpense(expense),HttpStatus.OK);
	}

	@GetMapping("expenses/{id}")
	public ResponseEntity<Expense> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<Expense>(expenseService.findById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("expenses/id")
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		expenseService.delete(id);
		return new ResponseEntity<String>("Expense is Deleted Sucessfully" , HttpStatus.OK);
	}
}
