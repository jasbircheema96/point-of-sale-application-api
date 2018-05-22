package com.nagarro.training.posapp.resources;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.posapp.models.Employee;
import com.nagarro.training.posapp.services.IEmployeeService;
import com.nagarrro.training.posapp.exceptions.LoginException;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

@RestController
public class EmployeeResource {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = "/employees/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Employee employee) {
		try {
			return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.login(employee));
		} catch (HibernateException hibernateException) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(hibernateException);
		} catch (LoginException loginException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginException);
		}
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<?> getAllEmployees() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
		} catch (NoDataFoundException noDataException) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(noDataException);
		} catch (HibernateException hibernateException) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hibernateException);
		}
	}
}
