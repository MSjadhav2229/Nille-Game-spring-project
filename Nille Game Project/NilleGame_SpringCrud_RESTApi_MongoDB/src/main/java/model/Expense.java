package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Trunc;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("expense")
public class Expense {
	@Id
	private String id;
	@Field("name")
	@Indexed(unique = true)
	private String expenseName;
	@Field("category")
	private ExpenseCategory expenseCategory;
	@Field("amount")
	private ExpenseAmount expenseAmount;
}
