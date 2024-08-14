package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.entidades.Equipo;
import co.vinni.soapproyectobase.repositorios.RespositorioEquipo;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.Serializable;
@Service
public class ServicioEquipos implements Serializable {

    @Autowired
    RespositorioEquipo repoEquipo;

//    public void registrarEquipo(Equipo equipo) {
//    respositorioEquipo.save(equipo);
//    }
}
