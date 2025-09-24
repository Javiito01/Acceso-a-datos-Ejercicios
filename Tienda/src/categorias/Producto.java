package categorias;

//complejidad: O(1) para constructor y getters/setters
public class Producto {
 private String codigoProducto;
 private String nombre;
 private double precio;
 private Categoria categoria;
 private int stock;

 // complejidad: O(1)
 public Producto(String codigoProducto, String nombre, double precio, Categoria categoria, int stock) {
     this.codigoProducto = codigoProducto;
     this.nombre = nombre;
     this.precio = precio;
     this.categoria = categoria;
     this.stock = stock;
 }

 // complejidad: O(1)
 public String getCodigoProducto() { return codigoProducto; }
 public String getNombre() { return nombre; }
 public double getPrecio() { return precio; }
 public Categoria getCategoria() { return categoria; }
 public int getStock() { return stock; }

 // complejidad: O(1)
 public void setPrecio(double precio) { this.precio = precio; }

 // complejidad: O(1)
 public void setStock(int stock) { this.stock = stock; }

 // complejidad: O(1)
 public double valorTotalStock() {
     return precio * stock;
 }

 // complejidad: O(1)
 @Override
 public String toString() {
     if (stock <= 0) {
         return nombre + " (código: " + codigoProducto + ", categoría: " + categoria + ") - sin stock";
     }
     return nombre + " (código: " + codigoProducto + ", precio: " + precio + ", categoría: " + categoria + ", stock: " + stock + ")";
 }
}
