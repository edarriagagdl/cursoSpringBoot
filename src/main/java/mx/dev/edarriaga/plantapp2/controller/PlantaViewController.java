package mx.dev.edarriaga.plantapp2.controller;

import lombok.AllArgsConstructor;
import mx.dev.edarriaga.plantapp2.model.Planta;
import mx.dev.edarriaga.plantapp2.model.Prospecto;
import mx.dev.edarriaga.plantapp2.service.JardineroService;
import mx.dev.edarriaga.plantapp2.service.PlantaService;
import mx.dev.edarriaga.plantapp2.service.ProspectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PlantaViewController {
    // En esta vista la idea es que en una pantalla pueda visualizar los detalles de mi planta
    // y a la derecha pueda visualizar el jardinero y los prospectos.
    // Es por eso que necesito los servicios de jardinero y prospectos
   private final PlantaService plantaService;
   private final JardineroService jardineroService;
   private final ProspectoService prospectoService;

   @GetMapping ("/plantas")
   public String listarPlantas (Model model)
   {
       model.addAttribute("plantas", plantaService.listarPlantas());
       return "listaPlantas";
   }

   @GetMapping ("/agregarPlanta")
   public String agregarPlanta (Model model)
   {
       model.addAttribute("jardineros", jardineroService.listarJardineros());
       model.addAttribute("prospectos", prospectoService.listarProspectos());
       model.addAttribute("planta", new Planta());
       return "agregarPlantaForm";
   }

   @PostMapping ("/guardarPlanta")
   public String guardarPlanta (@ModelAttribute Planta planta, @RequestParam Long idJardinero, @RequestParam(required = false) List<Long> prospectos)
   {
       plantaService.guardarPlanta(planta, idJardinero, prospectos);
       return "redirect:/plantas";
   }

   @GetMapping ("/eliminarPlanta/{id}")
   public String eliminarPlanta(@PathVariable Long id) {
     plantaService.borrarPlanta(id);
     return "redirect:/plantas";
   }

   @GetMapping ("/actualizarPlanta/{id}")
    public String mostrarFormuladorActualizarPlanta(@PathVariable Long id, Model model) {
       Planta planta = plantaService.obtenerPlantaPorId(id);
       model.addAttribute("planta", planta);
       model.addAttribute("prospectos", prospectoService.listarProspectos());
       model.addAttribute("jardineros", jardineroService.listarJardineros());
      return "actualizarPlantaForm";
   }

   @PostMapping ("/actualizarPlanta/{idPlanta}")
    public String actualizarPlanta(@PathVariable Long idPlanta, @ModelAttribute Planta plantaActualizada, @RequestParam Long idJardinero, @RequestParam(required = false) List<Long> idProspectos) {
       plantaService.actualizarPlanta(idPlanta, plantaActualizada, idJardinero, idProspectos);
       return "redirect:/plantas";
   }

}
