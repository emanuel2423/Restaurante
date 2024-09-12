package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
         public static void main(String[] args) {
        Map<String, Double> precios = new HashMap<>();
        precios.put("Pizza", 12.99);
        precios.put("Pasta", 10.99);
        precios.put("Ensalada", 7.99);

        List<String> menu = Arrays.asList("Pizza", "Pasta", "Ensalada");

        Restaurante restaurante = new Restaurante(
            "La Dolce Vita",               // Nombre del restaurante
            "Italiana",                    // Tipo de cocina
            "Calle Falsa 123",             // Dirección
            50,                            // Capacidad
            "10:00",                        // Horario de apertura
            "22:00",                        // Horario de cierre
            10,                            // Mesas disponibles
            menu,                          // Menú
            precios                        // Precios de los platos
        );

        // Mostrar el menú del restaurante
        restaurante.mostrarMenu();

        // Reservar una mesa para dos personas
        restaurante.reservarMesa(2);

        // Crear una lista de platos pedidos
        List<String> platosPedido = Arrays.asList("Pizza", "Pasta");

        // Calcular y mostrar la factura del pedido
        restaurante.calcularFactura(platosPedido);
    }

}
}