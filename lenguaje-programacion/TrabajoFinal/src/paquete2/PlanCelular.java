/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 * @author sebas nombre y apellidos propietario tipo (tipo cadena) pasaporte
 * propietario (tipo cadena) ciudad propietario (tipo cadena) barrio del
 * propietario marca de celular modelo del celular numero celular pago mensual
 *
 */
public abstract class PlanCelular {

    protected String nombres;
    protected String pasaporte;
    protected String ciudad;
    protected String barrio;
    protected String marca;
    protected String modelo;
    protected int numCelular;
    protected double pagoMensualTotal;
    
    public PlanCelular(String nombreApellidoP, String pasaporteP,
            String ciudadP, String barrioP,
            String marcaC, String modeloC,
            int numeroC) {

        nombres = nombreApellidoP;
        pasaporte = pasaporteP;
        ciudad = ciudadP;
        barrio = barrioP;
        marca= marcaC;
        modelo = modeloC;
        numCelular = numeroC;

    }

    public abstract void calcularPagoMensualTotal();

    public void establecerNombre(String nombre) {
        this.nombres = nombre;
    }



    public void establecerPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public void establecerCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void establecerBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void establecerMarca(String marca) {
        this.marca = marca;
    }

    public void establecerModelo(String modelo) {
        this.modelo = modelo;
    }

    public void establecerNumCelular(int numCelular) {
        this.numCelular = numCelular;
    }

    public String obtenerNombres() {
        return nombres;
    }



    public String obtenerPasaporte() {
        return pasaporte;
    }

    public String obtenerCiudad() {
        return ciudad;
    }

    public String obtenerBarrio() {
        return barrio;
    }

    public String obtenerMarca() {
        return marca;
    }

    public String obtenerModelo() {
        return modelo;
    }

    public int obtenerNumCelular() {
        return numCelular;
    }

    public double obtenerPagoMensualTotal() {
        return pagoMensualTotal;
    }

    @Override
    public String toString() {

        String cadena = String.format("---Datos del consumidor---\n");

        cadena = String.format("%sNombre: %s\n"
                + "Pasaporte: %s\n"
                + "Ciudad: %s\n"
                + "Barrio: %s\n"
                + "Marca del teléfono: %s\n"
                + "Modelo: %s\n"
                + "Número celular: %s\n",
                cadena, obtenerNombres(), 
                obtenerPasaporte(), obtenerCiudad(),
                obtenerBarrio(), obtenerMarca(), obtenerModelo(),
                obtenerNumCelular());

        return cadena;
    }

}
