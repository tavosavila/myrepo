package com.callcenter.ultimo;

import java.util.concurrent.Semaphore;
 
public class CallCenter {
	
	//http://lauraliparulo.altervista.org/java-threads-synchronization-with-semaphore/
	 public static void main(String[] args) {
         
    	
        Semaphore operators = new Semaphore(3);
        
        Dispatcher dispatcher= new Dispatcher();
         
        System.out.println("The call center esta listo para atender llamados");
          
        String[] calls = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
   
        for (int i = 0; i < calls.length; i++) {
        	new Customer(operators,calls[i],dispatcher);
			  try {
			
				  Thread.sleep(1000);
		
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        
    }
 
}