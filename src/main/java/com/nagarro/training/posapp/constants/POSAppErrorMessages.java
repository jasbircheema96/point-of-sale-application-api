package com.nagarro.training.posapp.constants;

public class POSAppErrorMessages {

	/**
	 * Error message on getting '/products' and there are no products in data base
	 */
	public static final String ERROR_MESSAGE_PRODUCTS_EMPTY = "Sorry! There are no products yet!!";

	/**
	 * Error message on getting '/customers' and there are no customers in data base
	 */
	public static final String ERROR_MESSAGE_CUSTOMERS_EMPTY = "Sorry! There are no customers yet!!";

	/**
	 * Error message on getting '/employees' and there are no employees in data base
	 */
	public static final String ERROR_MESSAGE_EMPLOYEES_EMPTY = "Sorry! There are no employees yet!!";

	/**
	 * Error message for invalid username or password for employee login
	 */
	public static final String ERROR_MESSAGE_INVALID_LOGIN_CREDENTIAL = "Invalid username or password! Please try again";

	/**
	 * Error message for getting customer with id and no customer exists that has
	 * the same id
	 */
	public static final String ERROR_MESSAGE_INVALID_CUSTOMER_ID = "Sorry ! No customer exists with the id same as the specified one";

	/**
	 * Error message for getting employee with id and no employee exists that has
	 * the same id
	 */
	public static final String ERROR_MESSAGE_INVALID_EMPLOYEE_ID = "Sorry! No order exists with the id same as the specified one";

	/**
	 * Error message for getting product with id and no product exists that has the
	 * same id
	 */
	public static final String ERROR_MESSAGE_INVALID_PRODUCT_ID = "Sorry! No product exists with the id same as the specified one";

	/**
	 * Error message for getting order with id and no order exists that has the same
	 * id
	 */
	public static final String ERROR_MESSAGE_INVALID_ORDER_ID = "Sorry! No order exists with the id same as the specified one";

	/**
	 * Error message when customer wants to buy a greater quantity of a product but
	 * available stock is less
	 */
	public static final String ERROR_MESSAGE_PRODUCT_STOCK_EXHAUSTED_MESSAGE = "Sorry! The product quantity is less that you are willing to buy";
}
