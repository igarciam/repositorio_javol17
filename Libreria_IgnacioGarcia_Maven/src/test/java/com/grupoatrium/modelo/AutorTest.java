package com.grupoatrium.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutorTest {
	String driverPath = "C:/geckodriver/";
		
	@Test
	public void testToString() {
		System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);

		
		String nombre = "J.K.Rowling";
		String nacionalidad = "Gran Breataña";
		String comentarios = "Escritora y productora de cine británica";
		Autor autor = new Autor(nombre, nacionalidad, comentarios);
		
		String autorString = autor.toString();
		
		Assert.assertEquals("Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", comentarios=" + comentarios + "]", autorString);
		
	}

}
