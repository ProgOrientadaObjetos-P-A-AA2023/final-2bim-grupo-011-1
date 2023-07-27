/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 *
 * @author sebas
 *
 * minutos|costo minutos|megas expresado en gigas|costo por cada giga
 */
public class PlanPostPagoMinutosMegas extends PlanCelular {

    private int minutos;
    private double costoMin;
    private double megas;
    private double costoGiga;
    
    public PlanPostPagoMinutosMegas(String nombreApellidoP, String pasaporteP, String ciudadP,
            String barrioP, String marcaC, String modeloC, int numeroC, int m, double costoM, double megasEnG, double costoPorG) {
        // Super
        super(nombreApellidoP, pasaporteP, ciudadP, barrioP,
                marcaC, modeloC, numeroC);

        // Inicialización de los atributos específicos de este tipo de plan
        minutos = m;
        costoMin = costoM;
        megas = megasEnG;
        costoGiga = costoPorG;


    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setCostoMin(double costoMin) {
        this.costoMin = costoMin;
    }

    public void setMegas(double megas) {
        this.megas = megas;
    }

    public void setCostoGiga(double costoGiga) {
        this.costoGiga = costoGiga;
    }

    @Override
    public void calcularPagoMensualTotal() {
        pagoMensualTotal = (minutos * costoMin) + (megas * costoGiga);
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

    @Override
    public String toString() {

        String cadena = String.format("========Plan Post-Pago Minutos Megas=======\n");

        cadena = String.format("%s%s", cadena, super.toString());

        cadena = String.format("%sNumero de minutos: %d\n"
                + "Costo de los minutos: %.2f\n"
                + "Numero de Megas(expresado en gigas): %.1f\n"
                + "Costo de las Megas: %.2f\n"
                + "Total: %.2f\n",
                cadena, obtenerMinutos(),
                obtenerCostoMin(),
                obtenerMegas(),
                obtenerCostoGiga(),
                obtenerPagoMensualTotal());

        return cadena;

    }

}
