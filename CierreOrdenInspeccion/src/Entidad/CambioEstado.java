package Entidad;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
public class CambioEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate fechaHoraInicio;
    private LocalDate fechaHoraFin;
    
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "cambioEstado_motivoFueraSevicio",
        joinColumns = @JoinColumn(name = "cambioEstado_id"),
        inverseJoinColumns = @JoinColumn(name = "motivoFueraSevicio_id")
    )
    private ArrayList<MotivoFueraServicio> motivos;
    

    //Constructor vacío
    public CambioEstado(){
    }

    //Constructor con parámetros
    public CambioEstado(LocalDate fechaHoraInicio, Estado estado, Empleado empleado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.empleado = empleado;
        this.motivos = new ArrayList();
    }
    

    //Getters y Setters
    public LocalDate getFechaHoraInicio() {
        return fechaHoraInicio;
    }   
    public void setFechaHoraInicio(LocalDate fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }   
    public LocalDate getFechaHoraFin() {
        return fechaHoraFin;
    }
    public void setFechaHoraFin(LocalDate fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void crearMotivoFueraServicio(ArrayList<TipoMotivo> tipoMotivos, ArrayList<String> comentarios){
        ArrayList<MotivoFueraServicio> Motivos = new ArrayList();
        for(int i= 0; i <tipoMotivos.size();i++){
            this.motivos.add(new MotivoFueraServicio(tipoMotivos.get(i),comentarios.get(i)));
        }
        
    }
    
    //Es Ultimo Cambio de Estado
    public boolean esUltimoCambioEstado(){
        if (this.fechaHoraFin == null){
            return true ;
        }else{
            return false;
        }
    }
    
    
}

