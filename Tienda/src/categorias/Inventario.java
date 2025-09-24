package categorias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventario {
    private String nombreTienda;
    private HashMap<String, Producto> productosMap; //búsqueda rápida: O(1)
    private List<Producto> productosList;           //recorrido completo: O(n)

    //constructor: O(1)
    public Inventario(String nombreTienda) {
        this.nombreTienda = nombreTienda;
        this.productosMap = new HashMap<>();
        this.productosList = new ArrayList<>();
    }

    //agregar producto: O(1) para HashMap y ArrayList
    public void agregarProducto(Producto producto) {
        productosMap.put(producto.getCodigoProducto(), producto);
        productosList.add(producto);
    }

    //buscar producto por código: O(1)
    public Producto buscarProducto(String codigo) {
        return productosMap.get(codigo);
    }

    //obtener productos por categoría: O(n)
    public List<Producto> productosPorCategoria(Categoria categoria) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productosList) { // recorrido completo
            if (p.getCategoria() == categoria) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    //agregar stock de un producto (ap): O(1)
    public void ap(String cod, int c) {
        Producto p = buscarProducto(cod); // O(1)
        if (p != null) {
            int nuevoStock = p.getStock() + c;
            if (nuevoStock < 0) {
                System.out.println("no hay suficiente stock");
            } else {
                p.setStock(nuevoStock);
                System.out.println("stock actualizado: " + p);
            }
        } else {
            System.out.println("producto no encontrado.");
        }
    }

    //mostrar inventario completo: O(n)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inventario de " + nombreTienda + ":\n");
        for (Producto p : productosList) { //recorrido completo
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}