/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto_1p;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.util.Util;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
    

    boolean salida = false;
    
    while (!salida) {
        
        Util.menuInicio();
        
        int opPrincipal = sc.nextInt();
        
        
        if(opPrincipal == 1) {
            boolean salida2 = false;
            while (!salida2) {
                int opcionVend = Vendedor.menuVendedor(sc);
                if (opcionVend == 1) {
                    Usuario.nextUsuario(sc, "vendedores.txt");
                }else if(opcionVend == 2) {
 
                    Vendedor v = Vendedor.inicioSesionV(sc);
                    v.ingresarVehiculo(sc, "vehiculos.txt");
                    
                }else if(opcionVend == 3) {
                    
                    Vendedor v = Vendedor.inicioSesionV(sc);
                    v.verOfertas(sc);
                    
                }else if(opcionVend == 4){
                    salida2 = true;
                }
            }
        
        }else if(opPrincipal == 2) {
            boolean salida3 = false;
            while(!salida3){
                int opComp = Comprador.menuComprador(sc);
                if(opComp == 1){
                    Usuario.nextUsuario(sc, "compradores.txt");
                } else if(opComp == 2){
                    Comprador c = Comprador.inicioSesionC(sc);
                    ArrayList<Vehiculo> listaFiltrada = Comprador.busquedaVehiculo(sc, Vehiculo.readFile("vehiculos.txt"));
                    Vehiculo vehiculoEscogido = Comprador.elegirVehiculo(sc, listaFiltrada);
                    c.ponerOferta(vehiculoEscogido,"ofertas.txt", sc);
                } else if(opComp == 3)
                    salida3 = true;
            }
        
            
        }else if(opPrincipal ==3) {
            salida = true;
        }else {
            System.out.println("ERROR! Escoga una opcion correcta"+"\n");
        }

        
    }
         
    }
    
}
