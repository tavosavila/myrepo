package com.almundo.callcenter;

import org.apache.log4j.Logger;
 
public class Call extends Thread {
 
	final static Logger logger = Logger.getLogger(Call.class);
	

    private Dispatcher disp;
 
    public Call() {
		// TODO Auto-generated constructor stub
	}
    
    public Call(String nombre ,Dispatcher disp) {
       
        this.setName(nombre);
        
        this.disp = disp;
        
        this.start();
        
        	
    }
 
    /**
     *  falta un semaforo para tener los 10 llamadas en espera
     */
    public void run() {
 
        try {
 
      //      System.out.println("[ Llamada "+getName() +"]" + " ingresa al dispatcher");
            
            
            if ( disp.getOperators().getQueueLength() < 10) {
            	
            	if (disp.getOperators().availablePermits()==0)
                   logger.info("[ Llamada "+getName() +"]"  +" tiene que espera ");
          		
            	
            	disp.getOperators().acquire();
            	 
            //    System.out.println(getName() + " siendo atendido por dispatcher ...");
                            //using TimeUnit enumeration to make the code more readable
                
                disp.dispatchCall(this);
                
                logger.info("[ Llamada "+getName() +"] fue atendida ...");
                
                disp.getOperators().release();
     
            } else {
            	 logger.info("[ Llamada "+getName() +" se perdio ya que no habia disponibilidad ");
                
            }
                        
           // System.out.println("Available operators="+ operators.availablePermits());
             
        } catch (InterruptedException /*| BrokenBarrierException*/ e) {
            System.err.println(e);
        } 
 
    }
}