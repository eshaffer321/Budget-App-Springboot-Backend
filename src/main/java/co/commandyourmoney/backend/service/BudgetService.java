package co.commandyourmoney.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Iterables;

import co.commandyourmoney.backend.model.Budget;
import co.commandyourmoney.backend.repository.BudgetRepository;

@Configuration
public class BudgetService {

	
	private BudgetRepository repository;

	public BudgetService(@Autowired BudgetRepository budgetRepository) {
		this.repository = budgetRepository;
	}

	public Optional<Budget> findById(String id) {
		return this.repository.findById(id);
	}
	
	public Budget findByDate(String date) {
		return Iterables.getOnlyElement(this.repository.findBudgetByDateAndUserId(date));
	}
	
}
