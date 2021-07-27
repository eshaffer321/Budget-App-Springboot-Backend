package co.commandyourmoney.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.commandyourmoney.backend.model.Budget;

public interface TransactionRepository extends MongoRepository<Budget, String> {
	  @Query("{'address.country': ?0}")
	  List<Budget> findByCountry(final String country);
}
