package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;

@Path("productos")
public class ServiciosProducto {
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar (Producto producto) {
		System.out.println("Ingresar Producto >>>>>>>> "+producto);
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar (Producto producto) {
		System.out.println("Actualizar Producto >>>>>>>> "+producto);
	}
	
	@Path("consultar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos(){
		ArrayList<Producto> productos = new ArrayList<>();
		productos.add(new Producto("PROD-01", "Smartphone", new Categoria(1, "Tecnología"), 500.0, 10));
        productos.add(new Producto("PROD-02", "Televisor", new Categoria(2, "Electrodomésticos"), 800.0, 5));
        productos.add(new Producto("PROD-03", "Libro", new Categoria(3, "Libros"), 20.0, 20));

		return productos;
	}
}
