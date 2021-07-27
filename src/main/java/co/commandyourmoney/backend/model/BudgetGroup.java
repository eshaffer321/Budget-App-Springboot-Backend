package co.commandyourmoney.backend.model;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class BudgetGroup {

	@Setter(AccessLevel.NONE)
	public ObjectId id = ObjectId.get();
	private String name;
	private String type;
	private List<BudgetItem> budgetItems;
	private int order;
	
	public void addBudgetItem(BudgetItem item) {
		this.budgetItems.add(item);
	}
}
