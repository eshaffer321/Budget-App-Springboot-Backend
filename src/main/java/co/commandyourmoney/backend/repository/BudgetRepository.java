package co.commandyourmoney.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.commandyourmoney.backend.model.Budget;

public interface BudgetRepository extends MongoRepository<Budget, String> {
	
	@Query("{ 'date' : ?0 }")
	List<Budget> findBudgetByDateAndUserId(String date);
	
	Optional<Budget> findById(String id);
}
