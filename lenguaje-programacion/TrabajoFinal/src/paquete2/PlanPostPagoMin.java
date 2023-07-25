/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 *
 * @author sebas
 *
 * minutos nacionales|costo minuto nacional|minutos internacionales|costo minuto
 * internacional
 *
 */
public class PlanPostPagoMin extends PlanCelular {

    

    private int numMinNacionales;
    private double costMinNacionales;
    private int numMinInternacio;
    private double costMinInternacio;
    
     public PlanPostPagoMin(String nombreApellidoP,
            String pasaporteP, String ciudadP,
            String barrioP, String marcaC, String modeloC,
            int numeroC, int minutosNa,
            double costoMinutoNa, int minutosInter,
            double costoMinutoInter) {

        // Super
        super(nombreApellidoP, pasaporteP, ciudadP, barrioP,
                marcaC, modeloC, numeroC);

        // Inicialización de los atributos específicos de este tipo de plan
        numMinNacionales = minutosNa;
        costMinNacionales = costoMinutoNa;
        numMinInternacio = minutosInter;
        costMinInternacio = costoMinutoInter;

    }

    public void establecerNumMinNacionales(int numMinNacionales) {
        this.numMinNacionales = numMinNacionales;
    }

    public void establecerCostMinNacionales(double costMinNacionales) {
        this.costMinNacionales = costMinNacionales;
    }

    public void establecerNumMinInternacio(int numMinInternacio) {
        this.numMinInternacio = numMinInternacio;
    }

    public void establecerCostMinInternacio(double costMinInternacio) {
        this.costMinInternacio = costMinInternacio;
    }

    public int obtenerNumMinNacionales() {
        return numMinNacionales;
    }

    public double obtenerCostMinNacionales() {
        return costMinNacionales;
    }

    public int obtenerNumMinInternacio() {
        return numMinInternacio;
    }

    public double obtenerCostMinInternacio() {
        return costMinInternacio;
    }

    @Override
    public void calcularPagoMensualTotal() {
        pagoMensualTotal = (numMinNacionales * costMinNacionales) + (numMinInternacio * costMinInternacio);

    }

    @Override
    public String toString() {

        String cadena = String.format("========Plan Post-Pago Minutos=======\n");

        cadena = String.format("%s%s", cadena, super.toString());

        cadena = String.format("%sNumero de minutos Nacionales: %d\n"
                + "Costo de los minutos Nacionales: %.2f\n"
                + "Numero de minutos Internacionales: %d\n"
                + "Costo de los minutos Internacionales: %.2f\n"
                + "Pago total: %.2f\n",
                cadena, obtenerNumMinNacionales(),
                obtenerCostMinNacionales(),
                obtenerNumMinInternacio(),
                obtenerCostMinInternacio(),
                obtenerPagoMensualTotal());

        return cadena;

    }

}
