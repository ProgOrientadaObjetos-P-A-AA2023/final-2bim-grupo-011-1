/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajoFinal1;

import java.util.Scanner;
import paquete2.*;

/**
 *
 * @author sebas
 */
public class Inicio {

    /**
     * En el método (main) de la clase a Ejecutar. En un ciclo repetitivo el
     * usuario puede decidir que tipo de Plan desea crear para la empresa de
     * acuerdo a las opciones: PlanPostPagoMinutos, PlanPostPagoMegas,
     * PlanPostPagoMinutosMegas, PlanPostPagoMinutosMegasEconomico. De acuerdo a
     * la opción, el usuario ingresa por teclado los datos necesarios para crear
     * el objeto. Luego de crear el objeto; se debe guardar en la base datos
     * Finalizado el ciclo (cuando lo decida el usuario); se debe presentar
     * todos los objetos guardados en la base de datos.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        byte opc;
        String nombres, pasaporte, ciudad, barrio, marca, modelo;
        int numero;
        // Se crea el enlace
        Enlace c = new Enlace();
        do {
            System.out.println("Planes de Pago===========================");
            System.out.println("=========================================");
            System.out.println("Plan Postpago Minutos Megas Economico [1]");
            System.out.println("Plan Postpago Minutos                 [2]");
            System.out.println("Plan Postpago Megas                   [3]");
            System.out.println("Plan Postpago Minutos Megas           [4]");
            System.out.println("Salir                                 [0]");
            System.out.println("Seleccione: ");
            opc = sc.nextByte();
            sc.nextLine();

            if (opc == 1 || opc == 2 || opc == 3 || opc == 4) {

                System.out.println("Ingrese nombres del propietario:");
                nombres = sc.nextLine();
                System.out.println("Ingrese pasaporte propietario:");
                pasaporte = sc.nextLine();
                System.out.println("Ingrese ciudad propietario:");
                ciudad = sc.nextLine();
                System.out.println("Ingrese barrio del propietario:");
                barrio = sc.nextLine();
                System.out.println("Ingrese marca de celular:");
                marca = sc.nextLine();
                System.out.println("Ingrese modelo del celular:");
                modelo = sc.nextLine();
                System.out.println("Ingrese numero celular:");
                numero = sc.nextInt();

                switch (opc) {

                    case 1 -> {

                        System.out.print("Ingrese el número de minutos:");
                        int minutos = sc.nextInt();

                        System.out.print("Ingrese el costo de cada minuto:");
                        double costoMinutos = sc.nextDouble();

                        System.out.print("Ingrese el número de megas expresado en Gigas:");
                        int megas = sc.nextInt();

                        System.out.print("Ingrese el costo de cada Giga:");
                        double costoGiga = sc.nextDouble();
                        
                        System.out.print("Ingrese el Porcentaje de descuento:");
                        double desc = sc.nextDouble();

                        sc.nextLine();
                        
                        

                        PlanPostPagoMinMegasEco p = new PlanPostPagoMinMegasEco(nombres,
                                pasaporte,
                                ciudad,
                                barrio,
                                marca,
                                modelo,
                                numero,
                                minutos,
                                costoMinutos,
                                megas,
                                costoGiga, desc);
                        
                        p.calcularPagoMensualTotal();
                        

                        c.insertarPlanPostPagoMinutosMegasEconomico(p);
                        //System.out.println("Plan creado con exito!");

                    }
                    case 2 -> {

                        System.out.print("Ingrese el número de minutos nacionales:");
                        int minutosN = sc.nextInt();

                        System.out.print("Ingrese el costo de cada minuto nacional:");
                        double costoMinutosN = sc.nextDouble();

                        System.out.print("Ingrese el número de mintos internacionales:");
                        int minutosI = sc.nextInt();

                        System.out.print("Ingrese el costo de minuto internacional:");
                        double costoMinutosI = sc.nextDouble();

                        sc.nextLine();
                        PlanPostPagoMin p = new PlanPostPagoMin(nombres,
                                pasaporte,
                                ciudad,
                                barrio,
                                marca,
                                modelo,
                                numero,
                                minutosN,
                                costoMinutosN,
                                minutosI,
                                costoMinutosI);

                        p.calcularPagoMensualTotal();
                        c.insertarPlanPostPagoMinutos(p);
                    }
                    case 3 -> {

                        System.out.print("Ingrese el número de megas expresado en Gigas:");
                        int megas = sc.nextInt();

                        System.out.print("Ingrese el costo de cada Giga:");
                        double costoGiga = sc.nextDouble();

                        System.out.print("Ingrese la tarifa base: ");
                        double tarifa = sc.nextDouble();

                        sc.nextLine();

                        PlanPostPagoMegas p = new PlanPostPagoMegas(nombres,
                                pasaporte,
                                ciudad,
                                barrio,
                                marca,
                                modelo,
                                numero,
                                megas,
                                costoGiga,
                                tarifa);
                        p.calcularPagoMensualTotal();
                        c.insertarPlanPostPagoMegas(p);

                    }

                    case 4 -> {

                        System.out.print("Ingrese el número de minutos:");
                        int minutos = sc.nextInt();

                        System.out.print("Ingrese el costo de cada minuto:");
                        double costoMinutos = sc.nextDouble();

                        System.out.print("Ingrese el número de megas expresado en Gigas:");
                        int megas = sc.nextInt();

                        System.out.print("Ingrese el costo de cada Giga:");
                        double costoGiga = sc.nextDouble();

                        sc.nextLine();

                        PlanPostPagoMinutosMegas p = new PlanPostPagoMinutosMegas(nombres,
                                pasaporte,
                                ciudad,
                                barrio,
                                marca,
                                modelo,
                                numero,
                                minutos,
                                costoMinutos,
                                megas,
                                costoGiga);
                        p.calcularPagoMensualTotal();

                        c.insertarPlanPostPagoMinutosMegas(p);
                    }

                    case 0 -> {
                        opc = 0;
                    }
                    default -> {
                        System.out.println("Opcion Incorrecta!");
                    }

                }
            }

        } while (opc != 0);

        c.establecerListaPlanPostPagoMegas();
        c.establecerListaPlanPostPagoMinutos();
        c.establecerListaPlanPostPagoMinutosMegas();
        c.establecerListaPlanPostPagoMinutosMegasEconomico();
        
        
        
        if (c.obtenerLista().size()==0) {
            System.out.println("No hay nada que mostrar");
        } else {
            for (int i = 0; i < c.obtenerLista().size(); i++) {
                System.out.printf("%s\n", c.obtenerLista().get(i));
            } 
        }

        

    }

}
