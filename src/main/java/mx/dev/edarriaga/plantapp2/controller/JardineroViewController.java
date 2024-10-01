package mx.dev.edarriaga.plantapp2.controller;

import lombok.AllArgsConstructor;
import mx.dev.edarriaga.plantapp2.service.JardineroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor

public class JardineroViewController {

    private final JardineroService jardineroService;

    @GetMapping("/jardineros")
    public String listarJardineros (Model model) {
      model.addAttribute("jardineros", jardineroService.listarJardineros());
      return "listaJardineros";
    }







}
