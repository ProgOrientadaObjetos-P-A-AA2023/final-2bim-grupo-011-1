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

                        System.out.println("Ingrese el numero de minutos nacionales"
                                + " a contratar");
                        int minutosNacionales = sc.nextInt();

                        System.out.println("Ingrese el costo del minuto nacional:");
                        double costoMinutoNacional = sc.nextDouble();

                        System.out.println("Ingrese el numero de minutos internacionales"
                                + " a contratar:");
                        int minutosInternacionales = sc.nextInt();

                        System.out.println("Ingrese el costo del minuto internacional:");
                        double costoMinutoInternacional = sc.nextDouble();

                        PlanPostPagoMin planminutos = new PlanPostPagoMin(nombres,
                                pasaporte,
                                ciudad,
                                barrio,
                                marca,
                                modelo,
                                numero,
                                minutosNacionales,
                                costoMinutoNacional,
                                minutosInternacionales,
                                costoMinutoInternacional);

                        planminutos.calcularPagoMensualTotal();
                        c.insertarPlanPostPagoMinutos(planminutos);
                        System.out.println("Plan creado con exito!");

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

        c.establecerListaPlanCelular();

        System.out.println("=".repeat(75));
        for (int i = 0; i < c.obtenerLista().size(); i++) {
            System.out.printf("  Plan (%d):\n%s\n", i + 1, c.obtenerLista().get(i));
        }

    }

}
