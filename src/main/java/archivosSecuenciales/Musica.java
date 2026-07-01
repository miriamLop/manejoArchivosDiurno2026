/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosSecuenciales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dylan Duran
 */
public class Musica {
    private List<String> contenidoMusica;
    Scanner sc = new Scanner(System.in);
    Path path = Paths.get("F:\\segundo año\\Programación II\\PrograII\\manejoArchivos\\musica.csv");

    public Musica() {
        contenidoMusica = new ArrayList<>();
    }

    public void crearArchivoMusical() {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Archivo Creado");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarcontenidoMusical() {
        String nombre, artista, genero, res;
        res = "S";
        
        try {
            do {
                System.out.println("Digite el nombre del Tema");
                nombre = sc.nextLine();
                System.out.println("Digite el Artista");
                artista = sc.nextLine();
                System.out.println("Digite el Genero Musical");
                genero = sc.nextLine();

                String texto = nombre + ";" + artista + ";" + genero + ";\n";

                Files.write(path, texto.getBytes(), StandardOpenOption.APPEND);
                System.out.println("Desea Agregar Contenido S/N");
                res = sc.nextLine();
            } while (res.equalsIgnoreCase("S"));
        } catch (Exception e) {
        }
    }

    public void mostrarContenido() throws IOException {
        try {
            contenidoMusica = Files.readAllLines(path);
            System.out.println("--------------contenido del archivo----------------");
            for (String linea : contenidoMusica) {
                String[] datos = linea.split(";");
                System.out.println("Nombre: " + datos[0]);
                System.out.println("Artista: " + datos[1]);
                System.out.println("Genero: " + datos[2]);
                if(datos.length==4){
                    System.out.println("Duracion: "+datos[3]);
                }
                System.out.println("--------------**--------------- \n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void asignarDuracionPorTema() throws IOException {
        String temaBuscar, duracion;
        int sw = 0;
        String[] linea;
        
        try {
            contenidoMusica=Files.readAllLines(path);
            if(!contenidoMusica.isEmpty()){
                System.out.println("Digite el tema a buscar para agregar duracion");
                temaBuscar=sc.nextLine();
                for(int i=0;i<contenidoMusica.size();i++){
                    linea=contenidoMusica.get(i).split(";");
                    if(linea[0].equalsIgnoreCase(temaBuscar)){
                        sw=1;
                        System.out.println("tema encontrado");
                        System.out.println("Digite la duracion ");
                        duracion=sc.nextLine();
                        String nl=linea[0]+" ; "+linea[1]+" ; "+linea[2]+" ; "+duracion;
                        contenidoMusica.set(i, nl);
                        System.out.println("Duracion agregada correctamente");
                    }
                }
                
                if(sw==0){
                    System.out.println("tema no encontrado");
                }
                Files.write(path, contenidoMusica, StandardOpenOption.TRUNCATE_EXISTING);
            }else{
                System.out.println("el archivo esta vacio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPorGenero() {
        
        System.out.println("Digite el genero musical a buscar:");
        String generoBuscar = sc.nextLine();
        try {
            contenidoMusica = Files.readAllLines(path);
            System.out.println("\n------- Temas del genero: " + generoBuscar + " -------");
            for (String linea : contenidoMusica) {
                String[] datos = linea.split(";");
                if (datos[2].equalsIgnoreCase(generoBuscar)) {
                    System.out.println("Nombre: " + datos[0]);
                    System.out.println("Artista: " + datos[1]);
                    
                    System.out.println("------------------------------------");
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPorArtista() {
        System.out.println("Digite el nombre del artista a buscar:");
        String artistaBuscar = sc.nextLine();
        try {
            contenidoMusica = Files.readAllLines(path);
            System.out.println("\n------- Temas del artista: " + artistaBuscar + " -------");
            for (String linea : contenidoMusica) {
                String[] datos = linea.split(";");
                if (datos[1].equalsIgnoreCase(artistaBuscar)) {
                    System.out.println("Nombre: " + datos[0]);
                    System.out.println("Genero: " + datos[2]);
                    System.out.println("------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

