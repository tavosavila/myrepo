package com.callcenter.ultimo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
 
public class Customer extends Thread {
 
    
    private Semaphore operators;
    
    private Dispatcher disp;
 
    public Customer(Semaphore operators,String nombre ,Dispatcher disp) {
        
        this.operators = operators;
        
        this.setName(nombre);
        
        this.disp = disp;
        
        this.start();
        
        	
    }
 
    /**
     *  falta un semaforo para tener los 10 llamadas en espera
     */
    public void run() {
 
        try {
 
            System.out.println(getName() + " ingresa al dispatcher");
            
            
            if ( operators.getQueueLength() < 10) {
            	
            	if (operators.availablePermits()==0)
                	System.out.println(getName() +" tiene que espera ");
                	
            	operators.acquire();
            	 
                System.out.println(getName() + " siendo atendido por dispatcher ...");
                            //using TimeUnit enumeration to make the code more readable
                
                disp.dispatchCall(this);
                
                System.out.println(getName()+" finalizo la llamada ...");
                operators.release();
     
            } else {
            	
            	 System.out.println("Se pierde llamada ..."+ getName());
            }
                        
           // System.out.println("Available operators="+ operators.availablePermits());
             
        } catch (InterruptedException /*| BrokenBarrierException*/ e) {
            System.err.println(e);
        } 
 
    }
}