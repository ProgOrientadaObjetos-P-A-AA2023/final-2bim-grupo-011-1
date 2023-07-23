/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 *
 * @author sebas
 *
 * minutos|costo minutos|megas expresado en gigas|costo por cada
 * gigas|porcentaje de descuento (Ejemplo: 10%)
 */
public class PlanPostPagoMinMegasEco extends PlanCelular {

    private int minutos;
    private double costoMin;
    private double megas;
    private double costoGiga;
    private double porcentaje;

    public void establecerMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void establecerCostoMin(double costoMin) {
        this.costoMin = costoMin;
    }

    public void establecerMegas(double megas) {
        this.megas = megas;
    }

    public void establecerCostoGiga(double costoGiga) {
        this.costoGiga = costoGiga;
    }

    public void establecerPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje / 100;
    }

    @Override
    public void calcularpagoMensualTotal() {
        pagoMensualTotal = ((minutos * costoMin) + (megas * costoGiga)) * porcentaje;

    }

    public int obtenerMinutos() {
        return minutos;
    }

    public double obtenerCostoMin() {
        return costoMin;
    }

    public double obtenerMegas() {
        return megas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    public double obtenerPorcentaje() {
        return porcentaje;
    }

    @Override
    public String toString() {

        String cadena = String.format("========Plan Post-Pago Minutos Megas Económico=======\n");

        cadena = String.format("%s%s", cadena, super.toString());

        cadena = String.format("%sNumero de minutos: %d\n"
                + "Costo de los minutos: %.2f\n"
                + "Numero de Megas(expresado en gigas): %.1f\n"
                + "Costo de las Megas: %.2f\n"
                + "Porcentaje: %.2f\n"
                + "Total: %.2f\n",
                cadena, obtenerMinutos(),
                obtenerCostoMin(),
                obtenerMegas(),
                obtenerCostoGiga(),
                (obtenerPorcentaje() * 100), obtenerPagoMensualTotal());

        return cadena;

    }

}
