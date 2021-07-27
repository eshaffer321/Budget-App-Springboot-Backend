package co.commandyourmoney.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Iterables;

import co.commandyourmoney.backend.model.Budget;
import co.commandyourmoney.backend.model.Transaction;
import co.commandyourmoney.backend.repository.BudgetRepository;

@Configuration
public class TransactionService {

	@Autowired
	private BudgetRepository repository;

	public Optional<Budget> findById(String id) {
		return this.repository.findById(id);
	}
	
	public Budget findByDate(String date) {
		return Iterables.getOnlyElement(this.repository.findBudgetByDateAndUserId(date));
	}

	public Transaction createTransaction(String bugdetItemId, Transaction person) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
