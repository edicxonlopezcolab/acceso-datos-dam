package com.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoController 
{
    private final EmpleadoModel model;
    private final EmpleadoView view;
    GestorFicheros gestor = new GestorFicheros();
    ArrayList<EmpleadoModel> empleados = new ArrayList<EmpleadoModel>();

    public EmpleadoController(EmpleadoModel model, EmpleadoView view)
    {
        this.model = model;
        this.view = view;
    }

    public void iniciar()
    {
        boolean salir = false;
        while (!salir) 
        {
            view.mostrarMenu();
            int opcion = InputReader.leerEntero("Digite una opcion");
            switch (opcion) 
            {
                case 1:
                    altaEmpleado();
                    break;
                case 2:
                    if (empleados.isEmpty()) 
                    {
                        System.out.println("No hay empleados para exportar.");
                    } 
                    else 
                    {
                        gestor.exportarEnJson(empleados);
                    }
                    break;
                case 3:
                    ArrayList<EmpleadoModel> leidos = gestor.leerDeJson();
                    System.out.println("El fichero contiene " + leidos.size() + " empleados:");
                    for (EmpleadoModel e : leidos)
                    {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    if(empleados.isEmpty())
                    {
                        System.out.println("no hay empleados");
                    }
                    else
                    {
                        view.mostrarEmpleados(empleados);
                    }
                    break;
            
                case 0:
                    salir = true;
                    System.out.println("chao");
                    break;
            }
        }
    }

    public void altaEmpleado()
    {
        String dni = InputReader.leerCadenaNoVacia("Digite el DNI: ");
        String nombre = InputReader.leerCadenaNoVacia("Digite el Nombre: ");
        
        LocalDate fechaAlta = null;
        boolean fechaValida = false;

        while (!fechaValida) 
        {
            String inputFecha = InputReader.leerCadenaNoVacia("Digite la fecha (yyyy-MM-dd): ");
            try 
            {
                fechaAlta = LocalDate.parse(inputFecha);
                fechaValida = true;
            } 
            catch (Exception e) 
            {
                System.out.println("Fecha no valida, Intente de nuevo");
            }
        }
        
        double salarioMensual = InputReader.leerDouble("Digite el salario"); 

        boolean activo = false;
        boolean activoValido = false;

        while (!activoValido) 
            {
            String respuesta = InputReader.leerCadenaNoVacia("¿Activo? (s/n): ").toLowerCase();
            
            if (respuesta.equals("s")) 
            {
                activo = true;
                activoValido = true; 
            } 
            else if (respuesta.equals("n")) 
            {
                activo = false;
                activoValido = true; 
            } 
            else 
            {
                System.out.println("Opcion no valida. Escribe 's' o 'n'");
            }
        }
        EmpleadoModel nuevoEmpleado = new EmpleadoModel(dni, nombre, fechaAlta, salarioMensual, activo);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado creado");
    }
}
