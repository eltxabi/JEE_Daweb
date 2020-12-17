package test;

import static org.junit.Assert.*;

import org.junit.Test;

import data.Libro;

public class LibroTest {

	@Test
	public void NewLibro() {
		Libro libro = new Libro(1,"prueba","prueba");
		assertNotNull(libro);
	}

}
