package co.commandyourmoney.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("v1/budget-item")
public class BudgetItemController {
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
