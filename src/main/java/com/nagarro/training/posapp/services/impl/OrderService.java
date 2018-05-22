package com.nagarro.training.posapp.services.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.training.posapp.constants.POSAppErrorMessages;
import com.nagarro.training.posapp.dao.ICustomerDAO;
import com.nagarro.training.posapp.dao.IEmployeeDAO;
import com.nagarro.training.posapp.dao.IOrderDAO;
import com.nagarro.training.posapp.dao.IProductDAO;
import com.nagarro.training.posapp.models.Customer;
import com.nagarro.training.posapp.models.Employee;
import com.nagarro.training.posapp.models.Order;
import com.nagarro.training.posapp.models.OrderDetail;
import com.nagarro.training.posapp.models.Product;
import com.nagarro.training.posapp.services.IOrderService;
import com.nagarrro.training.posapp.exceptions.NoResourceFoundException;
import com.nagarrro.training.posapp.exceptions.OperationalException;

public class OrderService implements IOrderService {

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Autowired
	private IProductDAO productDAO;

	@Autowired
	private IOrderDAO orderDAO;

	@Override
	public void addOrder(Order order, int customerId, int employeeId)
			throws HibernateException, NoResourceFoundException, OperationalException {

		Customer customer = customerDAO.getCustomerById(customerId);
		if (customer == null) {
			throw new NoResourceFoundException(POSAppErrorMessages.ERROR_MESSAGE_INVALID_CUSTOMER_ID);
		}

		Employee employee = employeeDAO.getEmployeeById(employeeId);
		if (employee == null) {
			throw new NoResourceFoundException(POSAppErrorMessages.ERROR_MESSAGE_INVALID_EMPLOYEE_ID);
		}

		order.setCustomer(customer);
		order.setEmployee(employee);

		Product orderDetailProduct;

		List<OrderDetail> orderDetails = order.getOrderDetails();
		for (OrderDetail orderDetail : orderDetails) {
			orderDetail.setOrder(order);
			orderDetailProduct = productDAO.getProductById(orderDetail.getProductId());
			if (orderDetailProduct == null) {
				throw new NoResourceFoundException(POSAppErrorMessages.ERROR_MESSAGE_INVALID_PRODUCT_ID);
			}
			if (orderDetail.getQuantity() > orderDetailProduct.getQuantity()) {
				throw new OperationalException(POSAppErrorMessages.ERROR_MESSAGE_PRODUCT_STOCK_EXHAUSTED_MESSAGE);
			}
			// Not sure whether to add these lines here.. ?? -- product quantity decreases
			// even if some error is encountered while adding order in DAO layer

			// decrease product quantity
			// add cash drawer balance
			orderDetail.setProduct(orderDetailProduct);

		}
		orderDAO.addOrder(order);

	}

}
