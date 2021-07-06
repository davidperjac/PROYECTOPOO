/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.util.Util;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author davidperez
 */
public class Vendedor extends Usuario{
    
    private ArrayList<Vehiculo> vehiculos;    

    //Constructor
    
    public Vendedor ( int id,String correo, String clave, String nombres, String apellidos, String organizacion) {
        super(id,correo,clave,nombres,apellidos,organizacion);
        this.vehiculos = new ArrayList<>();
    }
    
    public Vendedor(Usuario u){
        super(u.getId(), u.getCorreo(), u.getClave(), u.getNombres(),u.getApellidos(),u.getOrganizacion());
        this.vehiculos = new ArrayList<>();   
    }
    
    //getters y setters

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    //comportamientos

    public void ingresarVehiculo(Scanner sc,String nomfile) {
        
        System.out.println("Ingrese el tipo de Vehiculo");
        String tipo = sc.next().toUpperCase();
        
        while ( (!tipo.equals("MOTO")  )&&((!tipo.equals("CARRO"))&&((!tipo.equals("CAMIONETA"))  ))) {
            System.out.println("ERROR! Ingrese un tipo valido");
            tipo = sc.next().toUpperCase();   
        }
        
        Vehiculo.nextVehiculo(sc, nomfile, tipo, this.id);
        
        System.out.println("Su vehiculo se ha ingresado al sistema exitosamente");
        
    }
    

    // Main fernando : recibe una lista de vehiculos del main y compara la placa de esa lista
    public void verOfertas (Scanner sc) {
        
        System.out.println("Ingrese la placa del vehiculo");
        String placa = sc.next();
        
        while (!Util.validarPlaca(placa)) {
            System.out.println("ERROR! Placa incorrecta, ingrese una placa valida");
            placa = sc.next();
        }
        
        //Vehiculo carroEscogido = null;
        this.vehiculos = Vehiculo.linkVehiculo("vehiculos.txt", this.id);
        Vehiculo.linkOfertas(vehiculos);
        for (Vehiculo v : this.vehiculos) {
            if (v.getPlaca().equals(placa)) {
                Oferta o = v.menuOfertas(sc);
                if(o != null){
                    // funcion de mandar email y necesito el correo del comprador.
                    Vendedor.enviarCorreo(o.getCorreo_comprador(),v.getMarca(),v.getModelo(),v.getMotor(),o.getPrecio_ofertado(),v.getPlaca());
                    //borrar en base de datos
                    v.borrarVehiculo();

                }
            }
        }
        
        /*
        System.out.println(carroEscogido.getModelo()+"Precio:"+carroEscogido.getPrecio());
        System.out.println("Se han realizado "+carroEscogido.getOfertas().size()+" ofertas");
        
        
        boolean aceptar = false ; 
        while (aceptar == false) {
            int numeroOferta = 1 ; 
            for (int i = 0 ; i < carroEscogido.getOfertas().size(); i++ ) {             
                boolean opcion = false;      
                while (opcion == false ) {
                    System.out.println("Oferta "+numeroOferta);
                    System.out.println("Correo: "+ carroEscogido.getOfertas().get(i).getComprador().getCorreo());
                    System.out.println("Precio Ofertado: "+carroEscogido.getOfertas().get(i).getPrecio_ofertado());  
                    if (i == 0) {
                        int seleccion = 0 ;
                            while ( (seleccion != 1) && (seleccion != 2) ) {
                                System.out.println("1.- Siguiente Oferta");
                                System.out.println("2.- Aceptar Oferta");
                                seleccion = sc.nextInt();
                            }
                        if (seleccion == 1) {   
                            opcion = true ;
                            numeroOferta++;
                        }else if (seleccion == 2) {
                            //eliminacion de oferta en sistema y en la lista
                            Util.removerLinea("ofertas.txt", this.ofertas.get(i).getId_Vehiculo(), 2);
                            //enviar correo al usuario
                            
                            //salir del menu
                            aceptar = true;
                        }
                    }else if (i > 0 ) {   
                        int seleccion = 0 ;
                        while ( (seleccion != 1) && (seleccion != 2) && (seleccion != 3) ) {
                            System.out.println("1.- Siguiente Oferta");
                            System.out.println("2.- Anterior Oferta");
                            System.out.println("3.- Aceptar Oferta");
                            seleccion = sc.nextInt();
                        }  
                        if (seleccion == 1) {        
                            opcion = true ;
                            numeroOferta++;        
                        }else if (seleccion == 2) {
                            i -= 2;
                            opcion = true; 
                            numeroOferta--;
                        }else if (seleccion == 3) {
                            //eliminacion de oferta en sistema y en la lista
                            Util.removerLinea("ofertas.txt", this.ofertas.get(i).getId_Vehiculo(), 2);
                            
                            //enviar correo al usuario
                            
                            //salir del menu
                            aceptar = true;
                        }
                    }
                }
            }
        }
        */
        
    }
    
    //extras 
    
    public static void enviarCorreo(String destinatario, String marca, String modelo,String motor, double dinero, String placa) {

        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        
        props.put("mail.smtp.user", "sistema.sdf.poo@gmail.com");
        props.put("mail.smtp.clave", "ProyectoPOO");    //La clave de la cuenta


        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject("Oferta aceptada");
            message.setText("Un gusto le saluda el sistema de la app SDF. Se ha aceptado su oferta de "+dinero+" por el vehiculo "+marca+" "+modelo+" "+motor+" con la placa: "+placa);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "sistema.sdf.poo@gmail.com", "ProyectoPOO");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception e) {
            e.printStackTrace();   //Si se produce un error
        }
    }
    
    public static Vendedor searchByID(ArrayList<Vendedor> vendedores, int id){
        for(Vendedor v : vendedores){
            if(v.getId() == id){
                return v;
            }
        }
        return null;
    }
    //sobreescrituras
    @Override
    public String toString(){
        return " "+super.nombres+"-"+super.apellidos+"-"+super.correo+"-"+super.clave+"-"+super.organizacion;    
    }
    
}
