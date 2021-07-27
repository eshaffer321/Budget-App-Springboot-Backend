package co.commandyourmoney.backend.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.commandyourmoney.backend.model.Budget;
import co.commandyourmoney.backend.service.BudgetService;


@RestController()
@RequestMapping("v1/budget")
public class BudgetController {
	
	private static final Logger logger = LoggerFactory.getLogger(BudgetController.class);

	@Autowired
	private final BudgetService budgetService;

	public BudgetController(BudgetService budgetService) {
		this.budgetService = budgetService;
	}

	@GetMapping("/{id}")
	public Optional<Budget> findByBudgetId(@PathVariable String id) {
		return this.budgetService.findById(id);
	}
	
	@GetMapping("/date/{date}")
	public Budget findByDate(@PathVariable String date) {
		return this.budgetService.findByDate(date);
	}

}
