/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Comprador extends Usuario{
    private ArrayList<Oferta> ofertas;
    
    //constructores
    
    public Comprador(int id,String correo, String clave, String nombres, String apellidos, String organizacion){
        super(id,correo, clave, nombres, apellidos, organizacion);
        this.ofertas = new ArrayList<>();
    }
    
    public Comprador(Usuario u){
        super(u.getId(), u.getCorreo(), u.getClave(), u.getNombres(),u.getApellidos(),u.getOrganizacion());
        this.ofertas = new ArrayList<>();   
    }
    
    //getters y setters

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    //comportamientos
    
    
    public static ArrayList<Vehiculo> busquedaVehiculo(Scanner sc, ArrayList<Vehiculo> vehiculos){
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
    
    public static Vehiculo elegirVehiculo(Scanner sc, ArrayList<Vehiculo> vehiculos){
        if(!vehiculos.isEmpty()){
            System.out.println("Se han encontrado " + vehiculos.size()+ " vehículos que cumplen con estos parámetros.");
            int i = 0;
            int opcion = 0;
            while(opcion !=4){
                System.out.println("Vehículo " + (i+1) + "\n" + vehiculos.get(i));
                do{
                    System.out.println("1. Siguiente vehículo");
                    System.out.println("2. Vehículo anterior");
                    System.out.println("3. Poner una oferta");
                    System.out.println("4. Cancelar");
                    opcion = sc.nextInt();
                }
                while(opcion != 1 && opcion != 2 && opcion !=3 && opcion != 4);
                if(opcion == 1){
                    if(i == (vehiculos.size() - 1))
                        i = 0;
                    else
                        i += 1;       
                }
                else if(opcion == 2){
                    if(i == 0)
                        i = vehiculos.size() - 1;
                    else
                        i -= 1;
                }
                else if(opcion == 3){
                    return vehiculos.get(i);
                }
            }
        }
        else
            System.out.println("No hay vehículos dentro de estos parámetros.");
        return null;
    }
    
    public boolean ponerOferta(Vehiculo v, String nomfile, Scanner sc){
        sc.useDelimiter("\n");
        System.out.println("NUEVA OFERTA");
        System.out.println("---------------------------------");
        System.out.println("Vehículo a ofertar:\n"+ v);
        System.out.println("---------------------------------");
        System.out.println("Ingrese su oferta: ");
        Double oferta = sc.nextDouble();
        while(oferta<=0){
            System.out.println("Ingrese una oferta válida.");
            oferta = sc.nextDouble();
        }
        System.out.println("---------------------------------");
        int opcion;
        do{
            System.out.println("Confirmar una oferta de $" + oferta);
            System.out.println("1. Confirmar");
            System.out.println("2. Cancelar");
            opcion = sc.nextInt();
        }
        while(opcion != 1 && opcion != 2);
        if (opcion ==1){
            int id_o = Util.nextID(nomfile);
            Oferta o = new Oferta(id_o, this.id, v.getId(), oferta, this.correo);
            o.saveFile(nomfile);
            System.out.println("La oferta ha sido puesta exitosamente");
            return true;
        }
        return false;
    }
    
    //extras
    
    public static Comprador searchByID(ArrayList<Comprador> compradores, int id){
        for(Comprador c : compradores){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
    
}
