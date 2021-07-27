package co.commandyourmoney.backend.integration;

import com.google.common.collect.Lists;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import co.commandyourmoney.backend.controller.BudgetController;
import co.commandyourmoney.backend.model.Budget;
import co.commandyourmoney.backend.model.BudgetGroup;
import co.commandyourmoney.backend.model.BudgetItem;
import co.commandyourmoney.backend.model.Transaction;
import co.commandyourmoney.backend.repository.BudgetRepository;
import co.commandyourmoney.backend.service.BudgetService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;;



@AutoConfigureDataMongo
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BudgetControllerITest {

	private @Autowired BudgetRepository budgetRepository;

	private static BudgetService budgetService;

	private static BudgetController budgetController;

	@BeforeAll
	public void setup() {
		BudgetGroup budgetGroup = new BudgetGroup();
		budgetGroup.setName("Food");
		budgetGroup.setType("expense");

		BudgetItem budgetItem1 = new BudgetItem();
		budgetItem1.setName("Groceries");
		budgetItem1.setAmountBudgeted("80000");

		Transaction transaction = new Transaction();
		transaction.setAmount(40000);
		transaction.setDate("07-01-2021");
		transaction.setMerchant("Costco");

		budgetItem1.setTransactions(Lists.newArrayList(transaction));
		budgetGroup.setBudgetItems(Lists.newArrayList(budgetItem1));

		Budget budget1 = new Budget();
		budget1.setUserIds(Lists.newArrayList("eshaffer1", "bshaffer1"));
		budget1.setCurrency("usd");
		budget1.setDate("July-2021");
		budget1.setBudgetCategories(Lists.newArrayList(budgetGroup));
		budget1.setId("123");

		budgetRepository.save(budget1);

		budgetService = new BudgetService(budgetRepository);

		budgetController = new BudgetController(budgetService);
	}

	@DisplayName("GET v1/budget/{id} returns correct budget item")
    @Test
    public void testfindByBudgetId() {
		Optional<Budget> budget = budgetController.findByBudgetId("123");
		assertTrue(budget.isPresent());
		assertThat("budget id", budget.get().getId(), is("123"));
		assertThat("budget id", budget.get().getCurrency(), is("usd"));
    }
	
//	@DisplayName("GET v1/budget/{date} returns correct budget item")
//    @Test
//    public void testfindByBudgetDate() {
//		List<Budget> budgetItems = budgetController.findByDate("July-2021");
//		assertTrue(budget.isPresent());
//		assertThat("budget id", budget.get().getId(), is("123"));
//		assertThat("budget id", budget.get().getCurrency(), is("usd"));
//    }
}
