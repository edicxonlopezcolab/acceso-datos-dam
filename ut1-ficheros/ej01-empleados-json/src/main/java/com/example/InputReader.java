package com.example;

import java.util.Scanner;

public class InputReader 
{
    public static final Scanner sc = new Scanner(System.in);
    
    
    public static String leerCadenaNoVacia(String mensaje)
    {
        while (true) 
        {
            System.out.println(mensaje);
            String linea =sc.nextLine().trim();
            if (!linea.isEmpty()) 
            {
                return linea;    
            }
            System.out.println("digite algo");
        }
    }
    
    public static int leerEntero(String mensaje)
    {
        while (true) 
        {
            String linea = leerCadenaNoVacia(mensaje);
            if (linea.matches("-?\\d+")) 
            {
                return Integer.parseInt(linea); 
            }
            
            System.out.println("Digite un numero entero");
        }
    }

    public static double leerDouble(String mensaje)
    {
        while (true) 
        {
            String linea = leerCadenaNoVacia(mensaje);
            linea = linea.replace(',', '.');
            if (linea.matches("-?\\d+(\\.\\d+)?")) 
            {
                return Double.parseDouble(linea);
            }
            System.out.println("Digite un número decimal válido.");
        }
    }
}

