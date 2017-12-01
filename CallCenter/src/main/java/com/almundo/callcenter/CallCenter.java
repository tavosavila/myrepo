package com.almundo.callcenter;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.almundo.callcenter.exceptions.CallCenterException;

public class CallCenter {
	
	final static Logger logger = Logger.getLogger(CallCenter.class);

	public static void main(String[] args) throws Exception {
		 
		Dispatcher dispatcher= new Dispatcher();

		int aCall = getParameters(args);

        logger.info("The call center esta listo para atender llamados :" + aCall);
 
        for (int i = 1; i <= aCall; i++) {
        	
        	String nombre = "nombre "+ i ;
        	
        	long random = ThreadLocalRandom.current().nextLong(1,5);
			
        	new Call(nombre,dispatcher);
			  try {
			
				  Thread.sleep(random*1000);
		
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				  throw new CallCenterException("Parametro invalido");
			}
		}
    }


	private static int getParameters(String[] args) throws Exception {
		int aCall;
		
		if (args.length==2 && args[1]!=null && "-c".equals(args[0])) {
			 
			 String valor = args[1]; 
			
			 try {
				 
				 aCall = new Integer(valor);

			 } catch (NumberFormatException ne) {
				 
				  throw new CallCenterException("Parametro invalido");
			 }
		 } else {
			 
			 aCall = 15;
			 logger.info("Utilizando valor default :" + 15 +" Llamadas ");
		 }
		return aCall;
	}


 
}