package com.almundo.callcenter.employee;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.almundo.callcenter.Call;



public class Employee {
	
	private String tipo;
	
	private Call call;
	
	private boolean atendiendo=false;
	
	final static Logger logger = Logger.getLogger(Employee.class);
	
	public Employee() {
		super();
	}

	public void pickUp(Call call) {
		// TODO Auto-generated method stub
	//	System.out.println("[ "+getTipo()+"] atiende llamada "+call.getName());
	    logger.info( "[ "+getTipo()+"] atiende llamada "+call.getName());
		
	    if (call !=null ) {
			setAtendiendo(true);
			
			long duracion = ThreadLocalRandom.current().nextLong(5,10);
			
			try { 
			
				Thread.sleep(duracion*1000); 
			
			} 
			catch (InterruptedException ie) {
			} 
		 logger.info("[ "+getTipo()+"] finaliza "+call.getName()+" duracion de llamada ["+duracion +" Seg.]");
					
			this.call=null;
	
			setAtendiendo(false);
		}
	}

	public boolean isAtendiendo() {
		return atendiendo;
	}

	public void setAtendiendo(boolean atendiendo) {
		this.atendiendo = atendiendo;
	}
	
	protected void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	private String getTipo(){
		
		return this.tipo;
	}


}