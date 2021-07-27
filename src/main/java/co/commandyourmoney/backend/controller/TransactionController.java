package co.commandyourmoney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.commandyourmoney.backend.model.Transaction;
import co.commandyourmoney.backend.service.TransactionService;

@RestController()
@RequestMapping("v1/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
//	@PostMapping(value = "/create/{bugdetItemId}", consumes = "application/json", produces = "application/json")
//	public Transaction createTransaction(@PathVariable String bugdetItemId, @RequestBody Transaction transaction) {
//		return transactionService.createTransaction(bugdetItemId, transaction);
//	}
}
