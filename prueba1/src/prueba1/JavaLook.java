/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

import java.util.Scanner;

/**
 *
 * @author riche
 */
public class JavaLook {
    private static EmailAccount[] cuentas = new EmailAccount[100];
    private static EmailAccount cuentaActiva = null;
    private static Scanner n = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("---------MENU PRINCIPAL----------");
            System.out.println("1.Login");
            System.out.println("2.Crear Cuenta");
            System.out.println("3.Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = n.nextInt();
            n.nextLine(); 
            if (opcion == 1) login();
            else if (opcion == 2) crearCuenta();
        }
    }

    private static void login() {
        System.out.print("Email: ");
        String correo = n.nextLine();
        System.out.print("Password: ");
        String contra = n.nextLine();

        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDireccion().equals(correo) && acc.getContraseña().equals(contra)) {
                cuentaActiva = acc;
                menuPrincipal();
                return;
            }
        }
        System.out.println("Credenciales incorrectas.");
    }
    private static void crearCuenta() {
        System.out.print("Nueva direccion de email: ");
        String correo = n.nextLine();
        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDireccion().equals(correo)) {
                System.out.println("Error: Esta direccion ya existe.");
                return;
            }
        }
        System.out.print("Nombre completo: ");
        String nombre = n.nextLine();
        System.out.print("Password: ");
        String contra = n.nextLine();
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = new EmailAccount(correo, contra, nombre);
                cuentaActiva = cuentas[i];
                System.out.println("Cuenta creada exitosamente.");
                menuPrincipal();
                return;
            }
        }
    }
    private static void menuPrincipal() {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("------ BIENVENIDO " + cuentaActiva.getUsuario() + "-------");
            System.out.println("1. Ver Inbox");
            System.out.println("2. Mandar Correo");
            System.out.println("3. Leer un correo");
            System.out.println("4. Limpiar Inbox");
            System.out.println("5. Cerrar Sesion");
            opcion = n.nextInt();
            n.nextLine();

            switch (opcion) {
                case 1: cuentaActiva.mostrarInbox(); break;
                case 2: mandarCorreo(); break;
                case 3:
                    System.out.print("Ingrese posicion del correo: ");
                    int pos = n.nextInt();
                    cuentaActiva.leerCorreo(pos);
                    break;
                case 4: cuentaActiva.borrarLeidos(); break;
            }
        }
        cuentaActiva = null;
    }

    private static void mandarCorreo() {
        System.out.print("Para (Email): ");
        String destino = n.nextLine();
        System.out.print("Asunto: ");
        String asunto = n.nextLine();
        System.out.print("Mensaje: ");
        String contenido = n.nextLine();
        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDireccion().equals(destino)) {
                Email nuevo = new Email(cuentaActiva.getDireccion(), asunto, contenido);
                if (acc.recibirDirecCorreo(nuevo)) {
                    System.out.println("Enviado con exito.");
                } else {
                    System.out.println("El inbox del destinatario esta lleno.");
                }
                return;
            }
        }
        System.out.println("El destinatario no existe.");
    }
}