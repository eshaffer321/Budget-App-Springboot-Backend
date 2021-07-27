package co.commandyourmoney.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.commandyourmoney.backend.model.Budget;
import co.commandyourmoney.backend.repository.BudgetRepository;

public class BudgetItemService {
	
	@Autowired
	private BudgetRepository repository;

	public Optional<Budget> findById(String id) {
		return this.repository.findById(id);
	}
}
