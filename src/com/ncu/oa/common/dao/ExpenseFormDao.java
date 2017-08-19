package com.ncu.oa.common.dao;

import java.util.List;

import com.ncu.oa.common.entity.ExpenseForm;

public interface ExpenseFormDao {

	public boolean saveExpenseForm(ExpenseForm expenseForm);

	public boolean deleteExpenseForm(ExpenseForm expenseForm);

	public boolean updateExpenseForm(ExpenseForm expenseForm);

	public List findAllExpenseForms();

	public ExpenseForm findExpenseFormById(Integer id);

}
