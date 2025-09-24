package main;

import java.util.List;
import java.util.Scanner;
import categorias.Categoria;
import categorias.Producto;
import categorias.Inventario;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario("mi tienda");

        //agregar productos
        inventario.agregarProducto(new Producto("P1", "MacBook Pro", 2500.0, Categoria.PORTATILES, 5));
        inventario.agregarProducto(new Producto("G1", "Alienware Aurora", 3000.0, Categoria.GAMING, 3));
        inventario.agregarProducto(new Producto("A1", "Sony WH-1000XM4", 350.0, Categoria.AURICULARES, 10));
        inventario.agregarProducto(new Producto("R1", "Logitech G502", 80.0, Categoria.RATONES, 15));
        inventario.agregarProducto(new Producto("T1", "Corsair K70", 200.0, Categoria.TECLADOS, 7));
        inventario.agregarProducto(new Producto("T2", "Razer BlackWidow", 180.0, Categoria.TECLADOS, 4));
        inventario.agregarProducto(new Producto("A2", "Bose QC35", 300.0, Categoria.AURICULARES, 0)); // Sin stock

        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;

        System.out.println("bienvenido al inventario de la tienda.");

        while (seguir) {
            System.out.println("\nopciones:");
            System.out.println("1 - consultar producto por código");
            System.out.println("2 - consultar productos por categoría");
            System.out.println("3 - mostrar inventario completo");
            System.out.println("4 - agregar o elminar stock de un producto");
            System.out.println("5 - salir");
            System.out.print("escribe tu opción: ");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("error.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("escribe el código del producto: ");
                    String codigo = scanner.nextLine();
                    Producto producto = inventario.buscarProducto(codigo); // O(1)
                    if (producto != null) {
                        System.out.println(producto);
                    } else {
                        System.out.println("producto no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("categorías disponibles:");
                    for (Categoria cat : Categoria.values()) {
                        System.out.println("- " + cat);
                    }
                    System.out.print("escribe la categoría a consultar: ");
                    String catStr = scanner.nextLine().toUpperCase();
                    try {
                        Categoria categoria = Categoria.valueOf(catStr);
                        List<Producto> productosCat = inventario.productosPorCategoria(categoria); // O(n)
                        if (productosCat.isEmpty()) {
                            System.out.println("no hay productos en esa categoría.");
                        } else {
                            System.out.println("productos en " + categoria + ":");
                            for (Producto p : productosCat) {
                                System.out.println(p);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("error.");
                    }
                    break;
                case 3:
                    System.out.println(inventario); //O(n)
                    break;
                case 4:
                    System.out.print("escribe el código del producto: ");
                    String cod = scanner.nextLine();
                    System.out.print("escribe la suma o resta de stock (ej: -2 para vender, +5 para agregar): ");
                    try {
                        int c = Integer.parseInt(scanner.nextLine());
                        inventario.ap(cod, c); //O(1)
                    } catch (NumberFormatException e) {
                        System.out.println("error.");
                    }
                    break;
                case 5:
                    System.out.println("adios");
                    seguir = false;
                    break;
                default:
                    System.out.println("error.");
            }
        }
        scanner.close();
    }
}
