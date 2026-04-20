/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author riche
 */
public class EmailAccount {
    private String direccion;
    private String contraseña;
    private String usuario;
    private Email[] inbox;
    
    public EmailAccount(String direccion,String contraseña,String usuario){
    this.direccion=direccion;
    this.contraseña=contraseña;
    this.usuario=usuario;
    this.inbox= new Email[100];
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public boolean recibirDirecCorreo(Email email){
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] == null) {
                inbox[i]=email;
                return true;
            }
        }
        return false;
    }
    
    public void mostrarInbox(){
        System.out.println("Direccion: "+direccion);
        System.out.println("Nombre: "+usuario);
        
        int sinLeer=0;
        int total=0;
        
        for(int i=0; i< inbox.length; i++){
            if(inbox[i]!=null){
                total++;
                String estado = inbox[i].isLeido()?"LEIDO": "SIN LEER";
                if (!inbox[i].isLeido()){
                    sinLeer++;
                }
                
                System.out.println((i+1)+" - "+inbox[i].getDirecEmisor()+" - "+inbox[i].getAsunto()+" - "+estado);
            }
        }
        
        System.out.println("Cantidad de correos sin leer: "+sinLeer);
        System.out.println("Total de correos recibidos: "+total);
    }
    
    public void leerCorreo(int posicion) {
        int indice = posicion - 1; 
        if (indice >= 0 && indice < inbox.length && inbox[indice] != null) {
            inbox[indice].imprimir();
            inbox[indice].marcarLeido();
        } else {
            System.out.println("Correo No Existe");
        }
    }

    public void borrarLeidos() {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null && inbox[i].isLeido()) {
                inbox[i] = null;
            }
        }
    }
    }
    

