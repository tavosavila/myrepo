package com.almundo.callcenter;

import java.util.concurrent.Semaphore;

import com.almundo.callcenter.employee.Employee;
import com.almundo.callcenter.employee.EmployeeDirector;
import com.almundo.callcenter.employee.EmployeeOperador;
import com.almundo.callcenter.employee.EmployeeSupervisor;

public class Dispatcher {
	
	private final int MAX_EMPLOYEES = 3;
	
	private EmployeeDirector employeeDirector;
	private EmployeeOperador employeeOperator;
	private EmployeeSupervisor  employeeSupervisor;
	
	Semaphore employees = new Semaphore(MAX_EMPLOYEES);
	
	public Dispatcher() {

		employeeOperator=new EmployeeOperador();

		employeeDirector=new EmployeeDirector();
		
		employeeSupervisor= new EmployeeSupervisor();	
	
	}
	
	public void dispatchCall (Call customer){
		
//		System.out.println(" se envia dispatchCall"+customer.getName());
		
//		

		if (!employeeOperator.isAtendiendo()) {
			
			employeeOperator.pickUp(customer);
			
		} 
		else if (!employeeSupervisor.isAtendiendo()) {
			
			employeeSupervisor.pickUp(customer);	
			
		}else if (!employeeDirector.isAtendiendo()) {
			
			employeeDirector.pickUp(customer);	
		} 
		
		
		
	}

	public Semaphore getOperators() {
		return employees;
	}

	public void setOperators(Semaphore operators) {
		this.employees = operators;
	}

	public Employee getEmployeeDirector() {
		return employeeDirector;
	}

	public void setEmployeeDirector(EmployeeDirector employeeDirector) {
		this.employeeDirector = employeeDirector;
	}

	public EmployeeOperador getEmployeeOperator() {
		return employeeOperator;
	}

	public void setEmployeeOperator(EmployeeOperador employeeOperator) {
		this.employeeOperator = employeeOperator;
	}

	public EmployeeSupervisor getEmployeeSupervisor() {
		return employeeSupervisor;
	}

	public void setEmployeeSupervisor(EmployeeSupervisor employeeSupervisor) {
		this.employeeSupervisor = employeeSupervisor;
	}

	

}
