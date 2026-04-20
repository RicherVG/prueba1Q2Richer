/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba1;

/**
 *
 * @author riche
 */
public class Email{
    private String direcEmisor;
    private String asunto;
    private String mensaje;
    private boolean leido;
    
    public Email(String direcEmisor, String asunto,String mensaje){
        this.direcEmisor=direcEmisor;
        this.asunto=asunto;
        this.mensaje=mensaje;
        this.leido=false;
    }
    public String getDirecEmisor(){
        return direcEmisor;
    }
    public String getAsunto(){
        return asunto;
    }
    public String getMensaje(){
        return mensaje;
    }
    
    public boolean isLeido(){
        return leido;
    }
    
    public void marcarLeido(){
        this.leido=true;
    }
    
    public void imprimir(){
        System.out.println("DE: "+direcEmisor);
        System.out.println("ASUNTO: "+asunto);
        System.out.println(mensaje);
    }
    
}
