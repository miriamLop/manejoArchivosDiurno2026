/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosSecuenciales;

import java.io.File;
import java.io.IOException;
import java.net.StandardSocketOptions;
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
public class archivo {

    private List<String> contenido;

    Scanner sc = new Scanner(System.in);

    public archivo() {
        contenido = new ArrayList<>();
    }

    public void crearArchivo() {
        Path path = Paths.get("D:\\programacion\\archivoDiurno\\manejoArchivosDiurno2026\\miArchivo.txt");
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

    public void agregarcontenido() {
        String nombre, celular, parentesco, res, texto;
        res = "S";
        Path path = Paths.get("D:\\programacion\\archivoDiurno\\manejoArchivosDiurno2026\\miArchivo.txt");
        try {
            do {
                System.out.println("Digite el nombre de contacto");
                nombre = sc.nextLine();
                System.out.println("Digite el Nro de Celular");
                celular = sc.nextLine();
                System.out.println("Digite el parentesco");
                parentesco = sc.nextLine();
                texto = nombre + "-" + celular + "-" + parentesco + "\n";
                Files.write(path, texto.getBytes(), StandardOpenOption.APPEND);
                System.out.println("Desea Agregar Contenido S/N");
                res = sc.nextLine();
            } while (res.equalsIgnoreCase("S"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarContenido() throws IOException {
        Path path = Paths.get("D:\\programacion\\archivoDiurno\\manejoArchivosDiurno2026\\miArchivo.txt");
        String contacto[];
        try {
            contenido = Files.readAllLines(path);
            if (!contenido.isEmpty()) {
                System.out.println("--------------contenido del archivo----------------");
                for (String linea : contenido) {
                    contacto = linea.split("-");
                    System.out.println("Nombre: " + contacto[0]);
                    System.out.println("Nro. Celular: " + contacto[1]);
                    System.out.println("Parentesco: " + contacto[2]);
                    if (contacto.length > 3) {
                        System.out.println("Correo: " + contacto[3]);
                    }
                    System.out.println("--------------**--------------- \n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void buscarContacto() throws IOException {
        String nomContacto;
        int sw = 0;
        String[] linea;
        Path path = Paths.get("D:\\programacion\\archivoDiurno\\manejoArchivosDiurno2026\\miArchivo.txt");
        try {
            if (Files.exists(path)) {
                System.out.println("Digite el nombre del contacto a buscar");
                nomContacto = sc.nextLine();
                contenido = Files.readAllLines(path);
                if (!contenido.isEmpty()) {
                    for (String contcato : contenido) {
                        linea = contcato.split("-");
                        if (linea[0].equalsIgnoreCase(nomContacto)) {
                            sw = 1;
                            System.out.println("Nombre: " + linea[0]);
                            System.out.println("Nro. Celular: " + linea[1]);
                            System.out.println("Parentesco: " + linea[2]);
                            System.out.println("--------------**--------------- \n");
                        }

                    }
                    if (sw == 0) {
                        System.out.println("el contacto buscado no esta registrado");
                    }
                } else {
                    System.out.println("El archivo esta vacio");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void agregarCorreo() {
        String nombre, correo;
        int sw = 0;
        String[] linea;
        Path path = Paths.get("D:\\programacion\\archivoDiurno\\manejoArchivosDiurno2026\\miArchivo.txt");
        try {
            contenido = Files.readAllLines(path);
            if (!contenido.isEmpty()) {
                System.out.println("Digite el nombre del contacto para Adicionar el correo");
                nombre = sc.nextLine();
                for (int i = 0; i < contenido.size(); i++) {
                    linea = contenido.get(i).split("-");
                    if (linea[0].equalsIgnoreCase(nombre)) {
                        sw = 1;
                        System.out.println("Contacto Encontrado! " + nombre);
                        System.out.println("Digite el Correo Electronico");
                        correo = sc.nextLine();
                        String nl = linea[0] + "-" + linea[1] + "-" + linea[2] + "-" + correo;
                        //adicionamos en la posicion i de la lista la nueva linea
                        contenido.set(i, nl);
                        System.out.println("Correo agregado correctamente ");

                    }
                }
                if (sw == 0) {
                    System.out.println("contacto no encontrado");
                }
                Files.write(path, contenido, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                System.out.println("el archivo esta vacio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
