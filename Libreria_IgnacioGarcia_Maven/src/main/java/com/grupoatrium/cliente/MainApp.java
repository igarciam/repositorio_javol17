package com.grupoatrium.cliente;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.persistencia.impl.ConnectionMgr;
import com.grupoatrium.persistencia.impl.EditorialesDAO;
import com.grupoatrium.persistencia.impl.LibrosDAO;

public class MainApp {

	public static void main(String[] args) {
		//Una vez cargado el contexto de Spring,
		//Debería salir el mensaje de que se han inyectado las propiedades en ConnectionMgr:
		
		//Obtenemos el context de spring
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		
		//Obtenemos varios Beans para comprobar que se han inyectado las dependencias
		
		//Beans de tipo autor que habrá en el contenedor:
		Autor isabel = context.getBean("isabel", Autor.class);
		Autor jkrowling = context.getBean("jkrowling", Autor.class);
		Autor anonimo = context.getBean("com.grupoatrium.modelo.Autor#0", Autor.class);
		Autor john = (Autor) context.getBean("john");
		Autor paula = context.getBean("paula", Autor.class);
		Autor mario = context.getBean("mario", Autor.class);
		
		//Comprobamos los valores de los autores
		System.out.println("\nAutores definidos como beans:");
		System.out.println(isabel.toString());
		System.out.println(jkrowling.toString());
		System.out.println(anonimo.toString());
		System.out.println(john.toString());
		System.out.println(paula.toString());
		System.out.println(mario.toString());
		
		//Bean de tipo lista de auntores
		@SuppressWarnings("unchecked")
		List<Autor> listaAutores = (List<Autor>) context.getBean("autores");
		//Lo imprimimos para ver que se han cargado bien
		System.out.println("\nLista de autores con espacio de nombres util:");
		for(Autor a : listaAutores){
			System.out.println(a.toString());
		}
		
		//Beans de tipo Direccion
		Direccion barcelona1 = context.getBean("barcelona1", Direccion.class);
		Direccion barcelona2 = context.getBean("barcelona2", Direccion.class);
		
		//Comprobamos las direcciones definidas:
		System.out.println("\nDirecciones:");
		System.out.println(barcelona1.toString());
		System.out.println(barcelona2.toString());
		
		//Beans de tipo Editorial
		Editorial planeta = context.getBean("planeta", Editorial.class);
		Editorial oceano = context.getBean("oceano", Editorial.class);
		
		//Comprobamos las editoriales definidas
		System.out.println("\nEditoriales:");
		System.out.println(planeta.toString());
		System.out.println(oceano.toString());
		
		//Beans de tipo libro
		Libro libro1 = context.getBean("libro1", Libro.class);
		Libro libro2 = context.getBean("libro2", Libro.class);
		Libro libro3 = context.getBean("libro3", Libro.class);
		
		//Comprobamos los valores de los libros definidos
		System.out.println("\nLibros:");
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());
		System.out.println(libro3.toString());
		
		//Bean de tipo ConnectionMgr
		ConnectionMgr c = context.getBean("connectionMgr", ConnectionMgr.class);
		//Comprobamos que se han cargado bien los properties en ConnectionMgr
		System.out.println("\nConnectionMgr:");
		System.out.println(c.toString());	
		
		//Beans de tipo LibrosDAO
		LibrosDAO ldao1 = context.getBean(LibrosDAO.class);
		LibrosDAO ldao2 = context.getBean(LibrosDAO.class);
		
		//Comprobamos los valores de librosDAO
		System.out.println("\nLibrosDAO:");
		System.out.println("ldao1: " + ldao1.toString());
		System.out.println("ldao2: " + ldao2.toString());
		
		//Beans de tipo EditorialesDAO
		EditorialesDAO edao1 = context.getBean(EditorialesDAO.class);
		EditorialesDAO edao2 = context.getBean(EditorialesDAO.class);
		
		//Comprobamos los valores de EditorialesDAO
		System.out.println("\nEditorialesDAO:");
		System.out.println("edao1: " + edao1.toString());
		System.out.println("edao2: " + edao2.toString());
		
		//Comprobación del singleon vs prototype
		System.out.println("\nComprobacion de singleton y prototype:");
		System.out.println("Los objetos [ldao1] y [ldao2] son iguales? " + ldao1.equals(ldao2));
		System.out.println("Los objetos [edao1] y [edao2] son iguales? " + edao1.equals(edao2));
		
		//Indicamos que al finalizar la aplicacion se llame a todos los metodos destroy
		System.out.println("\nComprobacion de llamada a método Destroy:");
		context.registerShutdownHook();
	}

}
