package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Restaurante {

     private String nombre;
    private String tipoCocina;
    private String direccion;
    private int capacidad;
    private String horarioApertura;
    private String horarioCierre;
    private int mesasDisponibles;
    private List<String> menu;
      private Map<String, Double> preciosPlatos;

    public Restaurante() {
        this.nombre = "Restaurante";
        this.tipoCocina = "No definido";
        this.direccion = "No definida";
        this.capacidad = 0;
        this.horarioApertura = "No definido";
        this.horarioCierre = "No definido";
        this.mesasDisponibles = 0;
        this.menu = new ArrayList<>(); 
    }


    public Restaurante(String nombre, String tipoCocina, String direccion, int capacidad, 
                       String horarioApertura, String horarioCierre, int mesasDisponibles, List<String> menu) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.mesasDisponibles = mesasDisponibles;
        this.menu = new ArrayList<>(menu); 
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(String horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public String getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(String horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public int getMesasDisponibles() {
        return mesasDisponibles;
    }

    public void setMesasDisponibles(int mesasDisponibles) {
        this.mesasDisponibles = mesasDisponibles;
    }

    public List<String> getMenu() {
        return new ArrayList<>(menu); // Devuelve una copia para evitar modificaciones externas
    }

    public void setMenu(List<String> menu) {
        this.menu = new ArrayList<>(menu); // Copia la lista para evitar modificaciones externas
    }

    
    public void mostrarMenu() {
        System.out.println("Menú del restaurante " + nombre + ":");
        if (menu.isEmpty()) {
            System.out.println("El menú está vacío.");
        } else {
            for (String plato : menu) {
                System.out.println("- " + plato);
            }
        }
    }

    // Método para reservar una mesa
    public void reservarMesa(int numeroPersonas) {
        // Asume que una mesa puede acomodar hasta `capacidad` personas
        // Ajusta la lógica si se requieren más detalles sobre la capacidad de cada mesa
        if (numeroPersonas <= 0) {
            System.out.println("Número de personas no válido.");
            return;
        }

        if (mesasDisponibles > 0) {
            mesasDisponibles--;
            System.out.println("Reserva confirmada para " + numeroPersonas + " persona(s).");
            System.out.println("Mesas restantes disponibles: " + mesasDisponibles);
        } else {
            System.out.println("No hay mesas disponibles para realizar la reserva.");
        }
    }

    @Override
    public String toString() {
        return "Restaurante [nombre=" + nombre + ", tipoCocina=" + tipoCocina + ", direccion=" + direccion +
               ", capacidad=" + capacidad + ", horarioApertura=" + horarioApertura + ", horarioCierre=" + horarioCierre +
               ", mesasDisponibles=" + mesasDisponibles + ", menu=" + menu + "]";
    }
    private double calcularPrecioPlato(String nombrePlato) {
        return preciosPlatos.getOrDefault(nombrePlato, 0.0); // Devuelve el precio del plato o 0.0 si no está en el mapa
    }

    public void calcularFactura(List<String> platosPedido) {
        double totalFactura = 0.0;

        System.out.println("Factura del restaurante " + nombre + ":");
        for (String plato : platosPedido) {
            double precio = calcularPrecioPlato(plato);
            if (precio > 0.0) {
                System.out.println("- " + plato + ": $" + precio);
                totalFactura += precio;
            } else {
                System.out.println("- " + plato + ": No disponible");
            }
        }
        System.out.println("Total de la factura: $" + totalFactura);
    }

    

}
