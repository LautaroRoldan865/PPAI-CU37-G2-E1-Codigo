/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.util.ArrayList;

/**
 *
 * @author Lautaro Roldan
 */
public class IteradorOrdenDeInspeccion implements IIterador{
    
    public ArrayList<OrdenInspeccion> objetos;
    public String[] filtros;
    private int indice = 0;

    public IteradorOrdenDeInspeccion(ArrayList<OrdenInspeccion> objetos, String[] filtros) {
        this.objetos = objetos;
        this.filtros = filtros;
    }
    
    @Override
    public Object primero() {
       this.indice = 0;
       return this.objetos.get(this.indice);
    }

    @Override
    public void siguiente() {
        this.indice ++;
    }
    
    @Override
    public boolean haTerminado() {
       if(this.indice >= this.objetos.size()){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public Object actual() {
        if(this.cumpleFiltro(this.filtros)){
           return this.objetos.get(this.indice);
        }else{
            return null;
        }
    }

    @Override
    public boolean cumpleFiltro(String[] filtros) {
       boolean var = true;
       Long id = Long.parseLong(filtros[0]);
       OrdenInspeccion ActualOI = this.objetos.get(this.indice);
       if(ActualOI.esDeEmpleado(id)&&(ActualOI.esCompletamenteRealizada()!= null)){
           return true;
       }else{
           return false;
       }
    }
    
}
