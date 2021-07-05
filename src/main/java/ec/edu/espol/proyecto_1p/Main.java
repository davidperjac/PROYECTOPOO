/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto_1p;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.util.Util;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
    Scanner sc = new Scanner(System.in);
    
    sc.useDelimiter("\n");
    
    System.out.println("Bienvenido al programa de venta de vehiculos /PEREZ/DECASTRO/BUCHELI");
    System.out.println("-----------------------------------------");
    boolean salida = false;
    while (!salida) {
        System.out.println("Menu de Opciones");
        System.out.println("1.-Vendedor");
        System.out.println("2.-Comprador");
        System.out.println("3.-Salir");
        
        int opPrincipal = sc.nextInt();
        
        
        if(opPrincipal == 1) {
            boolean salida2 = false;
            while (!salida2) {
                int opcionVend = Util.menuVendedor(sc);
                if (opcionVend == 1) {
                    Usuario.nextUsuario(sc, "vendedores.txt");
                }else if(opcionVend == 2) {
 
                    Vendedor v = Util.inicioSesionV(sc);
                    v.ingresarVehiculo(sc, "vehiculos.txt");
                    
                }else if(opcionVend == 3) {
                    
                    Vendedor v = Util.inicioSesionV(sc);
                    v.verOfertas(sc);
                    //mandar correo
                    //v.enviarCorreo(destinatario, v.getCorreo(), v.getClave());
                    
                }else if(opcionVend == 4){
                    salida2 = true;
                }
            }
        
        }else if(opPrincipal == 2) {
            boolean salida3 = false;
            while(!salida3){
                int opComp = Util.menuVendedor(sc);
                if(opComp == 1){
                    Usuario.nextUsuario(sc, "compradores.txt");
                } else if(opComp == 2){
                    Comprador c = Util.inicioSesionC(sc);
                    // c.ofertarVehiculo()
                } else if(opComp == 3)
                    salida3 = true;
            }
        
            
        }else if(opPrincipal ==3) {
            salida = true;
        }else {
            System.out.println("ERROR! Escoga una opcion correcta");
        }

        
    }
         
    }
    
}
