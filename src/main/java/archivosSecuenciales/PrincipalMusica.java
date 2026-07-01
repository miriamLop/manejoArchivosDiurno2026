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
public class PrincipalMusica {
    public static void main(String[] args) throws IOException {
         Musica obj=new Musica();
        Scanner sc=new Scanner(System.in);
        int opc;
        boolean cont=true;
        do {            
            System.out.println("\n Menu de opciones");
            System.out.println("1. Crear musica");
            System.out.println("2. Adicionar contenido");
            System.out.println("3. Adicionar duracion");
            System.out.println("4. Mostrar datos");
            System.out.println("5. Mostrar por genero");
            System.out.println("6. Mostrar por Artista");
            System.out.println("7. Salir");
            System.out.println("Digite una opcion");
            opc=sc.nextInt();
            sc.nextLine();
            
            switch (opc) {
                case 1:obj.crearArchivoMusical();break;
                case 2:obj.agregarcontenidoMusical();break;
                case 3:obj.asignarDuracionPorTema();break;
                case 4:obj.mostrarContenido();break;
                case 5:obj.mostrarPorGenero();break;
                case 6:obj.mostrarPorArtista();break;
                
                default:
                    throw new AssertionError();
            }
        } while (cont);
        
    }
    
}
