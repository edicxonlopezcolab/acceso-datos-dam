package com.example;

import java.util.ArrayList;
import java.util.Iterator;

public class EmpleadoView 
{
    public void mostrarMenu()
    {
        String encabezado =("Depaetamento Empleados");
        System.out.println("\n" + "=".repeat(20));
        System.out.println(encabezado);
        System.out.println("=".repeat(20));
        System.out.println("Menu:");
        System.out.println("1. Dar de alta empleados");
        System.out.println("2. Exportar a JSON");
        System.out.println("3. Leer JSON");
        System.out.println("4. Mostrar empleados");
        System.out.println("0. Salir\n");
    }

    public void mostrarEmpleados(ArrayList<EmpleadoModel> empleados)
    {
        Iterator<EmpleadoModel> it = empleados.iterator();
        while (it.hasNext()) 
        {
            EmpleadoModel empleado = it.next();
            System.out.println(empleado);

        }
    }
}
