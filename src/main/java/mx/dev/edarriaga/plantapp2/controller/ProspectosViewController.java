package mx.dev.edarriaga.plantapp2.controller;

import lombok.AllArgsConstructor;
import mx.dev.edarriaga.plantapp2.model.Prospecto;
import mx.dev.edarriaga.plantapp2.service.ProspectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProspectosViewController {
    private final ProspectoService prospectoService;

    @GetMapping("/prospectos")
    public String listarProspectos(Model model) {
        model.addAttribute("prospectos", prospectoService.listarProspectos());
        return "listaProspectos";
    }

    @GetMapping("/agregarProspecto")
    public String mostrarFormularioNuevoProspecto(Model model) {
        model.addAttribute("prospecto", new Prospecto());
        return "agregarProspectoForm";
    }

    @PostMapping("/guardarProspecto")
    public String guardarProspecto(@ModelAttribute Prospecto prospecto) {
        prospectoService.guardarProspecto(prospecto);
        return "redirect:/prospectos";
    }

}
