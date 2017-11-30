package com.callcenter.ultimo;

import com.ejercicio.callcenter.empleado.Empleado;
import com.ejercicio.callcenter.empleado.EmpleadoDirector;
import com.ejercicio.callcenter.empleado.EmpleadoOperador;
import com.ejercicio.callcenter.empleado.EmpleadoSupervisor;

public class Dispatcher {
	
	private Empleado employeeDirector;
	private EmpleadoOperador employeeOperator;
	private EmpleadoSupervisor  employeeSupervisor;
	
	public Dispatcher() {

		employeeOperator=new EmpleadoOperador();

		employeeDirector=new EmpleadoDirector();
		
		employeeSupervisor= new EmpleadoSupervisor();	
	
	}
	
	public void dispatchCall (Customer customer){
		
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

}
