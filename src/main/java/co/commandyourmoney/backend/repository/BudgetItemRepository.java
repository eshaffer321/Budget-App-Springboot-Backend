package co.commandyourmoney.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.commandyourmoney.backend.model.Budget;
import co.commandyourmoney.backend.model.BudgetItem;

public interface BudgetItemRepository extends MongoRepository<Budget, String> {

	@Query("{\n"
			+ "    budgetCategories: [\n"
			+ "        {\n"
			+ "            budgetItems: [\n"
			+ "                {\n"
			+ "                    '_id': ?0"
			+ "                }\n"
			+ "            ]\n"
			+ "        }\n"
			+ "    ]\n"
			+ "}")
	public BudgetItem findByBudgetItemId(String firstName);
	
}