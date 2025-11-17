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
public class IteradorSismografo implements IIterador{

    public ArrayList<Sismografo> objetos;
    public String[] filtros;
    private int indice = 0;
    private String nombreEstacionSismologica;

    public IteradorSismografo(ArrayList<Sismografo> objetos, String[] filtros, String nombreEstacionSismografo ) {
        this.objetos = objetos;
        this.filtros = filtros;
        this.nombreEstacionSismologica = nombreEstacionSismografo;
    }
    
    @Override
    public Object primero() {
        indice = 0;
        return this.objetos.get(this.indice);
    }

    @Override
    public void siguiente() {
        this.indice ++;
    }

    @Override
    public boolean cumpleFiltro(String[] filtros) {
        boolean cond = true;
        if(!(this.objetos.get(this.indice).esTuEstacion(this.nombreEstacionSismologica))){
            cond = false;
        }
        return cond;
    }

    @Override
    public boolean haTerminado() {
        if(indice >= this.objetos.size()){
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
    
}
