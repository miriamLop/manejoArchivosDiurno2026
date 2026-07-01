/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosSecuenciales;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dylan Duran
 */
public class PrincipalArchivo {

    public static void main(String[] args) throws IOException {
        archivo obj = new archivo();
        Scanner sc = new Scanner(System.in);
        int opc;
        boolean cont = true;
        do {
            System.out.println("\n Menu de opciones");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Adicionar Contacto al Archivo");
            System.out.println("3. Mostrar contenido del Archivo");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Adionar correo");
            System.out.println("6. Salir");
            System.out.println("Digite una opcion");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.agregarcontenido();
                    break;
                case 3:
                    obj.mostrarContenido();
                    break;
                case 4:
                    obj.buscarContacto();
                    break;
                case 5:
                    obj.agregarCorreo();
                    break;
                default:
                    cont = false;
                    break;
            }
        } while (cont);

    }
}
