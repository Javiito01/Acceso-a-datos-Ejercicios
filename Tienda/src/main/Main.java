package main;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Complejidad 0(1)
enum Categoria {
	PORTATIL, GAMING, AURICULARES, RATONES, TECLADOS
}

// Complejidad 0(1)
class Producto {
	private String codigoProducto;
	private String nombre;
	private double precio;
	private Categoria categoria;
	private int stock;
	
	public Producto(String codigoProducto, String nombre, double precio, Categoria categoria, int stock) {
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
	}
}

public class Main {

	public static void main(String[] args) {


	}

}