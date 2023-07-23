/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajofinal;

import paquete2.*;

/**
 *
 * @author sebas
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlanPostPagoMegas p1 = new PlanPostPagoMegas();
        p1.establecerNombre("Ana");
        p1.establecerApellido("Mendoza");
        p1.establecerPasaporte("IJASKAJS-023232930");
        p1.establecerCiudad("Loja");
        p1.establecerBarrio("Las Zarzas");
        p1.establecerMarca("Apple");
        p1.establecerModelo("Iphone 14");
        p1.establecerNumCelular(995394592);
        p1.establecerCostoMegas(4);
        p1.establecerMegas(3);
        p1.establecerTarifaBase(10);
        p1.calcularpagoMensualTotal();
        System.out.println(p1);

        PlanPostPagoMinMegasEco p2 = new PlanPostPagoMinMegasEco();
        p2.establecerNombre("Pedro");
        p2.establecerApellido("Castillo");
        p2.establecerPasaporte("212121-ISFVBJKLVCASKBJ");
        p2.establecerCiudad("Cuenca");
        p2.establecerBarrio("Los Zarzos");
        p2.establecerMarca("Chaomi");
        p2.establecerModelo("Iphone 9");
        p2.establecerNumCelular(8438232);
        p2.establecerMinutos(10);
        p2.establecerCostoMin(2);
        p2.establecerMegas(10);
        p2.establecerCostoGiga(3);
        p2.establecerPorcentaje(50);
        p2.calcularpagoMensualTotal();
        System.out.println(p2);

    }

}
