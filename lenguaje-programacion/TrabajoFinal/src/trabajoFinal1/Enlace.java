//
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoFinal1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete2.*;

/**
 *
 * @author jean
 */
public class Enlace {

    private Connection conn;
    private ArrayList<PlanCelular> lista = new ArrayList<>();

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/PlanesCelulares.bd";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarPlanPostPagoMinutos(PlanPostPagoMin plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMinutos(nombre,"
                    + "pasaporte, ciudad, barrio, marca, modelo, numero, minutosNacionales,"
                    + "costoNacional, minutosInternacionales, costoInternacional, pago)"
                    + "values ('%s', '%s','%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s)",
                    plan.obtenerNombres(),
                    plan.obtenerPasaporte(),
                    plan.obtenerCiudad(),
                    plan.obtenerBarrio(),
                    plan.obtenerMarca(),
                    plan.obtenerModelo(),
                    plan.obtenerNumCelular(),
                    plan.obtenerNumMinNacionales(),
                    plan.obtenerCostMinNacionales(),
                    plan.obtenerNumMinInternacio(),
                    plan.obtenerCostMinInternacio(),
                    plan.obtenerPagoMensualTotal());

            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public void insertarPlanPostPagoMegas(PlanPostPagoMegas plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMegas(nombre,"
                    + "pasaporte, ciudad, barrio, marca, modelo, numero, gigas,"
                    + "costoGiga, tarifa, pago)"
                    + "values ('%s', '%s','%s', '%s', '%s', '%s', '%s', %s, "
                    + "%s, %s, %s)",
                    plan.obtenerNombres(),
                    plan.obtenerPasaporte(),
                    plan.obtenerCiudad(),
                    plan.obtenerBarrio(),
                    plan.obtenerMarca(),
                    plan.obtenerModelo(),
                    plan.obtenerNumCelular(),
                    plan.obtenerMegas(),
                    plan.obtenerCostoMegas(),
                    plan.obtenerTarifaBase(),
                    plan.obtenerPagoMensualTotal());

            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public void insertarPlanPostPagoMinutosMegas(PlanPostPagoMinutosMegas plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String dataa = String.format("INSERT INTO planPostPagoMinutosMegas(nombre,"
                    + "pasaporte, ciudad, barrio, marca, modelo, numero, minutos,"
                    + "costoMinutos, gigas, costoGiga, pago)"
                    + "values ('%s', '%s','%s', '%s', '%s', '%s', '%s', %s,"
                    + "%s, %s, %s, %s)",
                    plan.obtenerNombres(),
                    plan.obtenerPasaporte(),
                    plan.obtenerCiudad(),
                    plan.obtenerBarrio(),
                    plan.obtenerMarca(),
                    plan.obtenerModelo(),
                    plan.obtenerNumCelular(),
                    plan.obtenerMinutos(),
                    plan.obtenerCostoMin(),
                    plan.obtenerMegas(),
                    plan.obtenerCostoGiga(),
                    plan.obtenerPagoMensualTotal());

            statement.executeUpdate(dataa);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public void insertarPlanPostPagoMinutosMegasEconomico(PlanPostPagoMinMegasEco plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMinutosMegasEconomico"
                    + "(nombre, pasaporte, ciudad, barrio, marca, modelo, "
                    + "numero, minutos, costoMinutos, gigas, costoGigas, "
                    + "descuento, pago)"
                    + "values ('%s', '%s','%s', '%s', '%s', '%s', '%s',"
                    + "%s, %s, %s, %s, %s, %s)",
                    plan.obtenerNombres(),
                    plan.obtenerPasaporte(),
                    plan.obtenerCiudad(),
                    plan.obtenerBarrio(),
                    plan.obtenerMarca(),
                    plan.obtenerModelo(),
                    plan.obtenerNumCelular(),
                    plan.obtenerMinutos(),
                    plan.obtenerCostoMin(),
                    plan.obtenerMegas(),
                    plan.obtenerCostoGiga(),
                    plan.obtenerPorcentaje(),
                    plan.obtenerPagoMensualTotal());

            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }
    
    
    
    

    public void establecerListaPlanPostPagoMinutos() {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();

            String data = "Select * from planPostPagoMinutos;";
            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {

                PlanPostPagoMin plan = new PlanPostPagoMin(
                        rs.getString("nombre"),
                        rs.getString("pasaporte"),
                        rs.getString("ciudad"),
                        rs.getString("barrio"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("numero"),
                        rs.getInt("minutosNacionales"),
                        rs.getDouble("costoNacional"),
                        rs.getInt("minutosInternacionales"),
                        rs.getDouble("costoInternacional"));
                plan.calcularPagoMensualTotal();

                lista.add(plan);

                obtenerConexion().close();
            }

        } catch (SQLException e) {
            System.out.println("Exception: insertarPlan");
            System.out.println(e.getMessage());

        }
    }

    public void establecerListaPlanPostPagoMegas() {

       try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMegas";
            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                
                PlanPostPagoMegas plan = new PlanPostPagoMegas(
                        rs.getString("nombre"),
                        
                        rs.getString("pasaporte"),
                        rs.getString("ciudad"),
                        rs.getString("barrio"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("numero"),
                        rs.getDouble("gigas"),
                        rs.getDouble("costoGiga"),
                        rs.getDouble("tarifa"));
                
                plan.calcularPagoMensualTotal();

                lista.add(plan);
            }
            obtenerConexion().close();
        } catch (SQLException e) {
            System.err.println("Exception: DATA ");
            System.out.println(e.getMessage());
        }
    }
    
    

    public void establecerListaPlanPostPagoMinutosMegas() {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();

            String data3 = "Select * from planPostPagoMinutosMegas;";
            ResultSet rs = statement.executeQuery(data3);
            while (rs.next()) {

                PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(
                        rs.getString("nombre"),
                        rs.getString("pasaporte"),
                        rs.getString("ciudad"),
                        rs.getString("barrio"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("numero"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinutos"),
                        rs.getInt("gigas"),
                        rs.getDouble("costoGiga"));
                plan.calcularPagoMensualTotal();
                lista.add(plan);
            }

        } catch (SQLException e) {
            System.out.println("Exception: insertarPlan");
            System.out.println(e.getMessage());

        }
    }

    public void establecerListaPlanPostPagoMinutosMegasEconomico() {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();

            String data4 = "Select * from planPostPagoMinutosMegasEconomico;";
            ResultSet rs = statement.executeQuery(data4);
            while (rs.next()) {

                PlanPostPagoMinMegasEco plan = new PlanPostPagoMinMegasEco(
                        rs.getString("nombre"),
                        rs.getString("pasaporte"),
                        rs.getString("ciudad"),
                        rs.getString("barrio"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("numero"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinutos"),
                        rs.getInt("gigas"),
                        rs.getDouble("costoGigas"),
                        rs.getDouble("descuento"));
                plan.calcularPagoMensualTotal();
                lista.add(plan);
            }

        } catch (SQLException e) {
            System.out.println("Exception: insertarPlan");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanCelular> obtenerLista() {
        return lista;
    }

}
