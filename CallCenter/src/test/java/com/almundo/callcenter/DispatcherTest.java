package com.almundo.callcenter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DispatcherTest {

	@Test
	public void test() {

		Dispatcher disp = new Dispatcher();
		Call[] arraCalls = new Call[3];

		String[] calls = { "1" };
		for (int i = 0; i < calls.length; i++) {
			arraCalls[i] = new Call(calls[i], disp);
			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		while (arraCalls[0].isAlive()) {
			// esperamos que se termine de atender la llamada
		}

		// solo el operador debio atender la unica llamada
		int actual =disp.getCountOperador();
		assertEquals(1, actual);
		

	}

}
