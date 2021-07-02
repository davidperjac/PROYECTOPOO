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
    private String tipo;
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
    private int id_registro;
    private RegistroIngresoVehiculos registro;
    private ArrayList<Oferta> ofertas;
    
    // Constructor de Autos
 
    public Vehiculo(int id, String tipo, int id_registro, String placa, String marca, String motor, int anio, String modelo, double recorrido, String color, String combustible, double precio, String vidrios, String transmision){
        this.id = id;
        this.tipo = tipo;
        this.id_registro = id_registro;
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
    }
    
    // Constructor de Camionetas
    
    public Vehiculo(int id, String tipo, int id_registro, String placa, String marca, String motor, int anio, String modelo, double recorrido, String color, String combustible, double precio, String vidrios, String transmision, String traccion){
        this.id = id;
        this.tipo = tipo;
        this.id_registro = id_registro;
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
    }
    
    // Constructor de motos
    
    public Vehiculo(int id, String tipo, int id_registro, String placa, String marca, String motor, int anio, String modelo, double recorrido, String color, String combustible, double precio){
        this.id = id;
        this.tipo = tipo;
        this.id_registro = id_registro;
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

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public RegistroIngresoVehiculos getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroIngresoVehiculos registro) {
        this.registro = registro;
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

    public void saveFile(String nomfile) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Vehiculos.txt"),true)) ) {
            String linea = this.id + "|" + this.tipo + "|" + this.id_registro + "|" + this.getPlaca()+"|"+this.getMarca()+"|"+this.getMotor()+"|"+this.getAnio()+ "|" +this.getModelo()+ "|"+this.getRecorrido()+"|"+this.getColor()+"|"+this.getCombustible()+"|"+this.getPrecio();
            if(this.getTipo().equals("CARRO")) {
                pw.println( linea +"|"+this.getVidrios()+"|"+this.getTransmision() );                                        
            }else if (this.getTipo().equals("MOTO")) {
                pw.println( linea );                                        
            }else if (this.getTipo().equals("CAMIONETA")){
                pw.println( linea +"|"+this.getVidrios()+"|"+this.getTransmision()+"|"+this.getTraccion() );                                        
            } 
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    } 
    
    public static ArrayList<Vehiculo> readFileVehiculo (String nomfile) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        try (Scanner sc = new Scanner(new File(nomfile))) {
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String [] tokens = linea.split("\\|");
                agregarVehiculos(tokens, vehiculos);
            }   
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
    
    /*
    agregarVehiculos(arreglo de strings con atributos de vehiculos, lista de vehiculos)
    Filtra por tipo de Vehiculo, crea una intancia de Vehiculo y lo añade a una lista de Vehiculos
    Es usada en la funcion readFileVehiculo
    */
    public static void agregarVehiculos(String[] tokens, ArrayList<Vehiculo> vehiculos){
        if(tokens[1].equals("CARRO")){
            Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]), tokens[7], Double.parseDouble(tokens[8]), tokens[9], tokens[10], Double.parseDouble(tokens[11]), tokens[12], tokens[13]);
            vehiculos.add(v);
        }
        else if(tokens[1].equals("MOTO")){
            Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]), tokens[7], Double.parseDouble(tokens[8]), tokens[9], tokens[10], Double.parseDouble(tokens[11]));
            vehiculos.add(v);
        }
        else if(tokens[1].equals("CAMIONETA")){
            Vehiculo v = new Vehiculo(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]), tokens[7], Double.parseDouble(tokens[8]), tokens[9], tokens[10], Double.parseDouble(tokens[11]), tokens[12], tokens[13], tokens[14]);
            vehiculos.add(v);
        }
    }
    
    public static void nextVehiculo(Scanner sc, String nomfile, String tipo) {
        if(tipo.equals("CARRO")){
            String[] atributos = validarCarro(sc).split(",");
            int id = Util.nextID(nomfile);
            Vehiculo vehiculo = new Vehiculo(id, tipo, 2, atributos[0], atributos[1], atributos[2], Integer.parseInt(atributos[3]), atributos[4], Double.parseDouble(atributos[5]), atributos[6], atributos[7], Double.parseDouble(atributos[8]), atributos[9], atributos[10]);
            vehiculo.saveFile(nomfile);  
        }
        else if(tipo.equals("CAMIONETA")){
            String[] atributos = validarCarro(sc).split(",");
            int id = Util.nextID(nomfile);
            Vehiculo vehiculo = new Vehiculo(id, tipo, 2, atributos[0], atributos[1], atributos[2], Integer.parseInt(atributos[3]), atributos[4], Double.parseDouble(atributos[5]), atributos[6], atributos[7], Double.parseDouble(atributos[8]), atributos[9], atributos[10], atributos[11]);
            vehiculo.saveFile(nomfile);  
        }
        else if(tipo.equals("MOTOS")){
            String[] atributos = validarCarro(sc).split(",");
            int id = Util.nextID(nomfile);
            Vehiculo vehiculo = new Vehiculo(id, tipo, 2, atributos[0], atributos[1], atributos[2], Integer.parseInt(atributos[3]), atributos[4], Double.parseDouble(atributos[5]), atributos[6], atributos[7], Double.parseDouble(atributos[8]));
            vehiculo.saveFile(nomfile);  
        }  
    }
    
    public static String validarCarro(Scanner sc){      
        String atributos = Util.validarAtributos(sc);             
        System.out.println("Ingrese el tipo de vidrio del vehiculo");
        String vidrios = sc.next().toUpperCase();    
        System.out.println("Ingrese la transmision del vehiculo");
        String transmision = sc.next().toUpperCase();     
        return atributos + "," + vidrios + "," + transmision;
    }

    public static String validarCamioneta(Scanner sc){
        String atributos = Util.validarAtributos(sc);
        System.out.println("Ingrese el tipo de vidrio del vehiculo");
        String vidrios = sc.next().toUpperCase();    
        System.out.println("Ingrese la transmision del vehiculo");
        String transmision = sc.next();
        System.out.println("Ingrese el tipo de traccion del vehiculo");
        String traccion = sc.next();
        return atributos + "," + vidrios + "," + transmision + "," + traccion;
    }
    
    // Busca un Vehiculo por id
    public static Vehiculo searchByID(ArrayList<Vehiculo> vehiculos, int id){
        
        for(Vehiculo v : vehiculos){
            if(v.id == id)
                return v;
        }
        return null;
    }
    
    // Busca un Vehiculo por placa
    public static Vehiculo searchByPlaca(ArrayList<Vehiculo> vehiculos, String placa){
        
        for(Vehiculo v : vehiculos){
            if(v.placa.equals(placa))
                return v;
        }
        return null;
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
