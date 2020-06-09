/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcoscompany.ADREC02_marcos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class ManejoDatos {
    
    private static int cantFile = 0;
    
    public static String leerFileJson(String json) {
        String file = "", line = "";
        try (BufferedReader leer = new BufferedReader(new FileReader(json))) {          
            while ((line = leer.readLine()) != null) {
                file += line;
            }
            System.out.println("Archivo de configuración Json leido con exito!\n\n");
        } catch (IOException e) {
          e.printStackTrace();          
        }        
        return file;
    }
    
    private static void checkDirect(String path) {
        File directorio = new File(path);
        if (!directorio.exists())  directorio.mkdirs();        
    }
        
    public static Object backUp(String origen, String destino) throws IOException{
        ArrayList <String>  datos = new ArrayList();
        checkDirect(destino);
        double total = 0;
        File directorio = new File(origen);        
        if (directorio.isDirectory()) {
          String[] files = directorio.list();
          if (files.length > 0) {
            for (String archivo : files) {
                cantFile++;
                    try {
                        double inicio = System.currentTimeMillis();
                        File origin = new File(origen+File.separator+archivo);
                        File destination = new File(destino+File.separator+archivo+".backup");
                        InputStream in = new FileInputStream(origin);
                        OutputStream out = new FileOutputStream(destination);
                        byte[] bufer = new byte[1024];
                        int tan;
                        while ((tan = in.read(bufer)) > 0) {
                            out.write(bufer, 0, tan);
                        }
                        in.close();
                        out.close();
                        double fin = System.currentTimeMillis();
                        total = (fin - inicio)/ 1000;                      
                    } catch (FileNotFoundException e) {
                      e.printStackTrace();
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
            }
          }
        }
        datos.add(String.valueOf(total));
        datos.add(String.valueOf(cantFile));
       return datos;
  }
    
    public static void reporte(String rutaInforme, Object objecto) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String datosJson = gson.toJson(objecto);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(rutaInforme);
            pw = new PrintWriter(fichero);
            pw.println(datosJson);
            System.out.println("Informe generado con exito!\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fichero.close();      
        }
    }
    
    
}
