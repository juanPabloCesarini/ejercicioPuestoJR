
package concesionaria;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juan Pablo
 */
public class Sucursal implements DataReader, DataProcessor{
  
    ArrayList<Vehiculo> listaVehiculos = new ArrayList();
 
    @Override
    public void crearSucursal(){
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();
        Moto moto1 = new Moto();
        Moto moto2 = new Moto();
        
        auto1.setMarca("Peugeot");
        auto1.setModelo("206");
        auto1.setPuertas("4");
        auto1.setPrecio (200000.00);
        
       
        auto2.setMarca("Peugeot");
        auto2.setModelo("208");
        auto2.setPuertas("5");
        auto2.setPrecio(250000.00);
        
                
        moto1.setMarca("Honda");
        moto1.setModelo("Titan");
        moto1.setCilindradas("125c");
        moto1.setPrecio(60000.00);
        
     
        moto2.setMarca("Yamaha");
        moto2.setModelo("YBR");
        moto2.setCilindradas("160c");
        moto2.setPrecio(80500.50);
        
        listaVehiculos.add(auto1);
        listaVehiculos.add(moto1);
        listaVehiculos.add(auto2);
        listaVehiculos.add(moto2);
    }

    @Override
    public void mostrarVehiculos() {
        int i;
        String patron = " $ ###,###,###.00";
        DecimalFormat formateo = new DecimalFormat(patron);
        for (i=0; i<listaVehiculos.size(); i++){
            String precioAMostrar = formateo.format(listaVehiculos.get(i).getPrecio());
            System.out.println (listaVehiculos.get(i).toString() + " // Precio: " + precioAMostrar);
        }
    }
    
    @Override
    public void mostrarMinMax(){
        int i;
        double min = 0;
        double max = 999999;
        String marcaMax = "";
        String modeloMax = "";
        String marcaMin = "";
        String modeloMin = "";
        
        for (i=0; i<listaVehiculos.size(); i++){
            if (listaVehiculos.get(i).getPrecio()>min){
                min = listaVehiculos.get(i).getPrecio();
                marcaMax = listaVehiculos.get(i).getMarca();
                modeloMax = listaVehiculos.get(i).getModelo();
            }
            if (listaVehiculos.get(i).getPrecio()<max){
                max = listaVehiculos.get(i).getPrecio();
                marcaMin = listaVehiculos.get(i).getMarca();
                modeloMin = listaVehiculos.get(i).getModelo();
            }
        }
        
        System.out.println("============================");
        System.out.println("Vehiculo más caro: " + marcaMax + " " + modeloMax);
        System.out.println("Vehiculo más barato: " + marcaMin + " " + modeloMin);
    }
        
    public void mostrarModeloY(){
          int i;
          String letraAbuscar = "Y";
          String marcaE;
          String precioE;
          String patron = " $ ###,###,###.00";
          DecimalFormat formateo = new DecimalFormat(patron);
          boolean modeloEncontrado = false;
          for (i=0; i<listaVehiculos.size(); i++){
              String modelo = listaVehiculos.get(i).getModelo();
              modeloEncontrado = modelo.contains(letraAbuscar);
              if (modeloEncontrado){
                marcaE = listaVehiculos.get(i).getMarca();
                String precioAMostrar = formateo.format(listaVehiculos.get(i).getPrecio());
                System.out.println("Vehículo que contiene en el modelo la letra 'Y': " + marcaE + " " + modelo + " " + precioAMostrar);
              }
          }
      }  
    
    public void mostrarOrdenados(){
       Collections.sort(listaVehiculos);
       int i;
       System.out.println("============================");
       System.out.println("Vehiculos ordendos por precio de mayor a menor");
       for (i=0; i<listaVehiculos.size(); i++){
            
            System.out.println(listaVehiculos.get(i).getMarca() +" "+ listaVehiculos.get(i).getModelo());
        }
    }
 }