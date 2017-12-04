package com.almundo.callcenter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DispatcherTest {

	@Test
	public void test() {

		Dispatcher disp = new Dispatcher();
	

		Call call = new Call("llamadaTest",disp);
		while (call .isAlive()) {
			// esperamos que se termine de atender la llamada
		}

		// solo el operador debio atender la unica llamada
		int actualO =disp.getCountOperador();
		assertEquals(1, actualO);
		int actualS =disp.getCountSupervisor();
		assertEquals(0, actualS);
		int actualD =disp.getCountDirector();
		assertEquals(0, actualD);
		

	}
	
	@Test
	public void testAll() {

		Dispatcher disp = new Dispatcher();
	
		Call cOperador = new Call("llamadaParaOperador", disp);
		Sleep();
		
		Call cSupervisor = new Call("llamadaParaSupervisor", disp);
		Sleep();
		
		Call cDirector = new Call("llamadaParaDirector", disp);
		Sleep();
		
		while ( cDirector.isAlive() || cSupervisor.isAlive() ||cOperador.isAlive() ) {
			// esperamos que se termine de atender la llamada
	
		}

		// solo el operador debio atender la unica llamada
		int actualO =disp.getCountOperador();
		assertEquals(1, actualO);
		int actualS =disp.getCountSupervisor();
		assertEquals(1, actualS);
		int actualD =disp.getCountDirector();
		assertEquals(1, actualD);
		

	}

	private void Sleep() {
		try {

			Thread.sleep(500);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testOperadorSupervisor() {

		Dispatcher disp = new Dispatcher();
	
		Call cOperador = new Call("llamadaParaOperador", disp);
		Sleep();
		Call cSupervisor = new Call("llamadaParaSupervisor", disp);
		Sleep();
		
		while ( cSupervisor.isAlive() ||cOperador.isAlive() ) {
			// esperamos que se termine de atender la llamada
	
		}

		int actualO =disp.getCountOperador();
		assertEquals(1, actualO);
		int actualS =disp.getCountSupervisor();
		assertEquals(1, actualS);
		int actualD =disp.getCountDirector();
		assertEquals(0, actualD);
		

	}

}
