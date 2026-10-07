package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EmpleadoModel model = new EmpleadoModel();
        EmpleadoView view = new  EmpleadoView();

        EmpleadoController controller = new EmpleadoController(model, view);
        controller.iniciar();
    }
}