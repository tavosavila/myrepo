package com.almundo.callcenter;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.almundo.callcenter.employee.EmployeeDirector;
import com.almundo.callcenter.employee.EmployeeOperador;
import com.almundo.callcenter.employee.EmployeeSupervisor;

public class DispatcherTest {
	@Mock
	Dispatcher disp = new Dispatcher();

	@Test
	public void test() {

		EmployeeOperador employeeOperador = new EmployeeOperador();
		disp.setEmployeeOperator(employeeOperador);

		EmployeeDirector employeeDirector = new EmployeeDirector();
		disp.setEmployeeDirector(employeeDirector);

		EmployeeSupervisor employeeSupervisor = new EmployeeSupervisor();
		disp.setEmployeeSupervisor(employeeSupervisor);

	     System.out.println("The call center esta listo para atender llamados");
	        
	    // String[] calls = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
	    Call [] arraCalls = new Call [3];
	    
	        String[] calls = {"1","2"};
	 	        for (int i = 0; i < calls.length; i++) {
	 	        	arraCalls[i] =new Call(calls[i],disp);
				  try {
				
					  Thread.sleep(1000);
			
				  } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        
		// Call a = new Call ("test",disp);
		//verify(disp, times(3)).add(10.0, 20.0);
		 Mockito.verify(disp, Mockito.times(10)).dispatchCall( arraCalls[0] );
		 Mockito.verify(disp, Mockito.times(10)).dispatchCall( arraCalls[1] );
		 Mockito.verify(disp, Mockito.times(1)).dispatchCall(Mockito.any(Call.class));
		 System.out.println("println "+arraCalls[1].getName());
	}

	 
	

}
