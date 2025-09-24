package main;

import java.util.HashMap;

public class carritocompra {
    
    private HashMap<String, Integer> carrito; //almacena el carrito
    
    private HashMap<String, Double> precios; //almacena los precios

    public carritocompra() {
        this.carrito = new HashMap<>(); //0(1)
        this.precios = new HashMap<>(); //0(1)
        
        this.precios.put("manzana",0.5); //0(1) cada uno
        this.precios.put("platano",0.3);
        this.precios.put("naranja",0.6);
        this.precios.put("leche",2.5);
        this.precios.put("pan",1.5);
    }
}

public void aProducto(String nombre, int cantidad) {
    if (!precios.containsKey(nombre)){
        System.out.println("producto no disponible");
        return;
    }
}
    carrito.put(nombre, carrito.getOrDefault(nombre, 0)+ cantidad);
    System.out.println("agregado" + cantidad + " " + nombre + " del carrito");

public void eProducto(String nombre) {
    if (carrito.containsKey(nombre)) {
        carrito.remove(nombre);
        System.out.println("eliminado" + nombre + " del carrito");
    }else{
        System.out.println("producto" + nombre + " no encontrado");   
    }
}

public void aCantidad(String nombre, int nuevaCantidad) {
    if (!carrito.containsKey(nombre)){
        System.out.println("producto" + nombre + " no econtrado");
        return;
    }

    if (nuevaCantidad <= 0) {
    eProduct(nombre);
}else{
    carrito.put(nombre,nuevaCantidad);
    System.out.println("actualizado" + nombre + " cantidad a" + nuevaCantidad);

 }
}

private double cTotal() {
    double Total = 0;

    for (String nombre : carrito.keySet()){
        
    }
}


