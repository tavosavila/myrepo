package com.almundo.callcenter;

import org.apache.log4j.Logger;
 
public class Call extends Thread {
 
	final static Logger logger = Logger.getLogger(Call.class);
	
	private Dispatcher disp;
 
    
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
 
            if ( disp.getOperators().getQueueLength() < disp.MAX_WAIT) {
            	
            	if (disp.getOperators().availablePermits()==0)
                   logger.info("[ Llamada "+getName() +"]"  +" tiene que espera ");
          		
            	
            	disp.getOperators().acquire();
               disp.dispatchCall(this);
                
                logger.info("[ Llamada "+getName() +"] fue atendida ...");
                
                disp.getOperators().release();
     
            } else {
            	 logger.info("[ Llamada "+getName() +" se perdio ya que no habia disponibilidad ");
                
            }
                        
             
        } catch (InterruptedException  e) {
            System.err.println(e);
        } 
 
    }
}