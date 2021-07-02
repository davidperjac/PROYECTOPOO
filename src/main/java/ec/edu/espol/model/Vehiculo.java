/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author davidperezPOOpo
 */
public class Vehiculo {

    private int id;
    private String placa;
    private String marca;
    private String motor;
    private int anio;
    private String modelo;
    private double recorrido;
    private String color; 
    private String combustible; 
    private double precio;  
    private String vidrios;  
    private String transmision;
    private String traccion; 
    private String tipo;
    private ArrayList<Oferta> ofertas;
    private String correo_vendedor;
    private Vendedor vendedor;
    
    
    // Constructor de Autos
 
    public Vehiculo(int id,String correo_vendedor, String placa, String marca, String motor, int anio, String modelo, double recorrido, String color, String combustible, double precio, String vidrios, String transmision, String tipo){
        this.id = id;
        this.correo_vendedor = correo_vendedor;
        this.vendedor = vendedor;
        this.placa = placa;
        this.marca = marca;
        this.motor = motor;
        this.anio = anio;
        this.modelo = modelo;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.ofertas = new ArrayList<>();
        this.tipo = tipo;
    }
    
    // Constructor de Camionetas
    
    public Vehiculo(int id,String correo_vendedor, String placa, String marca, String motor, int anio, String modelo, double recorrido, String color, String combustible, double precio, String vidrios, String transmision, String traccion, String tipo){
        this.id = id;
        this.correo_vendedor = correo_vendedor;
        this.vendedor = vendedor;
        this.placa = placa;
        this.marca = marca;
        this.motor = motor;
        this.anio = anio;
        this.modelo = modelo;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;
        this.ofertas = new ArrayList<>();
        this.tipo = tipo;
    }
    
    // Constructor de motos
    
    public Vehiculo(int id,String correo_vendedor, String placa, String marca, String motor, int anio, String modelo, double recorrido, String color, String combustible, double precio,String tipo){
        this.id = id;
        this.correo_vendedor = correo_vendedor;
        this.vendedor = vendedor;
        this.placa = placa;
        this.marca = marca;
        this.motor = motor;
        this.anio = anio;
        this.modelo = modelo;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.ofertas = new ArrayList<>();
        this.tipo = tipo;
    }

    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public String getCorreo_vendedor() {
        return correo_vendedor;
    }

    public void setCorreo_vendedor(String correo_vendedor) {
        this.correo_vendedor = correo_vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
    /* 
    Metodo para  permitirle al vendedor revisar ofertas del vehiculo;
    Puede avanzar o retroceder de oferta
    Puede aceptar la oferta
    Puede salir 
    */
    
    public void verOfertas(Scanner sc){
        if(!this.ofertas.isEmpty()){
            System.out.println("Se han realizado: " + this.ofertas.size());
            int i = 0;
            int opcion = 0;
            while(opcion != 4){
                System.out.println("Oferta " + (i+1) + "\n" + ofertas.get(i));
                System.out.println("1 : siguiente oferta\n2: anterior oferta\n3 : aceptar oferta\n4 : salir");
                opcion = sc.nextInt();
                if(opcion == 1){
                    if(i == (this.ofertas.size() - 1))
                        i = 0;
                    else
                        i += 1;       
                }
                else if(opcion == 2){
                    if(i == 0)
                        i = this.ofertas.size() - 1;
                    else
                        i -= 1;
                }
                else if(opcion == 3)
                    //this.vendedor.aceptarOferta(i);
                    this.ofertas.remove(i);
                    opcion = 4;
            }
        }
        else
            System.out.println("No hay ofertas para este vehiculo");       
    }
    
    public void removerOferta(int i){
        this.ofertas.remove(i);
    }
    
    public Vehiculo nextVehiculo(Scanner sc,String nomfile) {
        super.validarCorreo();
        
        //tipo  
        System.out.println("Ingrese el tipo de vehiculo (carro,moto o camioneta)");
        String tipo = sc.next().toUpperCase();
        while (  (!tipo.equals("CARRO")) && (!tipo.equals("MOTO") ) && (!tipo.equals("CAMIONETA")) ) {
            System.out.println("ERROR! Ingrese un tipo correcto");
            tipo = sc.next();
        }    
        //Atributos   
        //placa        
        System.out.println("Ingrese la placa del vehiculo");
        String placa = Util.validarPlaca(sc.next().toUpperCase(), sc);   
        //marca       
        System.out.println("Ingrese la marca del vehiculo");
        String marca = sc.next();
        //modelo             
        System.out.println("Ingrese el modelo del vehiculo");
        String modelo = sc.next();       
        //motor           
        System.out.println("Ingrese el tipo de motor del vehiculo");
        String motor = sc.next();       
        //año   
        System.out.println("Ingrese el año del vehiculo");
        int anio = sc.nextInt();  
        while (anio < 1856) {
            System.out.println("ERROR! año invalido");
            System.out.println("Ingrese el año del vehiculo");
            anio = sc.nextInt();
        }
        //recorrido 
        System.out.println("Ingrese el recorrido que tiene el vehiculo");
        int recorrido = sc.nextInt();
        while (recorrido < 0) {
            System.out.println("ERROR! recorrido invalido");
            System.out.println("Ingrese el recorrido que tiene el vehiculo");
            recorrido = sc.nextInt();
        }
        //color
        System.out.println("Ingrese el color del vehiculo");
        String color = sc.next();
        //Combustible
        System.out.println("Ingrese el tipo de combustible del vehiculo (SUPER,EXTRA,ECOPAIS,DIESEL)");
        String combustible = sc.next().toUpperCase();        
        while ( ( !combustible.equals("SUPER")  ) && ( !combustible.equals("EXTRA") ) && ( !combustible.equals("ECOPAIS")) && ( !combustible.equals("DIESEL"))  ) {
            System.out.println("ERROR! combustible invalido");
            System.out.println("Ingrese el tipo de combustible del vehiculo (SUPER,EXTRA,ECOPAIS,DIESEL)");
            combustible = sc.next().toUpperCase();
        }        
        //precio       
        System.out.println("Ingrese el precio del vehiculo");
        int precio = sc.nextInt();      
        while (precio < 0 ) {
            System.out.println("ERROR! precio invalido");
            System.out.println("Ingrese el precio del vehiculo");
            precio = sc.nextInt();
        }       
        //idVendedor       
        String correoVendedor = this.correo_vendedor;      
        //validaciones del tipo     
        if (!tipo.equals("MOTO")) {
            System.out.println("Ingrese el tipo de vidrio del vehiculo");
            String vidrios = sc.next().toUpperCase();    
            System.out.println("Ingrese la transmision del vehiculo");
            String transmision = sc.next().toUpperCase();     
            while ( !(transmision.equals("MANUAL")) && ( !transmision.equals("AUTOMATICO")) ) {
                System.out.println("ERROR! transmision erronea");
                System.out.println("Ingrese la transmision del vehiculo");
                transmision = sc.next().toUpperCase();
            }
            if (tipo.equals("CARRO")) {
                int id = Util.nextID(nomfile);
                Vehiculo vehiculo = new Vehiculo(id,correoVendedor, placa, marca, motor, anio, modelo, recorrido,color,combustible, precio, vidrios, transmision,tipo);
                vehiculo.saveFileVehiculos(nomfile);
                return vehiculo;       
            }else if (tipo.equals("CAMIONETA")) {
                System.out.println("Ingrese el tipo de traccion del vehiculo");
                String traccion = sc.next();                
                int id = Util.nextID(nomfile);
                Vehiculo vehiculo = new Vehiculo(id,correoVendedor, placa, marca, motor, anio, modelo, recorrido,color,combustible, precio, vidrios, transmision,traccion,tipo);
                vehiculo.saveFileVehiculos(nomfile);
                return vehiculo;
            }
        }
        else if (tipo.equals("MOTO")) {
            int id = Util.nextID(nomfile); 
            Vehiculo vehiculo = new Vehiculo(id,correoVendedor, placa, marca, motor, anio, modelo, recorrido,color,combustible, precio,tipo);
            vehiculo.saveFileVehiculos(nomfile);
            return vehiculo;
        }
    }
    
    //extras 

    public void saveFileVehiculos(String nomfile) {
        
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Vehiculos.txt"),true)) ) {
            
            String sb = new StringBuilder(this.getPlaca()+"|"+this.getMarca()+"|"+this.getModelo()+"|"+this.getMotor()+"|"+this.getAnio()+"|"+this.getRecorrido()+"|"+this.getColor()+"|"+this.getCombustible()+"|"+this.getPrecio()).toString();
            
            if (this.getTipo().equals("CARRO")) {
                pw.println( sb+"|"+this.getVidrios()+"|"+this.getTransmision() );                                        
            }else if (this.getTipo().equals("MOTO")) {
                pw.println( sb );                                        
            }else if (this.getTipo().equals("CAMIONETA")){
                pw.println( sb+"|"+this.getVidrios()+"|"+this.getTransmision()+"|"+this.getTraccion() );                                        
            } 
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    } 
    
    public static ArrayList<Vehiculo> readFileVehiculo (String nomfile) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        
        try (Scanner sc = new Scanner(new File(nomfile))) {
            
            String linea = sc.nextLine();
            String [] tokens = linea.split("\\|");
            Vehiculo v = new Vehiculo()
            
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    @Override
    public String toString() {
        return "Vehiculo { id:"+ this.id + "placa: " + placa + ", marca: " + marca + ", motor: " + motor + ", anio: " + anio + ", modelo: " + modelo + ", recorrido: " + recorrido + ", color: " + color + ", combustible: " + combustible + ", precio: " + precio + ", tipo: " + tipo + "}";
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(o == this)
            return true;
        if(o.getClass() != this.getClass())
            return false;
        
        Vehiculo other = (Vehiculo)o;
        
        return Objects.equals(this.id, other.id);   
    }
        
}
