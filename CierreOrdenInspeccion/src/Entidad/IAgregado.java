package Entidad;

import java.util.ArrayList;
import Entidad.OrdenInspeccion;

public interface IAgregado {

    IIterador crearIterador(ArrayList<OrdenInspeccion> ordenes,String[] filtros);
}
