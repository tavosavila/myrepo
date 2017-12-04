package com.almundo.callcenter;

import java.util.concurrent.Semaphore;

import com.almundo.callcenter.employee.Employee;
import com.almundo.callcenter.employee.EmployeeDirector;
import com.almundo.callcenter.employee.EmployeeOperador;
import com.almundo.callcenter.employee.EmployeeSupervisor;

public class Dispatcher {
	
	private final int MAX_EMPLOYEES = 3;

	protected final int MAX_WAIT = 10;
	
	private Employee employeeDirector;
	private Employee employeeOperator;
	private Employee  employeeSupervisor;
	
	private Semaphore employees = new Semaphore(MAX_EMPLOYEES);
	
	private int countDirector = 0;
	private int countSupervisor = 0;
	private int countOperador = 0;
	
	
	public Dispatcher() {

		employeeOperator=new EmployeeOperador();

		employeeDirector=new EmployeeDirector();
		
		employeeSupervisor= new EmployeeSupervisor();	
	
		
	}
	
	public  void dispatchCall (Call customer){
		
		if (!employeeOperator.isAtendiendo()) {
			
			employeeOperator.pickUp(customer);
			this.countOperador ++;
			
		} 
		else if (!employeeSupervisor.isAtendiendo()) {
			
			employeeSupervisor.pickUp(customer);	
			this.countSupervisor ++;
			
		}else if (!employeeDirector.isAtendiendo()) {
			
			employeeDirector.pickUp(customer);	
			this.countDirector ++;
		} 
		
		
		
	}

	public Semaphore getOperators() {
		return employees;
	}

	public void setOperators(Semaphore operators) {
		this.employees = operators;
	}

	public int getCountDirector() {
		return countDirector;
	}

	public int getCountSupervisor() {
		return countSupervisor;
	}

	public int getCountOperador() {
		return countOperador;
	}

	

}
