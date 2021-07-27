package co.commandyourmoney.backend.model;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class BudgetItem {

	@Setter(AccessLevel.NONE)
	public ObjectId id = ObjectId.get();
	
	private String name;
	private String amountBudgeted;
	private List<Transaction> transactions;
	
	public void addTransaction(Transaction t) {
		this.transactions.add(t);
	}

}