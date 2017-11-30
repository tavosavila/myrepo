package com.ejercicio.callcenter.empleado;

import java.util.concurrent.ThreadLocalRandom;

import com.callcenter.ultimo.Customer;

public class Empleado {
	
	private String tipo;
	
	private Customer call;
	
	private boolean atendiendo=false;
	
	public Empleado() {
		super();
	}

	public void pickUp(Customer call) {
		// TODO Auto-generated method stub
		System.out.println("["+getTipo()+"] atiende "+call.getName());
	
		if (call !=null ) {
			setAtendiendo(true);
			
			long duracion = ThreadLocalRandom.current().nextLong(5,10);
			
			try { 
			
				Thread.sleep(duracion*1000); 
			
			} 
			catch (InterruptedException ie) {
			} 
			System.out.println("["+getTipo()+"] finaliza "+call.getName()+" duracion de llamada ["+duracion +" Seg.]");
			
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