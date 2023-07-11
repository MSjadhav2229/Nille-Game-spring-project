package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Expense;
import reposity.ExpenseRepository;

@Service

public class ExpenseService {
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);
	};

	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(
				() -> new RuntimeException(
						String.format("Cannot Find Expense by Id %s", expense.getId())));

		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseAmount(expense.getExpenseAmount());

	};

	public List<Expense> getAllExpense() {
		return expenseRepository.findAll();
	};

	public Expense getExpenseByName(String name) {
		return expenseRepository.findByName(name)
				.orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Id %s", name)));
	};

	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	};
}
