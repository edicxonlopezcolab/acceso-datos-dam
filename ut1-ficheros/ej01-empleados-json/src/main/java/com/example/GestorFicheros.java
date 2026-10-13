package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GestorFicheros 
{
    public void exportarEnJson (ArrayList<EmpleadoModel> empleados)
    {
        Path ruta = Path.of("data", "empleados.json");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        try 
        {
            Files.createDirectories(ruta.getParent());

            try (FileWriter writer = new FileWriter(ruta.toFile(), StandardCharsets.UTF_8)) 
            {
                gson.toJson(empleados, writer);
            }
        }
        catch (IOException e) 
        {
            System.out.println("error al exportar: " + e.getMessage());
        }
    }

    public ArrayList<EmpleadoModel> leerDeJson ()
    {
        Path ruta = Path.of("data", "empleados.json");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        Type tipo = new TypeToken<ArrayList<EmpleadoModel>>() {}.getType();

        try (FileReader reader = new FileReader(ruta.toFile(), StandardCharsets.UTF_8)) 
        {
            ArrayList<EmpleadoModel> leidos = gson.fromJson(reader, tipo);
            if (leidos != null) 
            {
                return leidos;
            }
        }
        catch (IOException e) 
        {
            System.out.println("error al leer: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}