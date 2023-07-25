/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 *
 * @author sebas
 *
 * megas expresado en gigas|costo por cada giga|tarifa base
 */
public class PlanPostPagoMegas extends PlanCelular {

   

    private double megas;
    private double costoMegas;
    private double tarifaBase;

  public PlanPostPagoMegas(String nombreApellidoP,
            String pasaporteP, String ciudadP,
            String barrioP, String marcaC, String modeloC,
            int numeroC, double megasEnG, double costoPorG,
            double tarifaB) {
        // Super
        super(nombreApellidoP, pasaporteP, ciudadP, barrioP, marcaC, modeloC,
                numeroC);

        // Inicialización de los atributos específicos de este tipo de plan
        megas = megasEnG;
        costoMegas = costoPorG;
        tarifaBase = tarifaB;

    }

    @Override
    public void calcularPagoMensualTotal() {
        pagoMensualTotal = tarifaBase + (megas * costoMegas);
    }

    public void establecerMegas(double megas) {
        this.megas = megas;
    }

    public void establecerCostoMegas(double costoMegas) {
        this.costoMegas = costoMegas;
    }

    public void establecerTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double obtenerMegas() {
        return megas;
    }

    public double obtenerCostoMegas() {
        return costoMegas;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }

    @Override
    public String toString() {

        String cadena = String.format("========Plan Post-Pago Megas=======\n");

        cadena = String.format("%s%s", cadena, super.toString());

        cadena = String.format("%sNumero de megas(expresado en gigas): %.1f\n"
                + "Costo de las Megas: %.2f\nTarifa Base: %.2f\nPago total: %.2f\n",
                 cadena, obtenerMegas(), obtenerCostoMegas(),
                obtenerTarifaBase(), obtenerPagoMensualTotal());

        return cadena;

    }

}
