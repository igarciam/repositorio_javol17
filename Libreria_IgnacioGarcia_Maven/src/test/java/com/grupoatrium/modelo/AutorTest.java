package com.grupoatrium.modelo;

import org.junit.Assert;
import org.junit.Test;

public class AutorTest {

	@Test
	public void testToString() {
		String nombre = "J.K.Rowling";
		String nacionalidad = "Gran Breataña";
		String comentarios = "Escritora y productora de cine británica";
		Autor autor = new Autor(nombre, nacionalidad, comentarios);
		
		String autorString = autor.toString();
		
		Assert.assertEquals("Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", comentarios=" + comentarios + "]", autorString);
		
	}

}
