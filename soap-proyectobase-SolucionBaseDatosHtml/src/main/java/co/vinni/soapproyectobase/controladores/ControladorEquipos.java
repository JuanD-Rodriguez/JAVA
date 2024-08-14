package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.EquipoDto;
import co.vinni.soapproyectobase.servicios.ServicioEquipos;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class ControladorEquipos {
    private static final Logger logger = LogManager.getLogger(ControladorEquipos.class);

    @Autowired
    ServicioEquipos servicioEquipos;

    @GetMapping({  "/equipos"})
    public String listarTecnicos(Model model){
        logger.info("Verificando ");
        model.addAttribute("equipos",servicioEquipos.obtenerTecnico());
        return "equipos";
    }
    @GetMapping("/equipos/nuevo")
    public String mostrarFormulario(Model model){
        EquipoDto equipoDto = new EquipoDto();
        model.addAttribute("equipo", equipoDto);
        return "crear_Tecnico";
    }
    @PostMapping("/equipos")
    public String registrarEquipo(@ModelAttribute("ëquipo") EquipoDto equipo) {
        servicioEquipos.registrarTecnico(equipo);
        return "redirect:/equipos";
    }


    @GetMapping("/equipos/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        EquipoDto equipoDto = new EquipoDto();
        model.addAttribute("equipo", servicioEquipos.obtenerTecnico(serial));
        return "editar_Tecnico";
    }

    @PostMapping("/equipos/{serial}")
    public String modificarTecnico(@PathVariable long serial,@ModelAttribute( "equipo") EquipoDto equipoDto, Model model){


        model.addAttribute("equipo", servicioEquipos.actualizarTecnico(equipoDto));
        return "redirect:/equipos";
    }
    @GetMapping("/equipos/{serial}")
    public String eliminarTecnico(@PathVariable long serial){

        servicioEquipos.eliminarTecnico(serial);

        return "redirect:/equipos";
    }
}
