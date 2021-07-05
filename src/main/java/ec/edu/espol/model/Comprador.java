/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Comprador extends Usuario{
    private ArrayList<Oferta> ofertas;
    
    public Comprador(int id,String correo, String clave, String nombres, String apellidos, String organizacion){
        super(id,correo, clave, nombres, apellidos, organizacion);
        this.ofertas = new ArrayList<>();
    }
    
    public Comprador(Usuario u){
        super(u.getId(), u.getCorreo(), u.getClave(), u.getNombres(),u.getApellidos(),u.getOrganizacion());
        this.ofertas = new ArrayList<>();   
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    public static Comprador searchByID(ArrayList<Comprador> compradores, int id){
        for(Comprador c : compradores){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
    
    public static ArrayList<Vehiculo> datosBusquedaVehiculo(Scanner sc, ArrayList<Vehiculo> vehiculos){
        String tipo;
        double rmin, rmax, pmin, pmax;
        int amin, amax;
        ArrayList<Vehiculo> filtroVehiculos;
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        System.out.println("BUSQUEDA DE VEHÍCULOS");
        System.out.println("---------------------------------------------------");
        System.out.println("NOTA: Para separar los decimales usar el punto.");
        
        int p1;
        do{
            System.out.println("¿Desea especificar el tipo de vehículo?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            p1 = sc.nextInt();
        }
        while (p1 != 1 && p1 != 2);
        if (p1 == 1){
            System.out.println("Ingrese el tipo de vehículo a buscar (MOTO, AUTO, CAMIONETA): ");
            tipo = sc.next().toUpperCase();
            while (!tipo.equals("MOTO") && !tipo.equals("CAMIONETA") && !tipo.equals("AUTO")){
                System.out.println("El tipo de vehículo no es valido, por favor ingresarlo de nuevo (MOTO, AUTO, CAMIONETA): ");
                tipo = sc.next().toUpperCase();
            }
        }
        else
            tipo = "n";
        
        int p2;
        do{
            System.out.println("¿Desea especificar el recorrido del vehículo?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            p2 = sc.nextInt();
        }
        while (p2 != 1 && p2 != 2);
        if (p2 == 1){
            System.out.println("Recorrido mínimo del vehículo: ");
            rmin = sc.nextDouble();
            while (rmin < 0){
                System.out.println("Por favor ingrese un número positivo: ");
                rmin = sc.nextDouble();
            }
            System.out.println("Recorrido máximo del vehículo: ");
            rmax = sc.nextDouble();
            while (rmax < rmin){
                System.out.println("Por favor ingrese un número mayor al recorrido mínimo: ");
                rmax = sc.nextDouble();
            }
        }
        else
            rmin = rmax = -1;
        
        int p3;
        do{
            System.out.println("¿Desea especificar el año del vehículo?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            p3 = sc.nextInt();
        }
        while (p3 != 1 && p3 != 2);
        if (p3 == 1){
            System.out.println("Año más antiguo de modelo del vehículo: ");
            amin = sc.nextInt();
            while (amin < 1800){
                System.out.println("Por favor ingrese un año mayor a 1800: ");
                amin = sc.nextInt();
            }
            System.out.println("Año más reciente de modelo del vehículo: ");
            amax = sc.nextInt();
            while (amax < amin){
                System.out.println("Por favor ingrese un número mayor al recorrido mínimo: ");
                amax = sc.nextInt();
            }
        }
        else
            amin =amax = -1;
        
        int p4;
        do{
            System.out.println("¿Desea especificar rango de precio del vehículo?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            p4 = sc.nextInt();
        }
        while (p4 != 1 && p4 != 2);
        if (p4 == 1){
            System.out.println("Precio mínimo del vehículo: ");
            pmin = sc.nextDouble();
            while (pmin < 1800){
                System.out.println("Por favor ingrese un precio positivo: ");
                pmin = sc.nextDouble();
            }
            System.out.println("Precio máximo del vehículo: ");
            pmax = sc.nextDouble();
            while (pmax < pmin){
                System.out.println("Por favor ingrese un precio mayor al mínimo: ");
                pmax = sc.nextDouble();
            }
        }
        else
            pmin = pmax = -1;
        filtroVehiculos = vehiculos;
        if (!tipo.equals("n"))
            filtroVehiculos = Vehiculo.searchByTipo(tipo, vehiculos);
        if (rmin != -1)
            filtroVehiculos = Vehiculo.searchByRecorrido(rmin, rmax, vehiculos);
        if (amin != -1)
            filtroVehiculos = Vehiculo.searchByAnio(amin, amax, vehiculos);
        if (pmin != -1)
            filtroVehiculos = Vehiculo.searchByPrecio(pmin, pmax, vehiculos);
        return filtroVehiculos;
    }
    
    
    
}
