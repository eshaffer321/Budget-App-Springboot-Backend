package co.commandyourmoney.backend.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Budget {

	@Id
	private String id;

	private String date;
	
	private BudgetGroup income;
	
	private String currency;
	
	private List<BudgetGroup> budgetCategories;
	
	private List<String> userIds;

	public Budget() {}

	public Budget(String date, BudgetGroup income, List<BudgetGroup> budgetCategories,List<String> userIds) {
		this.date = date;
		this.income = income;
		this.budgetCategories = budgetCategories;
		this.userIds = userIds;
	}
	
	public void addUserId(String userId) {
		userIds.add(userId);
	}
	
	public void addBugetGroup(BudgetGroup group) {
		budgetCategories.add(group);
	}

}
