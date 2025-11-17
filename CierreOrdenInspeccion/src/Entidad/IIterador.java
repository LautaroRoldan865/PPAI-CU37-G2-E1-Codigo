package Entidad;

public interface IIterador {

    Object primero();
    void siguiente();
    boolean cumpleFiltro(String[] filtros);
    boolean haTerminado();
    Object actual();
}
