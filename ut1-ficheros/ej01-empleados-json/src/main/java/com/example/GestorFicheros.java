package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GestorFicheros 
{
    //Gson gson = new Gson();
    


    public void exportarEnJson (ArrayList<EmpleadoModel> empleados)
    {
        
        try 
        {
            Path carpeta = Paths.get("data");
            if (!Files.exists(carpeta)) 
            {
                Files.createDirectories(carpeta);
            }
        }
        catch (Exception e) 
        {
            System.out.println("error al exportar: " + e.getMessage());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(empleados);
    }
}
